package br.com.maury.clinicaServlet.atendimento.modelo;

import java.math.BigInteger;
import java.time.LocalDate;
import java.util.Collection;

import br.com.maury.clinicaServlet.sistema.modelo.Usuario;

public class Profissional extends Funcionario {
	private Integer id;
	private String crp;

	public Profissional(String nome, String sobrenome, String rg, BigInteger cpf, LocalDate dataNascimento,
			String observacao, Endereco endereco, ContatoPessoaFisica contato, String sexo, String nivelEscolaridade,
			Integer idade, String departamento, Cargo cargo, LocalDate dataAdmissao, Boolean ativo, Usuario usuario, 
			Collection<UnidadeDaEmpresa> unidades,String crp) {
		
		super(nome,sobrenome,rg,cpf,dataNascimento,observacao,endereco,contato,sexo,nivelEscolaridade,idade,
				departamento,cargo,dataAdmissao,ativo,usuario,unidades);
		
		this.crp = crp;
		
	}
	
	public Profissional() {
		
	}

	public Integer getIdProfissional() {
		return id;
	}

	public void setIdProfissional(Integer id) {
		this.id = id;
	}

	public String getCrp() {
		return crp;
	}

	public void setCrp(String crp) {
		this.crp = crp;
	}

	public static Profissional retornaPrimeiroProfissional(Collection<Profissional> profissionais) {
		//Cria um vetor do tipo Profissional.
		//O m�todo toArray() deve ter par�metro para alocar um espa�o de mem�ria do tamanho da collection.
		Profissional[] p = profissionais.toArray(new Profissional[profissionais.size()]);
		Profissional profissional = p[0];
		return profissional;
	}
}
