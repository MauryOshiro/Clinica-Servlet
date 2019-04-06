package br.com.maury.clinicaServlet.atendimento.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import br.com.maury.clinicaServlet.atendimento.modelo.Convenio;

public class ConvenioDAO {
	private Connection con;

	public Connection getConnection() {
		return con;
	}

	public ConvenioDAO(Connection con) {
		this.con = con;
	}

	public void converteResultadoEmCollectionConvenio(List<Convenio> convenios, PreparedStatement pstm) {
		try (ResultSet rs = pstm.getResultSet()) {
			while(rs.next()) {
				Integer idConvenio = rs.getInt("idCon");
				String nomeFantasia = rs.getString("nomeFantasia");
				Convenio convenio = new Convenio(idConvenio,nomeFantasia);
		
				convenios.add(convenio);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public Collection<Convenio> buscaConvenio() {
		List<Convenio> convenios = new ArrayList<>();
		String sql = "select con.id as idCon,pj.nomeFantasia "
				+ "from tb_Convenio as con "
				+ "inner join tb_PessoaJuridica as pj on con.tb_PessoaJuridica_id = pj.id "
				+ "where con.ativo = 1;";
		
		try (PreparedStatement pstm = getConnection().prepareStatement(sql)) {
			pstm.execute();
			
			converteResultadoEmCollectionConvenio(convenios, pstm);
			
			//return convenios;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return convenios;
	}
}
