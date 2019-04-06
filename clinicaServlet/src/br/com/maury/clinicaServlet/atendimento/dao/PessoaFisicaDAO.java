package br.com.maury.clinicaServlet.atendimento.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import br.com.maury.clinicaServlet.atendimento.abstrato.PessoaFisica;

public class PessoaFisicaDAO {
	private Connection con;

	public Connection getConnection() {
		return con;
	}

	public PessoaFisicaDAO(Connection con) {
		this.con = con;
	}

	public Boolean gravar(PessoaFisica pf) {
		Date data = Date.valueOf(pf.getDataNascimento());
		/*data.setDate(pf.getDataNascimento().getDayOfMonth());
		data.setMonth(pf.getDataNascimento().getMonthValue());
		data.setYear(pf.getDataNascimento().getYear());*/

		String sql = "INSERT INTO tb_PessoaFisica (nome,sobrenome,rg,cpf,dataNascimento,observacao,"
				+ "sexo,nivelEscolaridade,idade,tb_ContatoPessoaFisica_id,tb_Endereco_id) "
				+ "VALUES(?,?,?,?,?,?,?,?,?,?,?)";

		try (PreparedStatement pstm = getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
			pstm.setString(1, pf.getNome());
			pstm.setString(2, pf.getSobrenome());
			pstm.setString(3, pf.getRg());
			//pstm.setInt(4, pf.getCpf().intValue());
			pstm.setLong(4, pf.getCpf().longValue());
			pstm.setDate(5, data);
			pstm.setString(6, pf.getObservacao());
			pstm.setString(7, pf.getSexo());
			pstm.setString(8, pf.getNivelEscolaridade());
			pstm.setInt(9, pf.getIdade());
			pstm.setInt(10, pf.getContato().getId());
			pstm.setInt(11, pf.getEndereco().getId());

			pstm.execute();

			try (ResultSet rsgk = pstm.getGeneratedKeys()) {
				
				while(rsgk.next()) {
					pf.setIdPessoaFisica(rsgk.getInt(1));
				}
				
				return true;
			} catch (Exception e) {
				e.printStackTrace();
				return false;
			}

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
}
