package com.brasilia.teatro.api.model;

import javax.persistence.Embeddable;

@Embeddable
public class Informacao {

	private String elenco;
	private String ficha;
	private String duracao;

	public String getElenco() {
		return elenco;
	}

	public void setElenco(String elenco) {
		this.elenco = elenco;
	}

	public String getFicha() {
		return ficha;
	}

	public void setFicha(String ficha) {
		this.ficha = ficha;
	}

	public String getDuracao() {
		return duracao;
	}

	public void setDuracao(String duracao) {
		this.duracao = duracao;
	}

}
