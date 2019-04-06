package br.com.maury.clinicaServlet.atendimento.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import br.com.maury.clinicaServlet.atendimento.modelo.Cargo;

public class CargoDAO {
	private Connection con;

	public Connection getConnection() {
		return con;
	}
	
	public CargoDAO(Connection con) {
		this.con = con;
	}
	
	public Cargo buscaCargoPorId(Integer id) {
		Cargo cargo = null;
		String sql="SELECT * FROM tb_Cargo WHERE id=?";
		
		try (PreparedStatement pstm = getConnection().prepareStatement(sql)) {
			pstm.setInt(1, id);
			pstm.execute();
			
			try (ResultSet rs = pstm.getResultSet()) {
				if(rs.next()) {
					String nome = rs.getString("nome");
					cargo = new Cargo(nome, id);
					//return cargo;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cargo;
	}
	
	public Collection<Cargo> buscaCargoPorID(Collection<Integer> idCargo){
		Collection<Cargo> cargos = new ArrayList<>();
		String sql = "SELECT * FROM tb_Cargo WHERE id=?";
		for(Integer i : idCargo) {
			try (PreparedStatement pstm = getConnection().prepareStatement(sql)) {
				pstm.setInt(1, i);
				pstm.execute();
				try (ResultSet rs = pstm.getResultSet()) {
					if(rs.next()) {
						String nome = rs.getString("nome");
						Cargo cargo = new Cargo(nome, i);
						cargos.add(cargo);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return cargos;
	}
	
	public Collection<Cargo> buscaCargos(){
		Collection<Cargo> cargos = new ArrayList<>();
		String sql = "SELECT * FROM tb_Cargo";
		
		try (PreparedStatement pstm = getConnection().prepareStatement(sql)) {
			pstm.execute();
			
			try (ResultSet rs = pstm.getResultSet()) {
				while(rs.next()) {
					Integer id = rs.getInt(1);
					String nome = rs.getString(2);
					Cargo cargo = new Cargo(nome, id);
					cargos.add(cargo);
				}
				
				//return cargos;
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cargos;
	}
}
