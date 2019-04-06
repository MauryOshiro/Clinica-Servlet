package br.com.maury.clinicaCristiano.sistema.modelo;

import java.util.Collection;

public class Usuario {
	private Integer id;
	private String login;
	private String senha;
	private String tipoUsuario;
	private Boolean ativo;
	private Collection<Modulo> modulos;

	public Usuario(Integer id, Boolean ativo) {
		this.id = id;
		this.ativo = ativo;
	}

	public Usuario() {
		
	}

	public Usuario(String login, String senha, String tipoUsuario, Boolean ativo, Collection<Modulo> modulos) {
		this.login = login;
		this.senha = senha;
		this.tipoUsuario = tipoUsuario;
		this.ativo = ativo;
		this.modulos = modulos;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getTipoUsuario() {
		return tipoUsuario;
	}

	public void setTipoUsuario(String tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

	public Collection<Modulo> getModulos() {
		return modulos;
	}

	public void setModulos(Collection<Modulo> modulos) {
		this.modulos = modulos;
	}
}
