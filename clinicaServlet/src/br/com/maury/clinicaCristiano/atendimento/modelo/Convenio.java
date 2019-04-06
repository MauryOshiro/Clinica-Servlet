package br.com.maury.clinicaCristiano.atendimento.modelo;

import br.com.maury.clinicaCristiano.atendimento.abstrato.PessoaJuridica;

public class Convenio extends PessoaJuridica {
	private Integer idCon;
	private double valorConsulta;
	private Boolean ativo;

	public Integer getIdCon() {
		return idCon;
	}

	public void setIdCon(Integer idCon) {
		this.idCon = idCon;
	}

	public Double getValorConsulta() {
		return valorConsulta;
	}

	public void setValorConsulta(Double valorConsulta) {
		this.valorConsulta = valorConsulta;
	}

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

	public Convenio(Integer idCon, String nomeFantasia) {
		this.idCon = idCon;
		setNomeFantasia(nomeFantasia);
	}
}
