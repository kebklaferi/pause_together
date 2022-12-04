package com.ris.pause_together.models;

import java.util.ArrayList;

public class Seznam {
	private String naziv;
	private ArrayList<Vsebina> vsebine;

	public Seznam() {
		vsebine = new ArrayList<>();
	}
	public Seznam(String naz) {
		this();
		this.naziv = naz;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public ArrayList<Vsebina> getVsebine() {
		return vsebine;
	}

	public void setVsebine(ArrayList<Vsebina> vsebine) {
		this.vsebine = vsebine;
	}


	public void dodajVsebino(Vsebina vseb){
		vsebine.add(vseb);
	}
}