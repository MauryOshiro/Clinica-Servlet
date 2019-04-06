package br.com.maury.clinicaCristiano.atendimento.modelo;

import java.time.LocalDate;

public class AgendaPaciente extends AgendaCompromisso {
	private Paciente paciente;
	private Boolean geradoGuia;
	private Boolean faturado;
	private Boolean presenca;

	public Boolean getGeradoGuia() {
		return geradoGuia;
	}

	public void setGeradoGuia(Boolean geradoGuia) {
		this.geradoGuia = geradoGuia;
	}

	public Boolean getFaturado() {
		return faturado;
	}

	public void setFaturado(Boolean faturado) {
		this.faturado = faturado;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public Boolean getPresenca() {
		return presenca;
	}

	public void setPresenca(Boolean presenca) {
		this.presenca = presenca;
	}

	public AgendaPaciente(LocalDate d, HorarioFuncionamento horario, String tipo, Boolean presenca, Boolean ativo,
			Paciente paciente, Profissional profissional) {
		super(d,horario,tipo,profissional,ativo);
		this.presenca = presenca;
		//this.ativo = ativo;
		this.paciente = paciente;
	}
}