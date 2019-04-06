package br.com.maury.clinicaCristiano.atendimento.modelo;

public class ContatoPessoaFisica {
	private Integer dddTelefonePrincipal;
	private Integer telefonePrincipal;
	private Integer dddTelefoneSecundario;
	private Integer telefoneSecundario;
	private Integer dddCelularPrincipal;
	private Integer celularPrincipal;
	private Integer dddCelularSecundario;
	private Integer celularSecundario;
	private String email;
	private Integer id;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getDddTelefonePrincipal() {
		return dddTelefonePrincipal;
	}

	public void setDddTelefonePrincipal(Integer dddTelefonePrincipal) {
		this.dddTelefonePrincipal = dddTelefonePrincipal;
	}

	public Integer getTelefonePrincipal() {
		return telefonePrincipal;
	}

	public void setTelefonePrincipal(Integer telefonePrincipal) {
		this.telefonePrincipal = telefonePrincipal;
	}

	public Integer getDddTelefoneSecundario() {
		return dddTelefoneSecundario;
	}

	public void setDddTelefoneSecundario(Integer dddTelefoneSecundario) {
		this.dddTelefoneSecundario = dddTelefoneSecundario;
	}

	public Integer getTelefoneSecundario() {
		return telefoneSecundario;
	}

	public void setTelefoneSecundario(Integer telefoneSecundario) {
		this.telefoneSecundario = telefoneSecundario;
	}

	public Integer getDddCelularPrincipal() {
		return dddCelularPrincipal;
	}

	public void setDddCelularPrincipal(Integer dddCelularPrincipal) {
		this.dddCelularPrincipal = dddCelularPrincipal;
	}

	public Integer getCelularPrincipal() {
		return celularPrincipal;
	}

	public void setCelularPrincipal(Integer celularPrincipal) {
		this.celularPrincipal = celularPrincipal;
	}

	public Integer getDddCelularSecundario() {
		return dddCelularSecundario;
	}

	public void setDddCelularSecundario(Integer dddCelularSecundario) {
		this.dddCelularSecundario = dddCelularSecundario;
	}

	public Integer getCelularSecundario() {
		return celularSecundario;
	}

	public void setCelularSecundario(Integer celularSecundario) {
		this.celularSecundario = celularSecundario;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public ContatoPessoaFisica(Integer dddTP, Integer tP, Integer dddTS, Integer tS, Integer dddCP, Integer cP,
			Integer dddCS, Integer cS, String email) {
		this.dddTelefonePrincipal = dddTP;
		this.telefonePrincipal = tP;
		this.dddTelefoneSecundario = dddTS;
		this.telefoneSecundario = tS;
		this.dddCelularPrincipal = dddCP;
		this.celularPrincipal = cP;
		this.dddCelularSecundario = dddCS;
		this.celularSecundario = cS;
		this.email = email;
	}
	
	public ContatoPessoaFisica(Integer dddTP, Integer tP, Integer dddTS, Integer tS, Integer dddCP, Integer cP,
			Integer dddCS, Integer cS, String email, Integer id) {
		this.dddTelefonePrincipal = dddTP;
		this.telefonePrincipal = tP;
		this.dddTelefoneSecundario = dddTS;
		this.telefoneSecundario = tS;
		this.dddCelularPrincipal = dddCP;
		this.celularPrincipal = cP;
		this.dddCelularSecundario = dddCS;
		this.celularSecundario = cS;
		this.email = email;
		this.id = id;
	}
	
	public static Integer converteDDDParaInteger(String t) {
		Integer ddd = Integer.valueOf(t.substring(1, 3));
		return ddd;
	}

	public static Integer converteTelefoneParaInteger(String t) {
		String telefoneString = t.substring(5, 9);
		telefoneString = telefoneString.concat(t.substring(10, 14));
		Integer telefone = Integer.valueOf(telefoneString);
		return telefone;
	}

	public static Integer converteCelularParaInteger(String c) {
		String celularString = c.substring(5, 10);
		celularString = celularString.concat(c.substring(11, 15));
		Integer celular = Integer.valueOf(celularString);
		return celular;
	}
}
