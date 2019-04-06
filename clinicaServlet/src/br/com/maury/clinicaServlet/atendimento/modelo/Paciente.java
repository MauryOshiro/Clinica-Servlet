package br.com.maury.clinicaServlet.atendimento.modelo;

import java.math.BigInteger;
import java.time.LocalDate;

import br.com.maury.clinicaServlet.atendimento.abstrato.PessoaFisica;

public class Paciente extends PessoaFisica {
	private Integer idPaciente;
	private Boolean conveniado;
	private Profissional profissional;
	private String prontuario;
	private Boolean ativo;
	private ClinicaParceira clinica;

	public ClinicaParceira getClinica() {
		return clinica;
	}

	public void setClinica(ClinicaParceira clinica) {
		this.clinica = clinica;
	}

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

	public Integer getIdPaciente() {
		return idPaciente;
	}

	public void setIdPaciente(Integer idPaciente) {
		this.idPaciente = idPaciente;
	}

	public Boolean getConveniado() {
		return conveniado;
	}

	public void setConveniado(Boolean conveniado) {
		this.conveniado = conveniado;
	}

	public Profissional getProfissional() {
		return profissional;
	}

	public void setProfissional(Profissional profissional) {
		this.profissional = profissional;
	}

	public String getProntuario() {
		return prontuario;
	}

	public void setProntuario(String prontuario) {
		this.prontuario = prontuario;
	}
	
	public Paciente(Boolean conveniado, String prontuario, String nome,
			String sobrenome, String rg, BigInteger cpf, LocalDate dataNascimento, String observacao,
			Endereco endereco, Boolean ativo, ContatoPessoaFisica contato, String sexo, 
			String nivelEscolaridade, Integer idade) {
		super(nome,sobrenome,rg,cpf,dataNascimento,observacao,endereco,contato,sexo,nivelEscolaridade,idade);
		this.conveniado = conveniado;
		this.prontuario = prontuario;
		this.ativo = ativo;
		
		//System.out.println("Nome no construtor: "+nome);
		//System.out.println("Nome na classe m�e: "+getNome());
		/*setNome(nome);
		setSobrenome(sobrenome);
		setRg(rg);
		setCpf(cpf);
		setDataNascimento(dataNascimento);
		setObservacao(observacao);
		setEndereco(endereco);
		setContato(contato);
		setSexo(sexo);
		setNivelEscolaridade(nivelEscolaridade);
		setIdade(idade);*/
		
	}

	public Paciente(Integer id, String nome, String sobrenome, BigInteger cpf) {
		this.idPaciente = id;
		this.setNome(nome);
		this.setSobrenome(sobrenome);
		this.setCpf(cpf);
	}
}
