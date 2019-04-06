package br.com.maury.clinicaCristiano.atendimento.modelo;

import java.time.LocalDate;
import java.util.Collection;

import br.com.maury.clinicaCristiano.atendimento.abstrato.PessoaJuridica;

public class ClinicaParceira extends PessoaJuridica {

	private String observacao;
	private Integer id;
	private LocalDate dataInicioParceria;
	private Boolean ativo;
	private Collection<ContatoNaPessoaJuridica> contatos;
	private Collection<Paciente> pacientes;

	public ClinicaParceira(Integer id, String nomeFantasia) {
		this.id = id;
		setNomeFantasia(nomeFantasia);
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDate getDataInicioParceria() {
		return dataInicioParceria;
	}

	public void setDataInicioParceria(LocalDate dataInicioParceria) {
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

	public Collection<Paciente> getPacientes() {
		return pacientes;
	}

	public void setPacientes(Collection<Paciente> pacientes) {
		this.pacientes = pacientes;
	}
}
