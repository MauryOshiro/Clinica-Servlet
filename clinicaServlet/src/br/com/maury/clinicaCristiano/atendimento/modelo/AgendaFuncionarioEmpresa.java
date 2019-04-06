package br.com.maury.clinicaCristiano.atendimento.modelo;

import java.time.LocalDate;

public class AgendaFuncionarioEmpresa extends AgendaCompromisso{
	FuncionarioEmpresa funcionario;
	Boolean faturado;
	Boolean presenca;

	public Boolean getPresenca() {
		return presenca;
	}

	public void setPresenca(Boolean presenca) {
		this.presenca = presenca;
	}

	public Boolean getFaturado() {
		return faturado;
	}

	public void setFaturado(Boolean faturado) {
		this.faturado = faturado;
	}

	public FuncionarioEmpresa getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(FuncionarioEmpresa funcionario) {
		this.funcionario = funcionario;
	}
	
	public AgendaFuncionarioEmpresa(LocalDate data, HorarioFuncionamento horario, String tipo, Profissional p, Boolean ativo) {
		super(data, horario, tipo, p, ativo);
	}
}
