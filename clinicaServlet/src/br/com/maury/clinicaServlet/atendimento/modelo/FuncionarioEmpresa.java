package br.com.maury.clinicaServlet.atendimento.modelo;

import br.com.maury.clinicaServlet.atendimento.abstrato.PessoaFisica;

public class FuncionarioEmpresa extends PessoaFisica{
	private String funcao;

	public String getFuncao() {
		return funcao;
	}

	public void setFuncao(String funcao) {
		this.funcao = funcao;
	}
}
