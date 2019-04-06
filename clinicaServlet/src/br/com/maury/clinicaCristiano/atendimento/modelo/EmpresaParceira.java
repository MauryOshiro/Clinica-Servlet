package br.com.maury.clinicaCristiano.atendimento.modelo;

import java.util.Collection;
import java.util.Date;

import br.com.maury.clinicaCristiano.atendimento.abstrato.PessoaJuridica;

public class EmpresaParceira extends PessoaJuridica {
	private Integer id;
	private String observacao;
	private Date dataInicioParceria;
	private Boolean ativo;
	private Collection<ContatoNaPessoaJuridica> contatos;
	private Collection<FuncionarioEmpresa> funcionarios;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public Date getDataInicioParceria() {
		return dataInicioParceria;
	}

	public void setDataInicioParceria(Date dataInicioParceria) {
		this.dataInicioParceria = dataInicioParceria;
	}

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

	public Collection<ContatoNaPessoaJuridica> getContatos() {
		return contatos;
	}

	public void setContatos(Collection<ContatoNaPessoaJuridica> contatos) {
		this.contatos = contatos;
	}

	public Collection<FuncionarioEmpresa> getFuncionarios() {
		return funcionarios;
	}

	public void setFuncionarios(Collection<FuncionarioEmpresa> funcionarios) {
		this.funcionarios = funcionarios;
	}
}
