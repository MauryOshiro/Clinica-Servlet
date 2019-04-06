package br.com.maury.clinicaCristiano.faturamento.modelo;

import java.util.Collection;

import br.com.maury.clinicaCristiano.atendimento.modelo.UnidadeDaEmpresa;
import br.com.maury.clinicaCristiano.faturamento.interfaces.I_ContaPagavel;

public class Despesa implements I_ContaPagavel{
	private Integer id;
	private String descricao;
	private TipoDespesa tipoDespesa;
	private Double valor;
	private Boolean quitado;
	private Integer qtdParcelas;
	private Boolean cancelado;
	private Collection<Parcela> parcelas;
	private UnidadeDaEmpresa unidade;

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

	public TipoDespesa getTipoDespesa() {
		return tipoDespesa;
	}

	public void setTipoDespesa(TipoDespesa tipoDespesa) {
		this.tipoDespesa = tipoDespesa;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Boolean getQuitado() {
		return quitado;
	}

	public void setQuitado(Boolean quitado) {
		this.quitado = quitado;
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
