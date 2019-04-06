package br.com.maury.clinicaServlet.faturamento.modelo;

import java.util.Collection;

import br.com.maury.clinicaServlet.atendimento.modelo.AgendaPaciente;
import br.com.maury.clinicaServlet.atendimento.modelo.Paciente;

public class FaturaPaciente extends Fatura {
	private Paciente paciente;
	private Collection<AgendaPaciente> agendasPaciente;

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public Collection<AgendaPaciente> getAgendasPaciente() {
		return agendasPaciente;
	}

	public void setAgendasPaciente(Collection<AgendaPaciente> agendasPaciente) {
		this.agendasPaciente = agendasPaciente;
	}
}
