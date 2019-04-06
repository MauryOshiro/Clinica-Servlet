package br.com.maury.clinicaCristiano.sistema.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

import br.com.maury.clinicaCristiano.atendimento.modelo.Funcionario;
import br.com.maury.clinicaCristiano.atendimento.modelo.UnidadeDaEmpresa;
import br.com.maury.clinicaCristiano.sistema.modelo.Modulo;
import br.com.maury.clinicaCristiano.sistema.modelo.Usuario;

public class UsuarioDAO {
	private Connection con;

	public Connection getConnection() {
		return this.con;
	}

	public UsuarioDAO(Connection con) {
		this.con = con;
	}

	public Funcionario realizaLogin(String login, String senha) {
		/*String sql = "SELECT u.ativo AS ativo,f.id AS idFuncionario,p.nome AS nome,p.sobrenome AS sobrenome "
				+ "FROM ((tb_usuario AS u INNER JOIN tb_funcionario AS f ON u.id = f.tb_Usuario_id) "
				+ "INNER JOIN tb_PessoaFisica AS p ON p.id = f.tb_PessoaFisica_id) "
				+ "WHERE BINARY u.login = ? AND BINARY u.senha = ?;";*/
		String sql = "SELECT u.ativo AS ativo,f.id AS idFuncionario,p.nome AS nome,p.sobrenome AS sobrenome, "
				+ "unidade.id AS idUnidade, unidade.descricao AS unidadeDescricao, unidade.ativo AS unidadeAtivo "
				+ "FROM ((tb_usuario AS u "
				+ "INNER JOIN tb_funcionario AS f ON u.id = f.tb_Usuario_id) "
				+ "INNER JOIN tb_PessoaFisica AS p ON p.id = f.tb_PessoaFisica_id) "
				+ "INNER JOIN tb_Funcionario_X_tb_UnidadeDaEmpresa AS funXuni ON funXuni.tb_Funcionario_id = f.id "
				+ "INNER JOIN tb_UnidadeDaEmpresa AS unidade ON unidade.id = funXuni.tb_UnidadeDaEmpresa_id "
				+ "WHERE BINARY u.login = ? AND BINARY u.senha = ?";
		try (PreparedStatement pstm = getConnection().prepareStatement(sql)) {
			pstm.setString(1, login);
			pstm.setString(2, senha);
			pstm.execute();

			try (ResultSet rs = pstm.getResultSet()) {
				/*if (rs.next()) {
					Boolean ativo = rs.getBoolean("ativo");

					if (ativo == false) {
						return null;
					}

					Integer idFuncionario = rs.getInt("idFuncionario");
					String nome = rs.getString("nome");
					String sobrenome = rs.getString("sobrenome");
					
					
					
					Integer idUnidade = rs.getInt("idUnidade");
					String unidadeDescricao = rs.getString("unidadeDescricao");
					Boolean unidadeAtivo = rs.getBoolean("unidadeAtivo");
					UnidadeDaEmpresa unidade = new UnidadeDaEmpresa(idUnidade, unidadeDescricao, ativo);

					Funcionario funcionario = new Funcionario();
					funcionario.setIdPessoaFisica(idFuncionario);
					funcionario.setNome(nome);
					funcionario.setSobrenome(sobrenome);
					
					return funcionario;
				}*/
				Collection<UnidadeDaEmpresa> unidades = new ArrayList<>();
				while(rs.next()) {
					Integer idUnidade = rs.getInt("idUnidade");
					String unidadeDescricao = rs.getString("unidadeDescricao");
					Boolean unidadeAtivo = rs.getBoolean("unidadeAtivo");
					UnidadeDaEmpresa unidade = new UnidadeDaEmpresa(idUnidade, unidadeDescricao, unidadeAtivo);
					unidades.add(unidade);
				}
				if(rs.first()) {
					Boolean ativo = rs.getBoolean("ativo");

					if (ativo == false) {
						return null;
					}

					Integer idFuncionario = rs.getInt("idFuncionario");
					String nome = rs.getString("nome");
					String sobrenome = rs.getString("sobrenome");
					
					Funcionario funcionario = new Funcionario();
					funcionario.setIdPessoaFisica(idFuncionario);
					funcionario.setNome(nome);
					funcionario.setSobrenome(sobrenome);
					funcionario.setUnidades(unidades);
					
					return funcionario;
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public Boolean gravar(Usuario usuario) {
		String sql = "INSERT INTO tb_Usuario (login,senha,ativo,tipoUsuario) "
				+ "VALUES (?,?,?,?)";
		
		try (PreparedStatement pstm = getConnection().prepareStatement(sql,Statement.RETURN_GENERATED_KEYS)) {
			pstm.setString(1, usuario.getLogin());
			pstm.setString(2, usuario.getSenha());
			pstm.setBoolean(3, usuario.getAtivo());
			pstm.setString(4, usuario.getTipoUsuario());
			pstm.execute();
			
			try (ResultSet rsgk = pstm.getGeneratedKeys()) {
				if(rsgk.next());{
					usuario.setId(rsgk.getInt(1));
					
					if(gravarUsuarioXModulo(usuario))
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
	}
	
	public Boolean gravarUsuarioXModulo (Usuario usuario) {
		for(Modulo modulo : usuario.getModulos()) {
			String sql = "INSERT INTO tb_Modulo_X_tb_Usuario "
					+ "VALUES (?,?)";
			
			try (PreparedStatement pstm = getConnection().prepareStatement(sql)) {
				pstm.setInt(1, modulo.getId());
				pstm.setInt(2, usuario.getId());
				pstm.execute();
			} catch (SQLException e) {
				e.printStackTrace();
				return false;
			}
		}
		
		return true;
	}
}