package br.com.maury.clinicaServlet.sistema.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import br.com.maury.clinicaServlet.sistema.modelo.Modulo;

public class ModuloDAO {
	private Connection con;

	public Connection getConnection() {
		return con;
	}
	
	public ModuloDAO(Connection con) {
		this.con = con;
	}

	public Collection<Modulo> buscaModuloPorId(Integer id) {
		Collection<Modulo> modulos = new ArrayList<>();
		String sql="SELECT * FROM tb_Modulo WHERE id = ?";
		try (PreparedStatement pstm = getConnection().prepareStatement(sql)) {
			pstm.setInt(1, id);
			pstm.execute();
			
			try (ResultSet rs = pstm.getResultSet()) {
				if(rs.next()) {
					String nomeModulo = rs.getNString("nomeModulo");
					Modulo modulo = new Modulo(id, nomeModulo);
					modulos.add(modulo);
					
					//return modulos;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return modulos;
	}

	public Collection<Modulo> buscaModulos() {
		Collection<Modulo> modulos = new ArrayList<>();
		String sql = "SELECT * FROM tb_Modulo";
		
		try (PreparedStatement pstm = getConnection().prepareStatement(sql)) {
			pstm.execute();
			try (ResultSet rs = pstm.getResultSet()) {
				while(rs.next()) {
					Integer id = rs.getInt(1);
					String nomeModulo = rs.getString(2);
					Modulo modulo = new Modulo(id, nomeModulo);
					modulos.add(modulo);
				}
				//return modulos;
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return modulos;
	}

	public Collection<Modulo> buscaModuloPorId(Collection<Integer> idModulos) {
		Collection<Modulo> modulos = new ArrayList<>();
		String sql = "SELECT * FROM tb_Modulo WHERE id = ?";
		for(Integer id : idModulos) {
			//PreparedStatement pstm;
			try (PreparedStatement pstm = getConnection().prepareStatement(sql)) {
				pstm.setInt(1, id);
				pstm.execute();
				try (ResultSet rs = pstm.getResultSet()) {
					if(rs.next()) {
						String nomeModulo = rs.getString(2);
						Modulo modulo = new Modulo(id, nomeModulo);
						modulos.add(modulo);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}			
		}
		return modulos;
	}
}
