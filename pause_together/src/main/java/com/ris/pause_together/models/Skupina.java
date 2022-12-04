package com.ris.pause_together.models;

import java.util.ArrayList;

public class Skupina implements Komunikacija {
	private String naziv;
	private ArrayList<Uporabnik> uporabniki;
	private Uporabnik vodja;


	public Skupina(Uporabnik vod) {
		this.vodja = vod;
		uporabniki = new ArrayList<>();
	}

	public Skupina(Uporabnik vod, String naz) {
		this(vod);
		this.naziv = naz;
	}

	public void dodajClana(Uporabnik clan) {

	}
	public void odstraniClana(Uporabnik clan) {

	}

	public ArrayList<Uporabnik> vrniClane() {
		return null;
	}

	public void odstraniSkupino() {

	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}
	public String getNaziv() {
		return naziv;
	}

	public ArrayList<Uporabnik> getUporabniki() {
		return uporabniki;
	}

	public void setUporabniki(ArrayList<Uporabnik> uporabniki) {
		this.uporabniki = uporabniki;
	}

	public Uporabnik getVodja() {
		return vodja;
	}

	public void setVodja(Uporabnik vodja) {
		this.vodja = vodja;
	}

	@Override
	public void posljiSporocilo(String tekst) {

	}
}