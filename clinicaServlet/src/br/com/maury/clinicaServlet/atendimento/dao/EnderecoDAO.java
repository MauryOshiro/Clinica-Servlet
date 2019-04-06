package br.com.maury.clinicaServlet.atendimento.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import br.com.maury.clinicaServlet.atendimento.modelo.Endereco;

public class EnderecoDAO {
	private Connection con;

	public Connection getConnection() {
		return con;
	}
	
	public EnderecoDAO(Connection con) {
		this.con = con;
	}
	
	public Boolean gravar(Endereco endereco) {
		String sql = "INSERT INTO tb_Endereco (tipoVia,logradouro,numero,complemento,cep,"
				+ "bairro,cidade,uf) "
				+ "VALUES(?,?,?,?,?,?,?,?)";
		try (PreparedStatement pstm = getConnection().prepareStatement(sql,Statement.RETURN_GENERATED_KEYS)) {
			pstm.setString(1, endereco.getTipoVia());
			pstm.setString(2, endereco.getLogradouro());
			pstm.setInt(3, endereco.getNumero());
			pstm.setString(4, endereco.getComplemento());
			pstm.setString(5, endereco.getCep());
			pstm.setString(6, endereco.getBairro());
			pstm.setString(7, endereco.getCidade());
			pstm.setString(8, endereco.getUf());
			
			pstm.execute();
			
			try (ResultSet rsgk = pstm.getGeneratedKeys()) {
				while(rsgk.next()) {
					endereco.setId(rsgk.getInt(1));
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
