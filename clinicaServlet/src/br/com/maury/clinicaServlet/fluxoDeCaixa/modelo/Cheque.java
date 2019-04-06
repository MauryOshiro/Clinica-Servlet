package br.com.maury.clinicaServlet.fluxoDeCaixa.modelo;

import java.time.LocalDate;

public class Cheque {
	private Integer id;
	private LancamentoDespesa lancamentoDespesa;
	private LocalDate dataBaixa;
	private Boolean baixado;
	private Boolean sustado;
	private Integer numero;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LancamentoDespesa getLancamentoDespesa() {
		return lancamentoDespesa;
	}

	public void setLancamentoDespesa(LancamentoDespesa lancamentoDespesa) {
		this.lancamentoDespesa = lancamentoDespesa;
	}

	public LocalDate getDataBaixa() {
		return dataBaixa;
	}

	public void setDataBaixa(LocalDate dataBaixa) {
		this.dataBaixa = dataBaixa;
	}

	public Boolean getBaixado() {
		return baixado;
	}

	public void setBaixado(Boolean baixado) {
		this.baixado = baixado;
	}

	public Boolean getSustado() {
		return sustado;
	}

	public void setSustado(Boolean sustado) {
		this.sustado = sustado;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}
}
