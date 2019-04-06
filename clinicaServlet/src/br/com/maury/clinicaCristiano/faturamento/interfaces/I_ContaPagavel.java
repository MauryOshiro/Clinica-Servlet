package br.com.maury.clinicaCristiano.faturamento.interfaces;

import br.com.maury.clinicaCristiano.faturamento.modelo.Parcela;

public interface I_ContaPagavel {
	public void pagar(Parcela p);

	public void cancelarPagamento(Parcela p);

	public void parcelar();

	public void cancelarConta();

	public void ativarConta();

	public void editar();
}
