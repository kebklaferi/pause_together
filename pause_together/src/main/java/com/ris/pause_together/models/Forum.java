package com.ris.pause_together.models;

import java.util.ArrayList;

public class Forum implements Komunikacija {
	private String naziv;
	private ArrayList<String> oznacbe;

	public Forum() {
		oznacbe = new ArrayList<>();
	}

	public Forum(String naziv){
		this();
		this.naziv = naziv;
	}

	public void dodajOznacbo(String ozn) {

	}

	public void posljiSporocilo(String tekst) { }
}