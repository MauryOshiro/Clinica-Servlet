package br.com.maury.clinicaCristiano.faturamento.modelo;

import java.time.LocalDate;
import java.util.Collection;

import br.com.maury.clinicaCristiano.atendimento.modelo.UnidadeDaEmpresa;
import br.com.maury.clinicaCristiano.faturamento.interfaces.I_ContaPagavel;

public class Fatura implements I_ContaPagavel{
	private Integer id;
	private String destinatario;
	private Double valorTotal;
	private Integer qtdParcelas;
	private Boolean cancelado;
	private LocalDate mesReferencia;
	private String observacao;
	private Collection<Parcela> parcelas;
	private UnidadeDaEmpresa unidade;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDestinatario() {
		return destinatario;
	}

	public void setDestinatario(String destinatario) {
		this.destinatario = destinatario;
	}

	public Double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public Integer getQtdParcelas() {
		return qtdParcelas;
	}

	public void setQtdParcelas(Integer qtdParcelas) {
		this.qtdParcelas = qtdParcelas;
	}

	public Boolean getCancelado() {
		return cancelado;
	}

	public void setCancelado(Boolean cancelado) {
		this.cancelado = cancelado;
	}

	public LocalDate getMesReferencia() {
		return mesReferencia;
	}

	public void setMesReferencia(LocalDate mesReferencia) {
		this.mesReferencia = mesReferencia;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public Collection<Parcela> getParcelas() {
		return parcelas;
	}

	public void setParcelas(Collection<Parcela> parcelas) {
		this.parcelas = parcelas;
	}

	public UnidadeDaEmpresa getUnidade() {
		return unidade;
	}

	public void setUnidade(UnidadeDaEmpresa unidade) {
		this.unidade = unidade;
	}

	@Override
	public void pagar(Parcela p) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void cancelarPagamento(Parcela p) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void parcelar() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void cancelarConta() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void ativarConta() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void editar() {
		// TODO Auto-generated method stub
		
	}
}
