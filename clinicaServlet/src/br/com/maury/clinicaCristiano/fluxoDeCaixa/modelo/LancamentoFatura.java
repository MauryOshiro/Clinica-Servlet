package br.com.maury.clinicaCristiano.fluxoDeCaixa.modelo;

import br.com.maury.clinicaCristiano.faturamento.modelo.Fatura;

public class LancamentoFatura extends Lancamento{
	private Fatura fatura;

	public Fatura getFatura() {
		return fatura;
	}

	public void setFatura(Fatura fatura) {
		this.fatura = fatura;
	}
}
