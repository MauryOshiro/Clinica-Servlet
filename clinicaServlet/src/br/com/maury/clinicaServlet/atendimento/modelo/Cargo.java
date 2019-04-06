package br.com.maury.clinicaServlet.atendimento.modelo;

public class Cargo {
	private String descricao;
	private Integer id;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public Cargo(String descricao) {
		this.descricao = descricao;
	}

	public Cargo(String descricao, Integer id) {
		this.descricao = descricao;
		this.id = id;
	}
}
