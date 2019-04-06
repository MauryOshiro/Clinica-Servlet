package br.com.maury.clinicaCristiano.atendimento.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import br.com.maury.clinicaCristiano.atendimento.modelo.ContatoPessoaFisica;

public class ContatoPessoaFisicaDAO {
	private Connection con;

	public Connection getConnection() {
		return con;
	}
	
	public ContatoPessoaFisicaDAO(Connection con) {
		this.con = con;
	}

	public Boolean gravar(ContatoPessoaFisica c) {
		String sql = "INSERT INTO tb_ContatoPessoaFisica (dddTelefonePrincipal, telefonePrincipal,"
				+ "dddTelefoneSecundario,telefoneSecundario,dddCelularPrincipal,celularPrincipal,"
				+ "dddCelularSecundario,celularSecundario,email) "
				+ "VALUES(?,?,?,?,?,?,?,?,?)";
		try (PreparedStatement pstm = getConnection().prepareStatement(sql,Statement.RETURN_GENERATED_KEYS)) {
			pstm.setInt(1, c.getDddTelefonePrincipal());
			pstm.setInt(2, c.getTelefonePrincipal());
			pstm.setInt(3, c.getDddTelefoneSecundario());
			pstm.setInt(4, c.getTelefoneSecundario());
			pstm.setInt(5, c.getDddCelularPrincipal());
			pstm.setInt(6, c.getCelularPrincipal());
			pstm.setInt(7, c.getDddCelularSecundario());
			pstm.setInt(8, c.getCelularSecundario());
			pstm.setString(9, c.getEmail());
			
			pstm.execute();
			
			try (ResultSet rsgk = pstm.getGeneratedKeys()) { 
				while(rsgk.next()) {
					c.setId(rsgk.getInt(1));
				}
				
				return true;
			} catch(Exception e) {
				e.printStackTrace();
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
}
