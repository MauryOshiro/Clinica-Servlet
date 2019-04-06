package br.com.maury.clinicaCristiano.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import br.com.maury.clinicaCristiano.atendimento.modelo.Funcionario;
import br.com.maury.clinicaCristiano.sistema.modelo.Modulo;
import br.com.maury.clinicaCristiano.sistema.modelo.Usuario;

public class TestaLoginComLista {
	private static String login = "adm";
	private static String senha = "adm@adm";

	public static Collection<Modulo> buscaModulosDoUsuario(Integer idUsuario, Connection con) throws SQLException {
		Collection<Modulo> modulos = new ArrayList<>();

		String sql = "SELECT m.id,m.nomeModulo FROM tb_modulo_X_tb_usuario AS relacao "
						+ "INNER JOIN tb_modulo AS m ON relacao.tb_Modulo_id = m.id "
						+ "WHERE relacao.tb_Usuario_id = ?";

		try (PreparedStatement pstm = con.prepareStatement(sql)) {
			pstm.setInt(1, 1);
			pstm.execute();

			try (ResultSet rs = pstm.getResultSet()) {
				while (rs.next()) {
					Integer idModulo = rs.getInt("id");
					String nomeModulo = rs.getString("nomeModulo");
					Modulo modulo = new Modulo(idModulo, nomeModulo);
					
					modulos.add(modulo);
				}
			}
		}

		return modulos;
	}

	public static void imprimiListaLogin(Collection<Object> listaLogin) {
		Integer contador = 0;
		Funcionario funcionario = null;
		Usuario usuario = null;

		for (Object objeto : listaLogin) {
			if (contador == 0) {
				funcionario = (Funcionario) objeto;
			}
			if (contador == 1) {
				usuario = (Usuario) objeto;
			}
			contador++;
		}

		System.out.println("ID do funcionário: " + funcionario.getIdPessoaFisica());
		System.out.println("Nome do funcionário: " + funcionario.getNome());
		System.out.println("Sobrenome do funcionário: " + funcionario.getSobrenome());
		System.out.println("ID do usuário: " + usuario.getId());
		System.out.println("Tipo de usuário: " + usuario.getTipoUsuario());
		System.out.println("MÓDULOS: ");
		for (Modulo modulo : usuario.getModulos()) {
			System.out.println("ID do módulo: " + modulo.getId());
			System.out.println("Nome do módulo: " + modulo.getNomeModulo());
		}
	}

	public static void main(String[] args) throws Exception {
		Collection<Object> listaLogin = new ArrayList<>();
		//ConnectionPool database = new ConnectionPool();
		//database = new ConnectionPool();
		try (Connection con = ConnectionPool.getConnection()) {
			String sql = "SELECT u.id AS idUsuario,u.tipoUsuario AS tipoUsuario,u.ativo AS usuarioAtivo,f.id AS idFuncionario,p.nome AS nome,p.sobrenome AS sobrenome "
					+ "FROM ((tb_usuario AS u INNER JOIN tb_funcionario AS f ON u.id = f.tb_Usuario_id) "
					+ "INNER JOIN tb_PessoaFisica AS p ON p.id = f.tb_PessoaFisica_id) "
					+ "WHERE u.login = ? AND u.senha = ?";

			try (PreparedStatement pstm = con.prepareStatement(sql)) {
				pstm.setString(1, login);
				pstm.setString(2, senha);
				pstm.execute();

				try (ResultSet rs = pstm.getResultSet()) {
					if (rs.next()) {
						Boolean ativo = rs.getBoolean("usuarioAtivo");

						if (ativo == false) {
							System.out.println("USUÁRIO INVÁLIDO OU INATIVO");
						}

						Integer idFuncionario = rs.getInt("idFuncionario");
						String nome = rs.getString("nome");
						String sobrenome = rs.getString("sobrenome");
						Funcionario funcionario = new Funcionario();
						funcionario.setIdPessoaFisica(idFuncionario);
						funcionario.setNome(nome);
						funcionario.setSobrenome(sobrenome);
						listaLogin.add(funcionario);

						Integer idUsuario = rs.getInt("idUsuario");
						String tipoUsuario = rs.getString("tipoUsuario");
						Collection<Modulo> modulos = buscaModulosDoUsuario(idUsuario,con);
						Usuario usuario = new Usuario();
						usuario.setId(idUsuario);
						usuario.setTipoUsuario(tipoUsuario);
						usuario.setModulos(modulos);
						listaLogin.add(usuario);

						imprimiListaLogin(listaLogin);
						
						System.out.println("FIM");
					}

				}
			}
		}
	}
}
