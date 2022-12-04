package com.ris.pause_together.models;

public class Vsebina {
	private String naslov;
	private String avtor;
	private int leto_izdaje;
	private int ocena;

	public Vsebina(String na, String av, int li) {
		this.naslov = na;
		this.avtor = av;
		this.leto_izdaje = li;
	}
	public String getNaslov() {
		return naslov;
	}

	public void setNaslov(String naslov) {
		this.naslov = naslov;
	}

	public String getAvtor() {
		return avtor;
	}

	public void setAvtor(String avtor) {
		this.avtor = avtor;
	}

	public int getLeto_izdaje() {
		return leto_izdaje;
	}

	public void setLeto_izdaje(int leto_izdaje) {
		this.leto_izdaje = leto_izdaje;
	}

	public int getOcena() {
		return ocena;
	}
	public void setOcena(int ocena) {
		this.ocena = ocena;
	}
}