package br.com.maury.clinicaCristiano.atendimento.modelo;

import java.util.Date;

public class LaudoDeAvaliacao {
	private Integer id;
	private Exame exame;
	private String laudo;
	private Date dataEmissao;
	private FuncionarioEmpresa funcionarioEmpresa;
	private Boolean finalizado;
	private Boolean cancelado;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Exame getExame() {
		return exame;
	}

	public void setExame(Exame exame) {
		this.exame = exame;
	}

	public String getLaudo() {
		return laudo;
	}

	public void setLaudo(String laudo) {
		this.laudo = laudo;
	}

	public Date getDataEmissao() {
		return dataEmissao;
	}

	public void setDataEmissao(Date dataEmissao) {
		this.dataEmissao = dataEmissao;
	}

	public FuncionarioEmpresa getFuncionarioEmpresa() {
		return funcionarioEmpresa;
	}

	public void setFuncionarioEmpresa(FuncionarioEmpresa funcionarioEmpresa) {
		this.funcionarioEmpresa = funcionarioEmpresa;
	}

	public Boolean getFinalizado() {
		return finalizado;
	}

	public void setFinalizado(Boolean finalizado) {
		this.finalizado = finalizado;
	}

	public Boolean getCancelado() {
		return cancelado;
	}

	public void setCancelado(Boolean cancelado) {
		this.cancelado = cancelado;
	}
}
