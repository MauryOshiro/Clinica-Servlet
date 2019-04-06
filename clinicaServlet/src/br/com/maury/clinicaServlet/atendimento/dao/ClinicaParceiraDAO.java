package br.com.maury.clinicaServlet.atendimento.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import br.com.maury.clinicaServlet.atendimento.modelo.ClinicaParceira;

public class ClinicaParceiraDAO {
	private Connection con;

	public Connection getConnection() {
		return this.con;
	}
	
	public ClinicaParceiraDAO(Connection con) {
		this.con = con;
	}

	public Collection<ClinicaParceira> buscaTodasClinicas() {
		Collection<ClinicaParceira> clinicas = new ArrayList<>();
		String sql = "SELECT cp.id AS idClinica, pj.nomeFantasia FROM tb_ClinicaParceira as cp " 
						+ "INNER JOIN tb_PessoaJuridica as pj ON pj.id = cp.tb_PessoaJuridica_id " 
						+ "WHERE cp.ativo = ?";
		
		try (PreparedStatement pstm = getConnection().prepareStatement(sql)) {
			pstm.setBoolean(1, true);
			pstm.execute();
			
			try (ResultSet rs = pstm.getResultSet()) {
				while(rs.next()) {
					Integer id = rs.getInt("idClinica");
					String nomeFantasia = rs.getString("nomeFantasia");
					ClinicaParceira clinica = new ClinicaParceira(id,nomeFantasia);
					
					clinicas.add(clinica);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return clinicas;
	}
}
