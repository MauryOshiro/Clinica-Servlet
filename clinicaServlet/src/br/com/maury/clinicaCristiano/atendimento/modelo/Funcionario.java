package br.com.maury.clinicaCristiano.atendimento.modelo;

import java.math.BigInteger;
import java.time.LocalDate;
import java.util.Collection;

import br.com.maury.clinicaCristiano.atendimento.abstrato.PessoaFisica;
import br.com.maury.clinicaCristiano.sistema.modelo.Usuario;

public class Funcionario extends PessoaFisica{
	private Integer id;
	private String departamento;
	private Cargo cargo;
	private LocalDate dataAdmissao;
	private LocalDate dataDemissao;
	private Boolean ativo;
	private Usuario usuario;
	private Collection<UnidadeDaEmpresa> unidades;
	
	public Funcionario(String nome, String sobrenome, String rg, BigInteger cpf, LocalDate dataNascimento,
			String observacao, Endereco endereco, ContatoPessoaFisica contato, String sexo, String nivelEscolaridade,
			Integer idade, String departamento, Cargo cargo, LocalDate dataAdmissao, Boolean ativo,
			Usuario usuario, Collection<UnidadeDaEmpresa> unidades) {
		super(nome,sobrenome,rg,cpf,dataNascimento,observacao,endereco,contato,sexo,nivelEscolaridade,idade);
		this.departamento = departamento;
		this.cargo = cargo;
		this.dataAdmissao = dataAdmissao;
		this.ativo = ativo;
		this.usuario = usuario;
		this.unidades = unidades;
	}
	
	public Funcionario() {
		
	};
	
	public Integer getIdFuncionario() {
		return id;
	}

	public void setIdFuncionario(Integer id) {
		this.id = id;
	}

	public String getDepartamento() {
		return departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}

	public Cargo getCargo() {
		return cargo;
	}

	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}

	public LocalDate getDataAdmissao() {
		return dataAdmissao;
	}

	public void setDataAdmissao(LocalDate dataAdmissao) {
		this.dataAdmissao = dataAdmissao;
	}

	public LocalDate getDataDemissao() {
		return dataDemissao;
	}

	public void setDataDemissao(LocalDate dataDemissao) {
		this.dataDemissao = dataDemissao;
	}

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Collection<UnidadeDaEmpresa> getUnidades() {
		return unidades;
	}

	public void setUnidades(Collection<UnidadeDaEmpresa> unidades) {
		this.unidades = unidades;
	}
}
