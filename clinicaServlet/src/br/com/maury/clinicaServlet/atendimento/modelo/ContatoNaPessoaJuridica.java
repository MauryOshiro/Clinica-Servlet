package br.com.maury.clinicaServlet.atendimento.modelo;

public class ContatoNaPessoaJuridica {
	private Integer id;
	private String nome;
	private ContatoPessoaFisica contato;
	private String observacao;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public ContatoPessoaFisica getContato() {
		return contato;
	}

	public void setContato(ContatoPessoaFisica contato) {
		this.contato = contato;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}
}
