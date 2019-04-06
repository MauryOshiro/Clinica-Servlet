package br.com.maury.clinicaCristiano.atendimento.modelo;

import java.time.LocalDate;
import java.time.LocalTime;

public class GuiaConvenio {
	private PacienteConveniado pacienteConveniado;
	private LocalDate dataPedido;
	private Boolean cancelado;
	private LocalTime horarioPedido;
	private Funcionario funcionario;
	private Boolean faturado;

	public Boolean getFaturado() {
		return faturado;
	}

	public void setFaturado(Boolean faturado) {
		this.faturado = faturado;
	}

	public PacienteConveniado getPacienteConveniado() {
		return pacienteConveniado;
	}

	public void setPacienteConveniado(PacienteConveniado pacienteConveniado) {
		this.pacienteConveniado = pacienteConveniado;
	}

	public LocalDate getDataPedido() {
		return dataPedido;
	}

	public void setDataPedido(LocalDate dataPedido) {
		this.dataPedido = dataPedido;
	}

	public Boolean getCancelado() {
		return cancelado;
	}

	public void setCancelado(Boolean cancelado) {
		this.cancelado = cancelado;
	}

	public LocalTime getHorarioPedido() {
		return horarioPedido;
	}

	public void setHorarioPedido(LocalTime horarioPedido) {
		this.horarioPedido = horarioPedido;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}
}
