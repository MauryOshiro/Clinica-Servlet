package br.com.maury.clinicaCristiano.fluxoDeCaixa.modelo;

import br.com.maury.clinicaCristiano.faturamento.modelo.Despesa;

public class LancamentoDespesa extends Lancamento{
	private Despesa despesa;

	public Despesa getDespesa() {
		return despesa;
	}

	public void setDespesa(Despesa despesa) {
		this.despesa = despesa;
	}
}
