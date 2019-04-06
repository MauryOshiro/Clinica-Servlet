package br.com.maury.clinicaCristiano.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.maury.clinicaCristiano.atendimento.dao.ClinicaParceiraDAO;
import br.com.maury.clinicaCristiano.atendimento.modelo.ClinicaParceira;
import br.com.maury.clinicaCristiano.jdbc.ConnectionPool;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = "/carregaCampoOrigem")
public class CarregaCampoOrigem extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Passou pelo doPost da servlet para carregar campo (DIV) origem");
		resp.setContentType("text/html");

		try (PrintWriter writer = resp.getWriter()) {
			Integer tipoOrigem = Integer.parseInt(req.getParameter("tipoOrigem"));
			
			try (Connection con = ConnectionPool.getConnection()) {
				ClinicaParceiraDAO clinicaParceiraDAO = new ClinicaParceiraDAO(con);
				Collection<ClinicaParceira> clinicasParceiras = clinicaParceiraDAO.buscaTodasClinicas();
				
				String optionClinica = "";
				
				for(ClinicaParceira cp : clinicasParceiras) {
					optionClinica = optionClinica.concat("<option value="+cp.getId()+">"+cp.getNomeFantasia()+"</option>");
				}
				
				writer.println("<div class='form-group'>"
									+ "<label>Clinica</label>"
									+ "<select class='form-control' name ='clinica'>"
										+ optionClinica
									+ "</select>"
								+ "</div>");
				
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
