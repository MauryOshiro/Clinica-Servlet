package br.com.maury.clinicaCristiano.atendimento.modelo;

import br.com.maury.clinicaCristiano.atendimento.abstrato.PessoaFisica;

public class FuncionarioEmpresa extends PessoaFisica{
	private String funcao;

	public String getFuncao() {
		return funcao;
	}

	public void setFuncao(String funcao) {
		this.funcao = funcao;
	}
}
