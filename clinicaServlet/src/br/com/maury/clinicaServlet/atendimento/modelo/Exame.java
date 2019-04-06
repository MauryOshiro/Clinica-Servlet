package br.com.maury.clinicaServlet.atendimento.modelo;

import java.util.Collection;

public class Exame {
	private Integer id;
	private AgendaCompromisso agenda;
	private String objetivo;
	private Collection<ExameConclusao> conclusoes;
	private Boolean concluido;
	private Boolean cancelado;
	private Collection<TesteRealizado> testesRealizados;
	private String nomeExame;

	public String getNomeExame() {
		return nomeExame;
	}

	public void setNomeExame(String nomeExame) {
		this.nomeExame = nomeExame;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public AgendaCompromisso getAgenda() {
		return agenda;
	}

	public void setAgendaAtendimento(AgendaCompromisso agenda) {
		this.agenda = agenda;
	}

	public String getObjetivo() {
		return objetivo;
	}

	public void setObjetivo(String objetivo) {
		this.objetivo = objetivo;
	}

	public Collection<ExameConclusao> getConclusoes() {
		return conclusoes;
	}

	public void setConclusoes(Collection<ExameConclusao> conclusoes) {
		this.conclusoes = conclusoes;
	}

	public Boolean getConcluido() {
		return concluido;
	}

	public void setConcluido(Boolean concluido) {
		this.concluido = concluido;
	}

	public Boolean getCancelado() {
		return cancelado;
	}

	public void setCancelado(Boolean cancelado) {
		this.cancelado = cancelado;
	}

	public Collection<TesteRealizado> getTestesRealizados() {
		return testesRealizados;
	}

	public void setTestesRealizados(Collection<TesteRealizado> testesRealizados) {
		this.testesRealizados = testesRealizados;
	}
}
