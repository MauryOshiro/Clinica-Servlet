package br.com.maury.clinicaServlet.atendimento.abstrato;

import java.math.BigInteger;
import java.time.LocalDate;

import br.com.maury.clinicaServlet.atendimento.modelo.ContatoPessoaFisica;
import br.com.maury.clinicaServlet.atendimento.modelo.Endereco;

public abstract class PessoaFisica {
	Integer id;
	String nome;
	String sobrenome;
	String rg;
	BigInteger cpf;
	LocalDate dataNascimento;
	String observacao;
	Endereco endereco;
	ContatoPessoaFisica contato;
	String sexo;
	String nivelEscolaridade;
	Integer idade;

	public Integer getIdPessoaFisica() {
		return id;
	}

	public void setIdPessoaFisica(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public BigInteger getCpf() {
		return cpf;
	}

	public void setCpf(BigInteger cpf) {
		this.cpf = cpf;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public ContatoPessoaFisica getContato() {
		return contato;
	}

	public void setContato(ContatoPessoaFisica contato) {
		this.contato = contato;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getNivelEscolaridade() {
		return nivelEscolaridade;
	}

	public void setNivelEscolaridade(String nivelEscolaridade) {
		this.nivelEscolaridade = nivelEscolaridade;
	}

	public Integer getIdade() {
		return idade;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}
	
	public PessoaFisica(String nome, String sobrenome, String rg, BigInteger cpf, LocalDate dataNascimento,
			String observacao, Endereco endereco, ContatoPessoaFisica contato, String sexo, String nivelEscolaridade, 
			Integer idade) {
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.rg = rg;
		this.cpf = cpf;
		this.dataNascimento = dataNascimento;
		this.observacao = observacao;
		this.endereco = endereco;
		this.contato = contato;
		this.sexo = sexo;
		this.nivelEscolaridade = nivelEscolaridade;
		this.idade = idade;
	}
	
	public PessoaFisica() {
		
	};
}
