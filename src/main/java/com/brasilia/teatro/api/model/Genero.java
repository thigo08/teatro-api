package com.brasilia.teatro.api.model;

public enum Genero {

	TODOS("Todos"),
	COMEDIA("Comédia"), 
	DRAMA("Drama"), 
	INFANTIL("Infantil"), 
	MONOLOGO("Monólogo"), 
	MUSICAL("Musical"), 
	PALESTRA("Palestra"), 
	SHOW("Show"), 
	STANDUP("Standup");

	private String descricao;

	Genero(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

}
