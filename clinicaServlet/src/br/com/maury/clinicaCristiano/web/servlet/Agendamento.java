package br.com.maury.clinicaCristiano.web.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.maury.clinicaCristiano.web.util.CarregadorDeAtributoRequest;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = "/agendamento")
public class Agendamento extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if(FiltroDeAuditoria.acessoValido(req, resp)) {
			CarregadorDeAtributoRequest.buscaUnidadesDaEmpresaAgenda(req,true);
			CarregadorDeAtributoRequest.buscaProfissionaisDaUnidadeDaEmpresa(req);
			//CarregadorDeAtributoRequest.buscaHorarioFuncionamento(req);
			CarregadorDeAtributoRequest.buscaTodosAgendamentosPacienteHoje(req);
			CarregadorDeAtributoRequest.buscaTodosAgendamentosCompromissoHoje(req);
			CarregadorDeAtributoRequest.buscaTodosAgendamentosLivresHoje(req);
			RequestDispatcher dispatcher = req.getRequestDispatcher("WEB-INF/paginas/atendimento/agendamento.jsp");
			dispatcher.forward(req, resp);
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
}
