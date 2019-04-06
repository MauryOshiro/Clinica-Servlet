package br.com.maury.clinicaServlet.faturamento.modelo;

import java.util.Collection;

import br.com.maury.clinicaServlet.atendimento.modelo.Convenio;
import br.com.maury.clinicaServlet.atendimento.modelo.GuiaConvenio;

public class FaturaConvenio extends Fatura{
	private Convenio convenio;
	private Collection<GuiaConvenio> guias;

	public Convenio getConvenio() {
		return convenio;
	}

	public void setConvenio(Convenio convenio) {
		this.convenio = convenio;
	}

	public Collection<GuiaConvenio> getGuias() {
		return guias;
	}

	public void setGuias(Collection<GuiaConvenio> guias) {
		this.guias = guias;
	}
}
