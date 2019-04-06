package br.com.maury.clinicaCristiano.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class TestaListagemUsuarios {
	public static void main(String[] args) throws Exception {
		//ConnectionPool database = new ConnectionPool();
		for (int i = 0; i <= 100; i++) {
			try (Connection con = ConnectionPool.getConnection()) {
				String sql = "select * from tb_usuario";
				try (PreparedStatement pstmt = con.prepareStatement(sql)) {
					// retorno do execute não é obrigatório. TRUE = quando há retorno (ResultSet).
					// FALSE = quando não há retorno (ResultSet)
					boolean resultado = pstmt.execute();
					System.out.println("Resultado: " + resultado);

					try (ResultSet rs = pstmt.getResultSet()) {
						while (rs.next()) {
							int id = rs.getInt("id");
							String login = rs.getString("login");
							String senha = rs.getString("senha");
							Boolean ativo = rs.getBoolean("ativo");
							String tipoUsuario = rs.getString("tipoUsuario");

							System.out.println("Iteração: " + i);
							System.out.println("id: " + id);
							System.out.println("Login: " + login);
							System.out.println("Senha: " + senha);
							System.out.println("Ativo: " + ativo);
							System.out.println("Tipo de usuário: " + tipoUsuario);
						}
					}//rs.close();
				}// pstmt.close();
			}// con.close();
		}
		System.out.println("Teste de listagem realizado com sucesso!");
	}
}