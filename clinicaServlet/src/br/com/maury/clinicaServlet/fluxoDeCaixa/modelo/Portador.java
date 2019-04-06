package br.com.maury.clinicaServlet.fluxoDeCaixa.modelo;

import java.time.LocalDate;
import java.util.Collection;

import br.com.maury.clinicaServlet.atendimento.modelo.UnidadeDaEmpresa;

public class Portador {
	private Integer id;
	private String tipoPortador;
	private String nomePortador;
	private String descricao;
	private LocalDate dataConciliacao;
	private Boolean ativo;
	private Integer sequenciaLancamento;
	private PortadorSaldo saldo;
	private Boolean podeTerSaldoNegativo;
	private Collection<UnidadeDaEmpresa> unidades;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTipoPortador() {
		return tipoPortador;
	}

	public void setTipoPortador(String tipoPortador) {
		this.tipoPortador = tipoPortador;
	}

	public String getNomePortador() {
		return nomePortador;
	}

	public void setNomePortador(String nomePortador) {
		this.nomePortador = nomePortador;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public LocalDate getDataConciliacao() {
		return dataConciliacao;
	}

	public void setDataConciliacao(LocalDate dataConciliacao) {
		this.dataConciliacao = dataConciliacao;
	}

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

	public Integer getSequenciaLancamento() {
		return sequenciaLancamento;
	}

	public void setSequenciaLancamento(Integer sequenciaLancamento) {
		this.sequenciaLancamento = sequenciaLancamento;
	}

	public PortadorSaldo getSaldo() {
		return saldo;
	}

	public void setSaldo(PortadorSaldo saldo) {
		this.saldo = saldo;
	}

	public Boolean getPodeTerSaldoNegativo() {
		return podeTerSaldoNegativo;
	}

	public void setPodeTerSaldoNegativo(Boolean podeTerSaldoNegativo) {
		this.podeTerSaldoNegativo = podeTerSaldoNegativo;
	}

	public Collection<UnidadeDaEmpresa> getUnidades() {
		return unidades;
	}

	public void setUnidades(Collection<UnidadeDaEmpresa> unidades) {
		this.unidades = unidades;
	}
}
