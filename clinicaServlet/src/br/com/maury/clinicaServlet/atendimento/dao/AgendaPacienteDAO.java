package br.com.maury.clinicaServlet.atendimento.dao;

import java.math.BigInteger;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collection;

import br.com.maury.clinicaServlet.atendimento.modelo.AgendaPaciente;
import br.com.maury.clinicaServlet.atendimento.modelo.HorarioFuncionamento;
import br.com.maury.clinicaServlet.atendimento.modelo.Paciente;
import br.com.maury.clinicaServlet.atendimento.modelo.Profissional;

public class AgendaPacienteDAO {
	private Connection con;

	public Connection getConnection() {
		return con;
	}
	
	public AgendaPacienteDAO(Connection con) {
		this.con = con;
	}

	public Collection<AgendaPaciente> buscaAgendamentosPorProfissional(Profissional profissional, LocalDate data) {
		Collection<AgendaPaciente> agendasPaciente = new ArrayList<>();
		String sql = "SELECT ac.data, ac.hora AS idHora, hf.horario AS horario, pf.nome, pf.sobrenome, pf.cpf, fun.id AS idFuncionario, "
						+ "ac.tipo, ap.presenca, ac.ativo, ap.tb_Paciente_id AS idPaciente " 
						+ "FROM tb_AgendaCompromisso AS ac " 
						+ "INNER JOIN tb_AgendaPaciente AS ap ON ac.id = ap.tb_AgendaCompromisso_id " 
						+ "INNER JOIN tb_Paciente AS p ON p.id = ap.tb_Paciente_id " 
						+ "INNER JOIN tb_PessoaFisica AS pf ON pf.id = p.tb_PessoaFisica_id " 
						+ "INNER JOIN tb_Profissional AS pro ON pro.id = ac.tb_Profissional_id " 
						+ "INNER JOIN tb_Funcionario AS fun ON fun.id = pro.tb_Funcionario_id " 
						+ "INNER JOIN tb_HorarioFuncionamento AS hf ON hf.id = ac.hora "
							+ "WHERE ac.tb_Profissional_id = ? " 
							+ "AND ac.ativo = ? " 
							+ "AND ac.data = ? "
						+ "ORDER BY ac.hora";
		
		try (PreparedStatement pstm = getConnection().prepareStatement(sql)) {
			pstm.setInt(1, profissional.getIdProfissional());
			pstm.setBoolean(2, true);
			pstm.setDate(3, Date.valueOf(data));
			pstm.execute();
			
			try (ResultSet rs = pstm.getResultSet()) {
				while(rs.next()) {
					LocalDate d = rs.getDate("data").toLocalDate();
					Integer idHora = rs.getInt("idHora");
					//Precisa adicionar 3 horas por causa do fuso hor�rio
					LocalTime horario = rs.getTime("horario").toLocalTime().plusHours(3);
					System.out.println("Hor�rio: "+horario.toString());
					String tipo = rs.getString("tipo");
					Boolean presenca = rs.getBoolean("presenca");
					Boolean ativo = rs.getBoolean("ativo");
					
					Integer idPaciente = rs.getInt("idPaciente");
					String nomePaciente = rs.getString("nome");
					String sobrenomePaciente = rs.getString("sobrenome");
					Long cpf = rs.getLong("cpf");
					BigInteger cpfPaciente = new BigInteger(cpf.toString());
					
					HorarioFuncionamento hf = new HorarioFuncionamento(idHora, horario);
					Paciente paciente = new Paciente(idPaciente,nomePaciente,sobrenomePaciente,cpfPaciente);
					AgendaPaciente ap = new AgendaPaciente(d,hf,tipo,presenca,ativo,paciente,profissional);
					
					agendasPaciente.add(ap);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return agendasPaciente;
	}
}
