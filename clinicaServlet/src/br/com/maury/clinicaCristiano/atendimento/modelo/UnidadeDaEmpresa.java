package br.com.maury.clinicaCristiano.atendimento.modelo;

import java.util.ArrayList;
import java.util.Collection;

public class UnidadeDaEmpresa {
	private Integer id;
	private String descricao;
	private Boolean ativo;

	public UnidadeDaEmpresa(Integer id, String descricao) {
		this.id = id;
		this.descricao = descricao;
	}

	public UnidadeDaEmpresa(Integer id, String descricao, Boolean ativo) {
		this.id = id;
		this.descricao = descricao;
		this.ativo = ativo;
	}

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

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

	public static Collection<UnidadeDaEmpresa> preparaCollectionUnidadeDaEmpresa(Integer idUnidade1, String descricaoUnidade1,
			Integer idUnidade2, String descricaoUnidade2, Integer idUnidade3, String descricaoUnidade3,
			Integer idUnidade4, String descricaoUnidade4, Integer idUnidade5, String descricaoUnidade5) {
		Collection<UnidadeDaEmpresa> unidades = new ArrayList<>();
		if(idUnidade1 != null)
			adicionaUnidadeDaEmpresaNaCollection(unidades,idUnidade1,descricaoUnidade1);
		
		if(idUnidade2 != null)
			adicionaUnidadeDaEmpresaNaCollection(unidades, idUnidade2, descricaoUnidade2);
		
		if(idUnidade3 != null)
			adicionaUnidadeDaEmpresaNaCollection(unidades, idUnidade3, descricaoUnidade3);
		
		if(idUnidade4 != null)
			adicionaUnidadeDaEmpresaNaCollection(unidades, idUnidade4, descricaoUnidade4);
		
		if(idUnidade5 != null)
			adicionaUnidadeDaEmpresaNaCollection(unidades, idUnidade5, descricaoUnidade5);
		
		return unidades;
	}

	private static void adicionaUnidadeDaEmpresaNaCollection(Collection<UnidadeDaEmpresa> unidades, Integer id, String descricao) {
		UnidadeDaEmpresa unidade = new UnidadeDaEmpresa(id,descricao);
		unidades.add(unidade);
	}

	public static UnidadeDaEmpresa retornaPrimeiraUnidade(Collection<UnidadeDaEmpresa> unidades) {
		//Cria um vetor do tipo UnidadeDaEmpresa.
		//O método toArray() deve ter parâmetro para alocar um espaço de memória do tamanho da collection.
		UnidadeDaEmpresa[] u = unidades.toArray(new UnidadeDaEmpresa[unidades.size()]);
		UnidadeDaEmpresa unidade = u[0];
		return unidade;
	}

}
