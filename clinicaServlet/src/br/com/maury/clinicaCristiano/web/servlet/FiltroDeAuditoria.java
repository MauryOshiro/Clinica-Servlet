package br.com.maury.clinicaCristiano.web.servlet;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.maury.clinicaCristiano.atendimento.modelo.Funcionario;

/*
 *	Na linha abaixo deve colocar todas as servlets que o filtro irá monitorar
 *	https://www.codejava.net/java-ee/servlet/webfilter-annotation-examples 
*/
@WebFilter(servletNames = { "novoPaciente","novoProfissional","novoFuncionario","agendamento" })
public class FiltroDeAuditoria implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		HttpSession session = req.getSession();
		System.out.println("Entrou no FILTRO DE AUDITORIA");

		Funcionario funcionario = (Funcionario) session.getAttribute("usuarioLogado");
		if (funcionario == null) {
			//session.invalidate();
			session.setAttribute("falhaLogin", "Sessão expirada. Favor realizar o login novamente.");
			RequestDispatcher dispatcher = req.getRequestDispatcher("/index.jsp");
			dispatcher.forward(req, resp);
		} else {
			session.setMaxInactiveInterval(3600);
			chain.doFilter(request, response);
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}
	
	public static Boolean acessoValido(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		//Funcionario funcionario = (Funcionario) session.getAttribute("usuarioLogado");
		if (session.getAttribute("usuarioLogado") == null) {
			System.out.println("Tentaram acessar a servlet "+req.getServletPath()+" acessando-a diretamente via URL "
					+ "("+req.getRequestURL()+").");
			session.setAttribute("falhaLogin", "Acesso proibido!");
			/*System.out.println("Local");
			System.out.println(req.getLocalAddr());
			System.out.println(req.getLocalName());
			System.out.println(req.getLocalPort());
			System.out.println("Remote");
			System.out.println(req.getRemoteAddr());
			System.out.println(req.getRemoteHost());
			System.out.println(req.getRemotePort());
			System.out.println(req.getRemoteUser());
			System.out.println("Request URI");
			System.out.println(req.getRequestURI());
			System.out.println("Path Info");
			System.out.println(req.getPathInfo());
			System.out.println("Server");
			System.out.println(req.getServerName());
			System.out.println(req.getServerPort());
			System.out.println(req.getServletPath());
			System.out.println("Request URL");
			System.out.println(req.getRequestURL());*/
			RequestDispatcher dispatcher = req.getRequestDispatcher("/index.jsp");
			dispatcher.forward(req, resp);
		} else {
			return true;
		}
		return false;
	}
}
