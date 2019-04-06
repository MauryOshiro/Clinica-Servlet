package br.com.maury.clinicaServlet.atendimento.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import br.com.maury.clinicaServlet.atendimento.modelo.UnidadeDaEmpresa;

public class UnidadeDaEmpresaDAO {
	private Connection con;

	public Connection getConnection() {
		return con;
	}
	
	public UnidadeDaEmpresaDAO(Connection con) {
		this.con = con;
	}

	public Collection<UnidadeDaEmpresa> buscaUnidadeDaEmpresa(Integer id) {
		Collection<UnidadeDaEmpresa> unidades = new ArrayList<>();
		String sql="SELECT * FROM tb_UnidadeDaEmpresa WHERE id = ?";
		
		try (PreparedStatement pstm = getConnection().prepareStatement(sql)) {
			pstm.setInt(1, id);
			pstm.execute();
			
			try (ResultSet rs = pstm.getResultSet()) {
				if(rs.next()) {
					String descricao = rs.getString("descricao");
					UnidadeDaEmpresa unidade = new UnidadeDaEmpresa(id, descricao);
					unidades.add(unidade);
					
					//return unidades;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return unidades;
	}

	public Collection<UnidadeDaEmpresa> buscaUnidadeDaEmpresa() {
		Collection<UnidadeDaEmpresa> unidades = new ArrayList<>();
		String sql = "SELECT * FROM tb_UnidadeDaEmpresa";
		
		try (PreparedStatement pstm = getConnection().prepareStatement(sql)) {
			pstm.execute();
			try (ResultSet rs = pstm.getResultSet()) {
				while(rs.next()) {
					Integer id = rs.getInt(1);
					String descricao = rs.getString(2);
					Boolean ativo = rs.getBoolean(3);
					UnidadeDaEmpresa unidade = new UnidadeDaEmpresa(id, descricao, ativo);
					unidades.add(unidade);
				}
				return unidades;
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public Collection<UnidadeDaEmpresa> buscaUnidadeDaEmpresa(Boolean ativo) {
		Collection<UnidadeDaEmpresa> unidades = new ArrayList<>();
		String sql = "SELECT * FROM tb_UnidadeDaEmpresa WHERE tb_UnidadeDaEmpresa = ?";
		
		try (PreparedStatement pstm = getConnection().prepareStatement(sql)) {
			pstm.setBoolean(1, ativo);
			pstm.execute();
			try (ResultSet rs = pstm.getResultSet()) {
				while(rs.next()) {
					Integer id = rs.getInt(1);
					String descricao = rs.getString(2);
					//Boolean ativo = rs.getBoolean(3);
					UnidadeDaEmpresa unidade = new UnidadeDaEmpresa(id, descricao, ativo);
					unidades.add(unidade);
				}
				return unidades;
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public Collection<UnidadeDaEmpresa> buscaUnidadeDaEmpresa(Collection<Integer> idUnidades) {
		Collection<UnidadeDaEmpresa> unidades = new ArrayList<>();
		String sql = "SELECT * FROM tb_UnidadeDaEmpresa WHERE id = ?";
		for(Integer id : idUnidades) {
			try (PreparedStatement pstm = getConnection().prepareStatement(sql)) {
				pstm.setInt(1, id);
				pstm.execute();
				try (ResultSet rs = pstm.getResultSet()) {
					if(rs.next()) {
						String descricao = rs.getString(2);
						Boolean ativo = rs.getBoolean(3);
						UnidadeDaEmpresa unidade = new UnidadeDaEmpresa(id, descricao, ativo);
						unidades.add(unidade);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return unidades;
	}
}
