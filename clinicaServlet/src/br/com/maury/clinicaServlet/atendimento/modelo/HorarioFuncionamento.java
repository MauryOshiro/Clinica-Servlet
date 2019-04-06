package br.com.maury.clinicaServlet.atendimento.modelo;

import java.time.LocalTime;

public class HorarioFuncionamento {
	private Integer id;
	private LocalTime horario;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalTime getHorario() {
		return horario;
	}

	public void setHorario(LocalTime horario) {
		this.horario = horario;
	}
	
	public HorarioFuncionamento() {
		
	}
	
	public HorarioFuncionamento(LocalTime horario) {
		this.horario = horario;
	}
	
	public HorarioFuncionamento(Integer id, LocalTime horario) {
		this.id = id;
		this.horario = horario;
	}
}
