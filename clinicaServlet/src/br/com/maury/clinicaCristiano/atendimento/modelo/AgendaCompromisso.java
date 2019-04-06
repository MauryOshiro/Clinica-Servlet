package br.com.maury.clinicaCristiano.atendimento.modelo;

import java.time.LocalDate;

public class AgendaCompromisso {
	private Integer id;
	private LocalDate data;
	// private LocalTime hora;
	private HorarioFuncionamento hora;
	private String tipoAtendimento;
	private Profissional profissional;
	private Boolean ativo;
	private UnidadeDaEmpresa unidade;

	public AgendaCompromisso(LocalDate data, HorarioFuncionamento horario, String tipo, Profissional p, Boolean ativo) {
		this.data = data;
		this.hora = horario;
		this.tipoAtendimento = tipo;
		this.profissional = p;
		this.ativo = ativo;
	}

	public AgendaCompromisso(LocalDate data, HorarioFuncionamento horario, Profissional p) {
		this.data = data;
		this.hora = horario;
		this.profissional = p;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public HorarioFuncionamento getHora() {
		return hora;
	}

	public void setHora(HorarioFuncionamento hora) {
		this.hora = hora;
	}

	public String getTipoAtendimento() {
		return tipoAtendimento;
	}

	public void setTipoAtendimento(String tipoAtendimento) {
		this.tipoAtendimento = tipoAtendimento;
	}

	public Profissional getProfissional() {
		return profissional;
	}

	public void setProfissional(Profissional profissional) {
		this.profissional = profissional;
	}

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

	public UnidadeDaEmpresa getUnidade() {
		return unidade;
	}

	public void setUnidade(UnidadeDaEmpresa unidade) {
		this.unidade = unidade;
	}
}
