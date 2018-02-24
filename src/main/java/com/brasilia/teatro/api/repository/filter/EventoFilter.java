package com.brasilia.teatro.api.repository.filter;

import com.brasilia.teatro.api.model.Genero;

public class EventoFilter {

	private String nome;

	private String descricao;

	private Genero genero;

	private String nomeLocal;

	private String estadoLocal;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}

	public String getNomeLocal() {
		return nomeLocal;
	}

	public void setNomeLocal(String nomeLocal) {
		this.nomeLocal = nomeLocal;
	}

	public String getEstadoLocal() {
		return estadoLocal;
	}

	public void setEstadoLocal(String estadoLocal) {
		this.estadoLocal = estadoLocal;
	}

}
