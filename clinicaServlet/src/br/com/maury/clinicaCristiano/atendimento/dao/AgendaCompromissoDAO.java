package br.com.maury.clinicaCristiano.atendimento.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collection;

import br.com.maury.clinicaCristiano.atendimento.modelo.AgendaCompromisso;
import br.com.maury.clinicaCristiano.atendimento.modelo.HorarioFuncionamento;
import br.com.maury.clinicaCristiano.atendimento.modelo.Profissional;

public class AgendaCompromissoDAO {
	private Connection con;

	public Connection getConnection() {
		return con;
	}

	public AgendaCompromissoDAO(Connection con) {
		this.con = con;
	}

	public Collection<AgendaCompromisso> buscaAgendamentosPorProfissional(Profissional p, LocalDate hoje) {
		Collection<AgendaCompromisso> ac = new ArrayList<>();
		String sql = "SELECT ac.hora AS idHora, hf.horario, ac.tipo FROM tb_AgendaCompromisso AS ac "
						+ "INNER JOIN tb_HorarioFuncionamento AS hf ON hf.id = ac.hora "
						+ "WHERE ac.id not in "
							+ "(SELECT ap.tb_AgendaCompromisso_id FROM tb_AgendaPaciente AS ap "  
							+ "INNER JOIN tb_AgendaCompromisso AS ac ON ac.id = ap.tb_AgendaCompromisso_id " 
								+ "WHERE ac.data = ? " 
								+ "AND ac.tb_Profissional_id = ? "
								+ "AND ac.ativo = ?) " 
						+ "AND ac.data = ? " 
						+ "AND ac.tb_Profissional_id = ? "
						+ "AND ac.ativo = ?";
		
		try (PreparedStatement pstm = getConnection().prepareStatement(sql)) {
			/*pstm.setInt(1, p.getIdProfissional());
			pstm.setBoolean(2, true);
			pstm.setDate(3, Date.valueOf(hoje));
			pstm.setString(4, null);*/
			
			pstm.setDate(1, Date.valueOf(hoje));
			pstm.setInt(2, p.getIdProfissional());
			pstm.setBoolean(3, true);
			pstm.setDate(4, Date.valueOf(hoje));
			pstm.setInt(5, p.getIdProfissional());
			pstm.setBoolean(6, true);
			pstm.execute();
			
			try (ResultSet rs = pstm.getResultSet()) {
				while(rs.next()) {
					//LocalDate data = rs.getDate("data").toLocalDate();
					//LocalTime horario = rs.getTime("hora").toLocalTime();
					Integer idHora = rs.getInt("idHora");
					LocalTime hora = rs.getTime("horario").toLocalTime().plusHours(3);
					String tipo = rs.getString("tipo");
					
					HorarioFuncionamento hf = new HorarioFuncionamento(idHora, hora);
					AgendaCompromisso agendaCompromisso = new AgendaCompromisso(hoje,hf,tipo,p,true);
					ac.add(agendaCompromisso);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return ac;
	}

	public Collection<AgendaCompromisso> buscaAgendamentosLivresPorProfissional(Profissional p, LocalDate hoje) {
		Collection<AgendaCompromisso> acCollection = new ArrayList<>();
		String sql = "SELECT * FROM tb_HorarioFuncionamento "
					+ "WHERE id not in "
						+ "(SELECT ac.hora AS idHora FROM tb_AgendaCompromisso AS ac " 
						+ "LEFT JOIN tb_HorarioFuncionamento AS hf " 
						+ "ON hf.id = ac.hora " 
							+ "WHERE ac.data = ? "
							+ "AND ac.tb_Profissional_id = ?)";
		
		try (PreparedStatement pstm = getConnection().prepareStatement(sql)) {
			pstm.setDate(1, Date.valueOf(hoje));
			pstm.setInt(2, p.getIdProfissional());
			pstm.execute();
			
			try (ResultSet rs = pstm.getResultSet()) {
				while(rs.next()) {
					Integer id = rs.getInt("id");
					LocalTime hora = rs.getTime("horario").toLocalTime().plusHours(3);
					
					HorarioFuncionamento horario = new HorarioFuncionamento(id,hora);
					AgendaCompromisso ac = new AgendaCompromisso(hoje, horario, p);
					acCollection.add(ac);
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return acCollection;
	}
}
