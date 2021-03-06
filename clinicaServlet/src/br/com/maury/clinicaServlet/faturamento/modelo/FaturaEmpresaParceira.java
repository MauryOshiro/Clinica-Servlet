package br.com.maury.clinicaServlet.faturamento.modelo;

import java.util.Collection;

import br.com.maury.clinicaServlet.atendimento.modelo.AgendaFuncionarioEmpresa;
import br.com.maury.clinicaServlet.atendimento.modelo.EmpresaParceira;

public class FaturaEmpresaParceira extends Fatura{
	private EmpresaParceira empresa;
	private Collection<AgendaFuncionarioEmpresa> agendasFuncionario;

	public EmpresaParceira getEmpresa() {
		return empresa;
	}

	public void setEmpresa(EmpresaParceira empresa) {
		this.empresa = empresa;
	}

	public Collection<AgendaFuncionarioEmpresa> getAgendasFuncionario() {
		return agendasFuncionario;
	}

	public void setAgendasFuncionario(Collection<AgendaFuncionarioEmpresa> agendasFuncionario) {
		this.agendasFuncionario = agendasFuncionario;
	}
}
