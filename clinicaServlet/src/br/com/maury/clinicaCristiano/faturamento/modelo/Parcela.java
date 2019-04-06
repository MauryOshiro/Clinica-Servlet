package br.com.maury.clinicaCristiano.faturamento.modelo;

import java.time.LocalDate;

public class Parcela {
	private Integer id;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getNumeroParcela() {
		return numeroParcela;
	}

	public void setNumeroParcela(Integer numeroParcela) {
		this.numeroParcela = numeroParcela;
	}

	public Double getValorParcela() {
		return valorParcela;
	}

	public void setValorParcela(Double valorParcela) {
		this.valorParcela = valorParcela;
	}

	public Boolean getPago() {
		return pago;
	}

	public void setPago(Boolean pago) {
		this.pago = pago;
	}

	public LocalDate getDataPagamento() {
		return dataPagamento;
	}

	public void setDataPagamento(LocalDate dataPagamento) {
		this.dataPagamento = dataPagamento;
	}

	public LocalDate getVencimentoOriginal() {
		return vencimentoOriginal;
	}

	public void setVencimentoOriginal(LocalDate vencimentoOriginal) {
		this.vencimentoOriginal = vencimentoOriginal;
	}

	public LocalDate getVencimentoReal() {
		return vencimentoReal;
	}

	public void setVencimentoReal(LocalDate vencimentoReal) {
		this.vencimentoReal = vencimentoReal;
	}

	public Double getValorDesconto() {
		return valorDesconto;
	}

	public void setValorDesconto(Double valorDesconto) {
		this.valorDesconto = valorDesconto;
	}

	public Double getValorJuros() {
		return valorJuros;
	}

	public void setValorJuros(Double valorJuros) {
		this.valorJuros = valorJuros;
	}

	Integer numeroParcela;
	Double valorParcela;
	Boolean pago;
	LocalDate dataPagamento;
	LocalDate vencimentoOriginal;
	LocalDate vencimentoReal;
	Double valorDesconto;
	Double valorJuros;
}
