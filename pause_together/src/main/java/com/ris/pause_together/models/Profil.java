package com.ris.pause_together.models;

public class Profil {

	private String ime;
	private String priimek;
	private int starost;
	private String slika;

	public void spremeniSliko() {

	}

	public void spremeniPodatke() {

	}

	public Profil(String im, String pr, int st) {
		this.ime = im;
		this.priimek = pr;
		this.starost = st;
	}

	public Profil() {

	}
	public String getIme() {
		return ime;
	}

	public String getPriimek() {
		return priimek;
	}

	public int getStarost() {
		return starost;
	}

	public String getSlika() {
		return slika;
	}
	public void setIme(String ime) {
		this.ime = ime;
	}

	public void setPriimek(String priimek) {
		this.priimek = priimek;
	}

	public void setSlika(String slika) {
		this.slika = slika;
	}
	public void setStarost(int starost) {
		this.starost = starost;
	}
}