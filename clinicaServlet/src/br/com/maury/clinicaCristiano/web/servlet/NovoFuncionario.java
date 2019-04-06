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

import br.com.maury.clinicaCristiano.atendimento.dao.CargoDAO;
import br.com.maury.clinicaCristiano.atendimento.dao.ContatoPessoaFisicaDAO;
import br.com.maury.clinicaCristiano.atendimento.dao.EnderecoDAO;
import br.com.maury.clinicaCristiano.atendimento.dao.FuncionarioDAO;
import br.com.maury.clinicaCristiano.atendimento.dao.PessoaFisicaDAO;
import br.com.maury.clinicaCristiano.atendimento.dao.UnidadeDaEmpresaDAO;
import br.com.maury.clinicaCristiano.atendimento.modelo.Cargo;
import br.com.maury.clinicaCristiano.atendimento.modelo.ContatoPessoaFisica;
import br.com.maury.clinicaCristiano.atendimento.modelo.Endereco;
import br.com.maury.clinicaCristiano.atendimento.modelo.Funcionario;
import br.com.maury.clinicaCristiano.atendimento.modelo.UnidadeDaEmpresa;
import br.com.maury.clinicaCristiano.jdbc.ConnectionPool;
import br.com.maury.clinicaCristiano.sistema.dao.ModuloDAO;
import br.com.maury.clinicaCristiano.sistema.dao.UsuarioDAO;
import br.com.maury.clinicaCristiano.sistema.modelo.Modulo;
import br.com.maury.clinicaCristiano.sistema.modelo.Usuario;
import br.com.maury.clinicaCristiano.web.util.CaniveteSuico;
import br.com.maury.clinicaCristiano.web.util.CarregadorDeAtributoRequest;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = "/novoFuncionario")
public class NovoFuncionario extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if (FiltroDeAuditoria.acessoValido(req, resp)) {
			CarregadorDeAtributoRequest.buscaCargo(req);
			CarregadorDeAtributoRequest.buscaModulos(req);
			CarregadorDeAtributoRequest.buscaUnidadesDaEmpresa(req);
			RequestDispatcher dispatcher = req
					.getRequestDispatcher("WEB-INF/paginas/atendimento/cadastrarNovoFuncionario.jsp");
			dispatcher.forward(req, resp);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String nome = req.getParameter("nome");
		String sobrenome = req.getParameter("sobrenome");
		String sexo = req.getParameter("sexo");
		String rg = req.getParameter("rg");
		BigInteger cpf = CaniveteSuico.converteCpfStringParaBigInteger(req.getParameter("cpf"));
		String dataNascimentoProfissional = req.getParameter("dataNascimento");
		LocalDate dataNascimento = CaniveteSuico.converteDataStringParaLocalDate(dataNascimentoProfissional);
		Integer idade = CaniveteSuico.calculaIdade(dataNascimento);
		String nivelEscolaridade = req.getParameter("nivelEscolaridade");

		String tipoVia = req.getParameter("tipoVia");
		String logradouro = req.getParameter("logradouro");
		Integer logradouroNumero = Integer.valueOf(req.getParameter("logradouroNumero"));
		String complemento = req.getParameter("complemento");
		String bairro = req.getParameter("bairro");
		String cep = req.getParameter("cep");
		String uf = req.getParameter("uf");
		String cidade = req.getParameter("cidade");

		String telefonePrincipalProfissional = req.getParameter("telefonePrincipal");
		Integer dddTelefonePrincipal = 0;
		Integer telefonePrincipal = 0;
		if (!telefonePrincipalProfissional.isEmpty()) {
			dddTelefonePrincipal = ContatoPessoaFisica.converteDDDParaInteger(telefonePrincipalProfissional);
			telefonePrincipal = ContatoPessoaFisica.converteTelefoneParaInteger(telefonePrincipalProfissional);
		}

		String telefoneSecundarioProfissional = req.getParameter("telefoneSecundario");
		Integer dddTelefoneSecundario = 0;
		Integer telefoneSecundario = 0;
		if (!telefoneSecundarioProfissional.isEmpty()) {
			dddTelefoneSecundario = ContatoPessoaFisica.converteDDDParaInteger(telefoneSecundarioProfissional);
			telefoneSecundario = ContatoPessoaFisica.converteTelefoneParaInteger(telefoneSecundarioProfissional);
		}

		String celularPrincipalProfissional = req.getParameter("celularPrincipal");
		Integer dddCelularPrincipal = 0;
		Integer celularPrincipal = 0;
		if (!celularPrincipalProfissional.isEmpty()) {
			dddCelularPrincipal = ContatoPessoaFisica.converteDDDParaInteger(celularPrincipalProfissional);
			celularPrincipal = ContatoPessoaFisica.converteCelularParaInteger(celularPrincipalProfissional);
		}

		String celularSecundarioProfissional = req.getParameter("celularSecundario");
		Integer dddCelularSecundario = 0;
		Integer celularSecundario = 0;
		if (!celularSecundarioProfissional.isEmpty()) {
			dddCelularSecundario = ContatoPessoaFisica.converteDDDParaInteger(celularSecundarioProfissional);
			celularSecundario = ContatoPessoaFisica.converteCelularParaInteger(celularSecundarioProfissional);
		}

		String email = req.getParameter("email");
		String observacao = req.getParameter("observacao");

		String departamento = req.getParameter("departamento");
		Integer idCargo = Integer.valueOf(req.getParameter("idCargo"));
		String dataAdmissaoProfissional = req.getParameter("dataAdmissao");
		LocalDate dataAdmissao = CaniveteSuico.converteDataStringParaLocalDate(dataAdmissaoProfissional);
		String[] idUnidadesString = req.getParameterValues("unidades");
		Collection<Integer> idUnidades = CaniveteSuico.arrayStringParaCollectionInteger(idUnidadesString);
		String login = req.getParameter("login");
		String senha = req.getParameter("senha");
		String tipoUsuario = req.getParameter("tipoUsuario");
		String[] idModuloString = req.getParameterValues("modulos");
		Collection<Integer> idModulos = CaniveteSuico.arrayStringParaCollectionInteger(idModuloString);

		try (Connection con = ConnectionPool.getConnection()) {
			// Desativa o autocommit. É necessário realizar o commit ou rollback
			con.setAutoCommit(false);

			ContatoPessoaFisica contato = new ContatoPessoaFisica(dddTelefonePrincipal, telefonePrincipal,
					dddTelefoneSecundario, telefoneSecundario, dddCelularPrincipal, celularPrincipal,
					dddCelularSecundario, celularSecundario, email);

			ContatoPessoaFisicaDAO contatoDAO = new ContatoPessoaFisicaDAO(con);
			if (contatoDAO.gravar(contato)) {
				Endereco endereco = new Endereco(tipoVia, logradouro, cep, logradouroNumero, complemento, bairro,
						cidade, uf);

				EnderecoDAO enderecoDAO = new EnderecoDAO(con);

				if (enderecoDAO.gravar(endereco)) {
					ModuloDAO moduloDAO = new ModuloDAO(con);
					Collection<Modulo> modulos = moduloDAO.buscaModuloPorId(idModulos);

					Usuario usuario = new Usuario(login, senha, tipoUsuario, true, modulos);
					UsuarioDAO usuarioDAO = new UsuarioDAO(con);

					if (usuarioDAO.gravar(usuario)) {
						// Cargo cargo = new Cargo(descricaoCargo, idCargo);
						CargoDAO cargoDAO = new CargoDAO(con);
						Cargo cargo = cargoDAO.buscaCargoPorId(idCargo);

						UnidadeDaEmpresaDAO unidadeDAO = new UnidadeDaEmpresaDAO(con);
						Collection<UnidadeDaEmpresa> unidades = unidadeDAO.buscaUnidadeDaEmpresa(idUnidades);

						Funcionario funcionario = new Funcionario(nome, sobrenome, rg, cpf, dataNascimento, observacao,
								endereco, contato, sexo, nivelEscolaridade, idade, departamento, cargo, dataAdmissao,
								true, usuario, unidades);

						PessoaFisicaDAO pfDAO = new PessoaFisicaDAO(con);

						if (pfDAO.gravar(funcionario)) {
							FuncionarioDAO funcionarioDAO = new FuncionarioDAO(con);
							if (funcionarioDAO.gravar(funcionario)) 
								con.commit();
							else
								con.rollback();
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
