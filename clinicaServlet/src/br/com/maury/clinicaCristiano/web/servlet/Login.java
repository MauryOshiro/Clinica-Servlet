package br.com.maury.clinicaCristiano.web.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.maury.clinicaCristiano.atendimento.modelo.Funcionario;
import br.com.maury.clinicaCristiano.jdbc.ConnectionPool;
import br.com.maury.clinicaCristiano.sistema.dao.UsuarioDAO;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = "/login")
public class Login extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String login = req.getParameter("usuario");
		String senha = req.getParameter("senha");

		try (Connection con = ConnectionPool.getConnection()) {
			Funcionario funcionario = new UsuarioDAO(con).realizaLogin(login, senha);

			HttpSession session = req.getSession();

			if (funcionario == null) {
				session.setAttribute("falhaLogin", "Login inválido ou desativado!");
				RequestDispatcher dispatcher = req.getRequestDispatcher("index.jsp");
				dispatcher.forward(req, resp);
			} else {
				session.setMaxInactiveInterval(3600);
				session.setAttribute("usuarioLogado", funcionario);
				session.removeAttribute("falhaLogin");
				RequestDispatcher dispatcher = req.getRequestDispatcher("WEB-INF/paginas/principal.jsp");
				dispatcher.forward(req, resp);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}