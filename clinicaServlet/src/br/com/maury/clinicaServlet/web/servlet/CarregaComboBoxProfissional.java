package br.com.maury.clinicaServlet.web.servlet;

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

import br.com.maury.clinicaServlet.atendimento.dao.ProfissionalDAO;
import br.com.maury.clinicaServlet.atendimento.modelo.Profissional;
import br.com.maury.clinicaServlet.jdbc.ConnectionPool;

@SuppressWarnings("serial")
@WebServlet(urlPatterns="/carregaComboBoxProfissional")
public class CarregaComboBoxProfissional extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Passou pelo doPost da servlet para carregar combobox");
		resp.setContentType("text/html");
		
		try (PrintWriter writer = resp.getWriter()) {
			Integer idUnidade = Integer.parseInt(req.getParameter("idUnidade"));
			System.out.println("idUnidade: "+idUnidade);
			
			//Collection<Profissional> profissionais = new ArrayList<>();
			
			try (Connection con = ConnectionPool.getConnection()) {
				ProfissionalDAO profissionalDAO = new ProfissionalDAO(con);
				Collection<Profissional> profissionais = profissionalDAO.buscaProfissionaisPorUnidadeDaEmpresa(idUnidade);
				for(Profissional p : profissionais) {
					writer.println("<option value="+p.getIdProfissional()+">"+p.getNome()+" "+p.getSobrenome()+"</option>");
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			/*switch(idUnidade) {
				case 1:
					writer.println("<option value='1'>Primeiro profissional Teste</option>");
					break;
					
				case 2:
					writer.println("<option value='2'>Segundo profissional Teste</option>");
					break;
					
				case 3:
					writer.println("<option value='3'>Terceiro profissional Teste</option>");
					break;
			} */
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}
}
