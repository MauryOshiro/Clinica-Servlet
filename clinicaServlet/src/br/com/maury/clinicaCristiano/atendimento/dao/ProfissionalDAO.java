package br.com.maury.clinicaCristiano.atendimento.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

import br.com.maury.clinicaCristiano.atendimento.modelo.Profissional;
import br.com.maury.clinicaCristiano.atendimento.modelo.UnidadeDaEmpresa;

public class ProfissionalDAO {
	private Connection con;

	public Connection getConnection() {
		return con;
	}

	public void setCon(Connection con) {
		this.con = con;
	}
	
	public ProfissionalDAO(Connection con) {
		this.con = con;
	}

	public Boolean gravar(Profissional p) {
		String sql = "INSERT INTO tb_Profissional (crp,tb_Funcionario_id) "
				+ "VALUES(?,?)";
		
		try (PreparedStatement pstm = getConnection().prepareStatement(sql,Statement.RETURN_GENERATED_KEYS)) {
			pstm.setString(1, p.getCrp());
			pstm.setInt(2, p.getIdFuncionario());
			pstm.execute();
			
			try (ResultSet rsgk = pstm.getGeneratedKeys()) {
				if(rsgk.next()) {
					p.setIdProfissional(rsgk.getInt(1));
					return true;	
				}
			} catch (Exception e) {
				e.printStackTrace();
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return false;
	}

	public Collection<Profissional> buscaPorUnidadesDaEmpresa(Collection<UnidadeDaEmpresa> unidades) {
		Collection<Profissional> profissionais = new ArrayList<>();
		String sql = "SELECT p.id AS idProfissional, pf.nome AS nome, pf.sobrenome AS sobrenome "
						+ "FROM tb_Funcionario_X_tb_UnidadeDaEmpresa AS relacao " 
						+ "INNER JOIN tb_Funcionario AS f ON relacao.tb_Funcionario_id = f.id " 
						+ "INNER JOIN tb_Profissional AS p ON p.tb_Funcionario_id = f.id " 
						+ "INNER JOIN tb_PessoaFisica AS pf ON pf.id = f.tb_PessoaFisica_id " 
						+ "WHERE tb_UnidadeDaEmpresa_id = ?";
		
		try (PreparedStatement pstm = getConnection().prepareStatement(sql)) {
			for(UnidadeDaEmpresa unidade : unidades) {
				pstm.setInt(1, unidade.getId());
				pstm.execute();
				try (ResultSet rs = pstm.getResultSet()) {
					while(rs.next()) {
						Integer idProfissional = rs.getInt("idProfissional");
						String nome = rs.getString("nome");
						String sobrenome = rs.getString("sobrenome");
						Profissional profissional = new Profissional();
						profissional.setIdProfissional(idProfissional);
						profissional.setNome(nome);
						profissional.setSobrenome(sobrenome);
						
						profissionais.add(profissional);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return profissionais;
	}

	public Collection<Profissional> buscaProfissionaisPorUnidadeDaEmpresa(Integer idUnidade) {
		Collection<Profissional> profissionais = new ArrayList<>();
		String sql = "SELECT p.id AS idProfissional, pf.nome AS nome, pf.sobrenome AS sobrenome "
						+ "FROM tb_Funcionario_X_tb_UnidadeDaEmpresa AS relacao " 
						+ "INNER JOIN tb_Funcionario AS f ON relacao.tb_Funcionario_id = f.id " 
						+ "INNER JOIN tb_Profissional AS p ON p.tb_Funcionario_id = f.id " 
						+ "INNER JOIN tb_PessoaFisica AS pf ON pf.id = f.tb_PessoaFisica_id " 
						+ "WHERE tb_UnidadeDaEmpresa_id = ?";
		
		try (PreparedStatement pstm = getConnection().prepareStatement(sql)) {
			pstm.setInt(1, idUnidade);
			pstm.execute();
			
			try (ResultSet rs = pstm.getResultSet()) {
				while(rs.next()) {
					Integer idProfissional = rs.getInt("idProfissional");
					String nome = rs.getString("nome");
					String sobrenome = rs.getString("sobrenome");
					Profissional profissional = new Profissional();
					profissional.setIdProfissional(idProfissional);
					profissional.setNome(nome);
					profissional.setSobrenome(sobrenome);
					
					profissionais.add(profissional);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return profissionais;
	}
	
	public Profissional buscaProfissionalPorUnidadeDaEmpresa(Integer idUnidade) {
		String sql = "SELECT p.id AS idProfissional, pf.nome AS nome, pf.sobrenome AS sobrenome "
				+ "FROM tb_Funcionario_X_tb_UnidadeDaEmpresa AS relacao " 
				+ "INNER JOIN tb_Funcionario AS f ON relacao.tb_Funcionario_id = f.id " 
				+ "INNER JOIN tb_Profissional AS p ON p.tb_Funcionario_id = f.id " 
				+ "INNER JOIN tb_PessoaFisica AS pf ON pf.id = f.tb_PessoaFisica_id " 
				+ "WHERE tb_UnidadeDaEmpresa_id = ?";

		try (PreparedStatement pstm = getConnection().prepareStatement(sql)) {
			pstm.setInt(1, idUnidade);
			pstm.execute();

			try (ResultSet rs = pstm.getResultSet()) {
				while (rs.next()) {
					Integer idProfissional = rs.getInt("idProfissional");
					String nome = rs.getString("nome");
					String sobrenome = rs.getString("sobrenome");
					Profissional profissional = new Profissional();
					profissional.setIdProfissional(idProfissional);
					profissional.setNome(nome);
					profissional.setSobrenome(sobrenome);

					return profissional;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
}
