package br.com.maury.clinicaCristiano.atendimento.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collection;

import br.com.maury.clinicaCristiano.atendimento.modelo.HorarioFuncionamento;

public class HorarioFuncionamentoDAO {
	private Connection con;

	public Connection getConnection() {
		return con;
	}

	public HorarioFuncionamentoDAO(Connection con) {
		this.con = con;
	}

	public Collection<HorarioFuncionamento> buscaTodosHorarios() {
		Collection<HorarioFuncionamento> horarios = new ArrayList<>();
		String sql = "SELECT horario FROM tb_HorarioFuncionamento";

		try (PreparedStatement pstm = getConnection().prepareStatement(sql)) {
			pstm.execute();
			try (ResultSet rs = pstm.getResultSet()) {
				while(rs.next()) {
					LocalTime hora = rs.getTime(1).toLocalTime();
					HorarioFuncionamento horario = new HorarioFuncionamento(hora);
					horarios.add(horario);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return horarios;
	}
}
