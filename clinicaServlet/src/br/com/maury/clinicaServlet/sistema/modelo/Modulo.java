package br.com.maury.clinicaServlet.sistema.modelo;

import java.util.ArrayList;
import java.util.Collection;

public class Modulo {
	private Integer id;
	private String nomeModulo;
	
	public Modulo(Integer id, String nomeModulo) {
		this.id = id;
		this.nomeModulo = nomeModulo;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNomeModulo() {
		return nomeModulo;
	}

	public void setNomeModulo(String nomeModulo) {
		this.nomeModulo = nomeModulo;
	}
	
	public static Collection<Modulo> preparaCollectionModulo(Integer idModulo1, String nomeModulo1, Integer idModulo2,
			String nomeModulo2, Integer idModulo3, String nomeModulo3) {
		Collection<Modulo> modulos = new ArrayList<>();
		if(idModulo1 != null)
			adicionaModuloNaCollection(modulos, idModulo1, nomeModulo1);
			
		
		if(idModulo2 != null)
			adicionaModuloNaCollection(modulos, idModulo2, nomeModulo2);
		
		if(idModulo3 != null)
			adicionaModuloNaCollection(modulos, idModulo3, nomeModulo3);
			
		return modulos;
	}
	
	public static void adicionaModuloNaCollection(Collection<Modulo> modulos, Integer id, String nome) {
		Modulo modulo = new Modulo(id, nome);
		modulos.add(modulo);
	}
}
