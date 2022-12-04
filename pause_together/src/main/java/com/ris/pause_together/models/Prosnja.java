package com.ris.pause_together.models;

public class Prosnja {
	private Skupina skupina;
	public Uporabnik posiljatelj;
	public Uporabnik prejemnik;


	public Prosnja(){}

	public Prosnja(Skupina s, Uporabnik od, Uporabnik za){
		this.skupina = s;
		this.posiljatelj = od;
		this.prejemnik = za;
	}

	public Skupina getSkupina() {
		return skupina;
	}

	public void setSkupina(Skupina skupina) {
		this.skupina = skupina;
	}

	public Uporabnik getPosiljatelj() {
		return posiljatelj;
	}

	public void setPosiljatelj(Uporabnik posiljatelj) {
		this.posiljatelj = posiljatelj;
	}

	public Uporabnik getPrejemnik() {
		return prejemnik;
	}

	public void setPrejemnik(Uporabnik prejemnik) {
		this.prejemnik = prejemnik;
	}

	public void potrdiProsnjo() {
	}
}