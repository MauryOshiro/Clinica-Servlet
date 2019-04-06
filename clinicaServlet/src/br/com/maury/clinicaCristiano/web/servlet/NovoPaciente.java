package br.com.maury.clinicaCristiano.web.servlet;

import java.io.IOException;
import java.math.BigInteger;
import java.sql.Connection;
import java.time.LocalDate;
import java.util.Collection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.maury.clinicaCristiano.atendimento.dao.ContatoPessoaFisicaDAO;
import br.com.maury.clinicaCristiano.atendimento.dao.ConvenioDAO;
import br.com.maury.clinicaCristiano.atendimento.dao.EnderecoDAO;
import br.com.maury.clinicaCristiano.atendimento.dao.PacienteConveniadoDAO;
import br.com.maury.clinicaCristiano.atendimento.dao.PacienteDAO;
import br.com.maury.clinicaCristiano.atendimento.dao.PessoaFisicaDAO;
import br.com.maury.clinicaCristiano.atendimento.modelo.ContatoPessoaFisica;
import br.com.maury.clinicaCristiano.atendimento.modelo.Convenio;
import br.com.maury.clinicaCristiano.atendimento.modelo.Endereco;
import br.com.maury.clinicaCristiano.atendimento.modelo.Paciente;
import br.com.maury.clinicaCristiano.jdbc.ConnectionPool;
import br.com.maury.clinicaCristiano.web.util.CaniveteSuico;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = "/novoPaciente")
public class NovoPaciente extends HttpServlet {

	private void buscaConvenios(HttpServletRequest req) {
		//ConnectionPool pool = new ConnectionPool();
		try (Connection con = ConnectionPool.getConnection()) {
			//Connection con = pool.getConnection();
			ConvenioDAO convenioDAO = new ConvenioDAO(con);
			
			Collection<Convenio> convenios = convenioDAO.buscaConvenio();
			req.setAttribute("convenios", convenios);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if(FiltroDeAuditoria.acessoValido(req, resp)) {
			buscaConvenios(req);
			RequestDispatcher dispatcher = req
					.getRequestDispatcher("WEB-INF/paginas/atendimento/cadastrarNovoPaciente.jsp");
			dispatcher.forward(req, resp);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String nome = req.getParameter("nomePaciente");
		String sobrenome = req.getParameter("sobrenomePaciente");
		String sexo = req.getParameter("sexoPaciente");
		String rg = req.getParameter("rgPaciente");
		//BigInteger cpf = converteCpfStringParaBigInteger(req.getParameter("cpfPaciente"));
		BigInteger cpf = CaniveteSuico.converteCpfStringParaBigInteger(req.getParameter("cpfPaciente"));
		String dataNascimentoPaciente = req.getParameter("dataNascimentoPaciente");
		LocalDate dataNascimento = CaniveteSuico.converteDataStringParaLocalDate(dataNascimentoPaciente);
		Integer idade = CaniveteSuico.calculaIdade(dataNascimento);
		Boolean possuiConvenio = Boolean.valueOf(req.getParameter("possuiConvenio"));
		Integer convenio = Integer.valueOf(req.getParameter("idConvenio"));
		String nivelEscolaridade = req.getParameter("nivelEscolaridadePaciente");

		String tipoVia = req.getParameter("tipoViaPaciente");
		String logradouro = req.getParameter("logradouroPaciente");
		Integer logradouroNumero = Integer.valueOf(req.getParameter("logradouroNumeroPaciente"));
		String complemento = req.getParameter("complementoPaciente");
		String bairro = req.getParameter("bairroPaciente");
		String cep = req.getParameter("cepPaciente");
		String uf = req.getParameter("ufPaciente");
		String cidade = req.getParameter("cidadePaciente");

		String telefonePrincipalPaciente = req.getParameter("telefonePrincipalPaciente");
		Integer dddTelefonePrincipal = 0;
		Integer telefonePrincipal = 0;
		if(!telefonePrincipalPaciente.isEmpty()) {
			dddTelefonePrincipal = ContatoPessoaFisica.converteDDDParaInteger(telefonePrincipalPaciente);
			telefonePrincipal = ContatoPessoaFisica.converteTelefoneParaInteger(telefonePrincipalPaciente);
		}

		String telefoneSecundarioPaciente = req.getParameter("telefoneSecundarioPaciente");
		Integer dddTelefoneSecundario = 0;
		Integer telefoneSecundario = 0;
		if(!telefoneSecundarioPaciente.isEmpty()) {
			dddTelefoneSecundario = ContatoPessoaFisica.converteDDDParaInteger(telefoneSecundarioPaciente);
			telefoneSecundario = ContatoPessoaFisica.converteTelefoneParaInteger(telefoneSecundarioPaciente);
		}

		String celularPrincipalPaciente = req.getParameter("celularPrincipalPaciente");
		Integer dddCelularPrincipal = 0;
		Integer celularPrincipal = 0;
		if(!celularPrincipalPaciente.isEmpty()) {
			dddCelularPrincipal = ContatoPessoaFisica.converteDDDParaInteger(celularPrincipalPaciente);
			celularPrincipal = ContatoPessoaFisica.converteCelularParaInteger(celularPrincipalPaciente);
		}

		String celularSecundarioPaciente = req.getParameter("celularSecundarioPaciente");
		Integer dddCelularSecundario = 0;
		Integer celularSecundario = 0;
		if(!celularSecundarioPaciente.isEmpty()) {
			dddCelularSecundario = ContatoPessoaFisica.converteDDDParaInteger(celularSecundarioPaciente);
			celularSecundario = ContatoPessoaFisica.converteCelularParaInteger(celularSecundarioPaciente);
		}

		String email = req.getParameter("emailPaciente");
		String observacao = req.getParameter("observacaoPaciente");

		//ConnectionPool pool = new ConnectionPool();
		try (Connection con = ConnectionPool.getConnection()) {
			//Connection con = pool.getConnection();
			// Desativa o autocommit. É necessário realizar o commit ou rollback
			con.setAutoCommit(false);

			ContatoPessoaFisica contato = new ContatoPessoaFisica(dddTelefonePrincipal, telefonePrincipal,
					dddTelefoneSecundario, telefoneSecundario, dddCelularPrincipal, celularPrincipal,
					dddCelularSecundario, celularSecundario, email);

			ContatoPessoaFisicaDAO contatoDAO = new ContatoPessoaFisicaDAO(con);
			if(contatoDAO.gravar(contato)) {
				Endereco endereco = new Endereco(tipoVia, logradouro, cep, logradouroNumero, complemento, bairro,
						cidade, uf);

				EnderecoDAO enderecoDAO = new EnderecoDAO(con);
				
				if(enderecoDAO.gravar(endereco)) {
					Paciente paciente = new Paciente(possuiConvenio, "NOVO", nome, sobrenome, rg, cpf, dataNascimento,
							observacao, endereco, true, contato, sexo, nivelEscolaridade, idade);
					
					PessoaFisicaDAO pfDAO = new PessoaFisicaDAO(con);
					
					if(pfDAO.gravar(paciente)) {
						PacienteDAO pacienteDAO = new PacienteDAO(con);
						if(pacienteDAO.gravar(paciente)) {
							if(possuiConvenio) {
								PacienteConveniadoDAO pcDAO = new PacienteConveniadoDAO(con);
								if(pcDAO.gravar(convenio, paciente.getIdPaciente())) {
									con.commit();
								} else {
									con.rollback();
								}
							} else {
								con.commit();
							}
						}
					}
				}
			}
			RequestDispatcher dispatcher = req.getRequestDispatcher("WEB-INF/paginas/principal.jsp");
			dispatcher.forward(req, resp);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
