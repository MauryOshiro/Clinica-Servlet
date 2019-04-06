package br.com.maury.clinicaCristiano.atendimento.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import br.com.maury.clinicaCristiano.atendimento.modelo.Paciente;

public class PacienteDAO {
	private Connection con;

	public Connection getConnection() {
		return con;
	}
	
	public PacienteDAO(Connection con) {
		this.con = con;
	}
	
	public Boolean gravar(Paciente paciente) {
		String sql = "INSERT INTO tb_Paciente (tb_PessoaFisica_id,conveniado,ativo,prontuario) "
				+ "VALUES(?,?,?,?)";
		
		try (PreparedStatement pstm = getConnection().prepareStatement(sql,Statement.RETURN_GENERATED_KEYS)) {
			pstm.setInt(1, paciente.getIdPessoaFisica());
			pstm.setBoolean(2, paciente.getConveniado());
			pstm.setBoolean(3, paciente.getAtivo());
			pstm.setString(4, paciente.getProntuario());
			
			pstm.execute();
			
			try (ResultSet rsgk = pstm.getGeneratedKeys()) {
				while(rsgk.next()) {
					paciente.setIdPaciente(rsgk.getInt(1));
				}
				return true;
			}catch (Exception e) {
				e.printStackTrace();
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
}
