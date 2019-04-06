package br.com.maury.clinicaServlet.fluxoDeCaixa.modelo;

import br.com.maury.clinicaServlet.faturamento.modelo.Despesa;

public class LancamentoDespesa extends Lancamento{
	private Despesa despesa;

	public Despesa getDespesa() {
		return despesa;
	}

	public void setDespesa(Despesa despesa) {
		this.despesa = despesa;
	}
}
