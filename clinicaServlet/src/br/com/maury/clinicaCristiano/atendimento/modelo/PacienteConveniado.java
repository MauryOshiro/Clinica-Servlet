package br.com.maury.clinicaCristiano.atendimento.modelo;

public class PacienteConveniado {
	private Paciente paciente;
	private Convenio convenio;

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public Convenio getConvenio() {
		return convenio;
	}

	public void setConvenio(Convenio convenio) {
		this.convenio = convenio;
	}
}
