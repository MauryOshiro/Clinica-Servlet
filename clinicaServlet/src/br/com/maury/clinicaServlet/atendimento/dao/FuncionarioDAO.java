package br.com.maury.clinicaServlet.atendimento.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import br.com.maury.clinicaServlet.atendimento.modelo.Funcionario;
import br.com.maury.clinicaServlet.atendimento.modelo.UnidadeDaEmpresa;
import br.com.maury.clinicaServlet.sistema.modelo.Usuario;

public class FuncionarioDAO {
	private Connection con;

	public Connection getConnection() {
		return this.con;
	}

	public FuncionarioDAO(Connection con) {
		this.con = con;
	}

	public Funcionario buscaFuncionario(Usuario usuario) {

		return null;
	}

	public Boolean gravar(Funcionario f) {
		String sql = "INSERT INTO tb_Funcionario (departamento,dataAdmissao,ativo,"
				+ "tb_Cargo_id,tb_PessoaFisica_id,tb_Usuario_id) " + "VALUES(?,?,?,?,?,?)";

		try (PreparedStatement pstm = getConnection().prepareStatement(sql,Statement.RETURN_GENERATED_KEYS)) {
			pstm.setString(1, f.getDepartamento());
			pstm.setDate(2, Date.valueOf(f.getDataAdmissao()));
			pstm.setBoolean(3, f.getAtivo());
			pstm.setInt(4, f.getCargo().getId());
			pstm.setInt(5, f.getIdPessoaFisica());
			pstm.setInt(6, f.getUsuario().getId());
			pstm.execute();

			try (ResultSet rsgk = pstm.getGeneratedKeys()) {
				if(rsgk.next()) {
					f.setIdFuncionario(rsgk.getInt(1));
					if(gravarFuncionarioNaUnidadeDaEmpresa(f))
						return true;
					else
						return false;
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

	private Boolean gravarFuncionarioNaUnidadeDaEmpresa(Funcionario f) {
		String sql = "INSERT INTO tb_Funcionario_X_tb_UnidadeDaEmpresa VALUES(?,?)";
		for(UnidadeDaEmpresa unidade : f.getUnidades()) {
			try (PreparedStatement pstm = getConnection().prepareStatement(sql)) {
				pstm.setInt(1, f.getIdFuncionario());
				pstm.setInt(2, unidade.getId());
				pstm.execute();
			} catch (SQLException e) {
				e.printStackTrace();
				return false;
			}
		}
		return true;
	}
}
