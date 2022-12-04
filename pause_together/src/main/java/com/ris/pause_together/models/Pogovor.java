package com.ris.pause_together.models;

import java.util.ArrayList;

public class Pogovor implements Komunikacija {

	private String naziv;
	public ArrayList<Uporabnik> sodeluje;

	public Pogovor() {
		sodeluje = new ArrayList<>();
	}

	public Pogovor(String naz) {
		this();
		this.naziv = naz;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public String getNaziv() {
		return naziv;
	}

	public void posljiSporocilo(String tekst) {}
}