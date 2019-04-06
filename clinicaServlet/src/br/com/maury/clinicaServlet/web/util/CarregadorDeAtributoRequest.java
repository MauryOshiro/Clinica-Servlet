package br.com.maury.clinicaServlet.web.util;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;

import javax.servlet.http.HttpServletRequest;

import br.com.maury.clinicaServlet.atendimento.dao.AgendaCompromissoDAO;
import br.com.maury.clinicaServlet.atendimento.dao.AgendaPacienteDAO;
import br.com.maury.clinicaServlet.atendimento.dao.CargoDAO;
import br.com.maury.clinicaServlet.atendimento.dao.HorarioFuncionamentoDAO;
import br.com.maury.clinicaServlet.atendimento.dao.ProfissionalDAO;
import br.com.maury.clinicaServlet.atendimento.dao.UnidadeDaEmpresaDAO;
import br.com.maury.clinicaServlet.atendimento.modelo.AgendaCompromisso;
import br.com.maury.clinicaServlet.atendimento.modelo.AgendaPaciente;
import br.com.maury.clinicaServlet.atendimento.modelo.Cargo;
import br.com.maury.clinicaServlet.atendimento.modelo.Funcionario;
import br.com.maury.clinicaServlet.atendimento.modelo.HorarioFuncionamento;
import br.com.maury.clinicaServlet.atendimento.modelo.Profissional;
import br.com.maury.clinicaServlet.atendimento.modelo.UnidadeDaEmpresa;
import br.com.maury.clinicaServlet.jdbc.ConnectionPool;
import br.com.maury.clinicaServlet.sistema.dao.ModuloDAO;
import br.com.maury.clinicaServlet.sistema.modelo.Modulo;

public class CarregadorDeAtributoRequest {
	public static void buscaModulos(HttpServletRequest req) {
		try (Connection con = ConnectionPool.getConnection()) {
			ModuloDAO moduloDAO = new ModuloDAO(con);
			Collection<Modulo> modulos = moduloDAO.buscaModulos();
			req.setAttribute("modulos", modulos);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void buscaUnidadesDaEmpresa(HttpServletRequest req) {
		try (Connection con = ConnectionPool.getConnection()) {
			UnidadeDaEmpresaDAO unidadeDAO = new UnidadeDaEmpresaDAO(con);
			Collection<UnidadeDaEmpresa> unidades = unidadeDAO.buscaUnidadeDaEmpresa();
			req.setAttribute("unidadesDaEmpresa", unidades);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void buscaCargo(HttpServletRequest req) {
		try (Connection con = ConnectionPool.getConnection()) {
			CargoDAO cargoDAO = new CargoDAO(con);
			Collection<Cargo> cargos = cargoDAO.buscaCargos();
			req.setAttribute("cargos", cargos);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void buscaUnidadesDaEmpresaAgenda(HttpServletRequest req, Boolean ativo) {
		Funcionario funcionario = (Funcionario) req.getSession().getAttribute("usuarioLogado");
		Collection<UnidadeDaEmpresa> unidades = new ArrayList<>();
		for(UnidadeDaEmpresa unidade : funcionario.getUnidades()) {
			if(unidade.getAtivo() == true)
				unidades.add(unidade);
		}
		req.setAttribute("unidades", unidades);
	}

	public static void buscaProfissionaisDaUnidadeDaEmpresa(HttpServletRequest req) {
		try (Connection con = ConnectionPool.getConnection()){
			Funcionario funcionario = (Funcionario) req.getSession().getAttribute("usuarioLogado");
			ProfissionalDAO profissionalDAO = new ProfissionalDAO(con);
			//Collection<Profissional> profissionais = profissionalDAO.buscaPorUnidadesDaEmpresa(funcionario.getUnidades());
			UnidadeDaEmpresa unidade = UnidadeDaEmpresa.retornaPrimeiraUnidade(funcionario.getUnidades());
			Collection<Profissional> profissionais = profissionalDAO.buscaProfissionaisPorUnidadeDaEmpresa(unidade.getId());
			req.setAttribute("profissionais", profissionais);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void buscaHorarioFuncionamento(HttpServletRequest req) {
		try (Connection con = ConnectionPool.getConnection()){
			HorarioFuncionamentoDAO horarioDAO = new HorarioFuncionamentoDAO(con);
			Collection<HorarioFuncionamento> horarios = horarioDAO.buscaTodosHorarios();
			req.setAttribute("horarios", horarios);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void buscaTodosAgendamentosPacienteHoje(HttpServletRequest req) {
		try (Connection con = ConnectionPool.getConnection()) {
			@SuppressWarnings("unchecked")
			Collection<Profissional> profissionais = (Collection<Profissional>) req.getAttribute("profissionais");
			Profissional profissional = Profissional.retornaPrimeiroProfissional(profissionais);
			LocalDate hoje = LocalDate.now();
			AgendaPacienteDAO apDAO = new AgendaPacienteDAO(con);
			Collection<AgendaPaciente> ap = apDAO.buscaAgendamentosPorProfissional(profissional,hoje);
			req.setAttribute("agendasPaciente", ap);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void buscaTodosAgendamentosCompromissoHoje(HttpServletRequest req) {
		try (Connection con = ConnectionPool.getConnection()) {
			@SuppressWarnings("unchecked")
			Collection<Profissional> profissionais = (Collection<Profissional>) req.getAttribute("profissionais");
			Profissional p = Profissional.retornaPrimeiroProfissional(profissionais);
			LocalDate hoje = LocalDate.now();
			AgendaCompromissoDAO acDAO = new AgendaCompromissoDAO(con);
			Collection<AgendaCompromisso> ac = acDAO.buscaAgendamentosPorProfissional(p,hoje);
			req.setAttribute("agendasCompromisso", ac);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void buscaTodosAgendamentosLivresHoje(HttpServletRequest req) {
		try (Connection con = ConnectionPool.getConnection()) {
			@SuppressWarnings("unchecked")
			Collection<Profissional> profissionais = (Collection<Profissional>) req.getAttribute("profissionais");
			Profissional p = Profissional.retornaPrimeiroProfissional(profissionais);
			LocalDate hoje = LocalDate.now();
			AgendaCompromissoDAO acDAO = new AgendaCompromissoDAO(con);
			Collection<AgendaCompromisso> ac = acDAO.buscaAgendamentosLivresPorProfissional(p,hoje);
			req.setAttribute("agendasLivres", ac);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
