package br.com.maury.clinicaCristiano.atendimento.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PacienteConveniadoDAO {
	private Connection con;

	public Connection getConnection() {
		return con;
	}

	public PacienteConveniadoDAO(Connection con) {
		this.con = con;
	}
	
	public Boolean gravar(Integer idConvenio, Integer idPaciente) {
		String sql = "INSERT INTO tb_PacienteConveniado VALUES(?,?)";
		
		try (PreparedStatement pstm = getConnection().prepareStatement(sql)) {
			
			pstm.setInt(1, idPaciente);
			pstm.setInt(2, idConvenio);
			
			pstm.execute();
			
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
}
