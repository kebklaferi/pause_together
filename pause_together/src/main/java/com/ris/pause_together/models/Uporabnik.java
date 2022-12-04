package com.ris.pause_together.models;

import java.util.ArrayList;

public class Uporabnik {
	private String username;
	private String email;
	private String geslo;
	private Profil ima_profil;
	private ArrayList<Skupina> skupine;
	private ArrayList<Prosnja> poslane_prosnje;
	private ArrayList<Pogovor> sodeluje;
	private ArrayList<Forum> ustvarjeni;
	private ArrayList<Seznam> seznami;
	private ArrayList<Prosnja> prejete_prosnje;

	public Uporabnik(){
		skupine = new ArrayList<Skupina>();
		poslane_prosnje = new ArrayList<Prosnja>();
		sodeluje = new ArrayList<Pogovor>();
		ustvarjeni = new ArrayList<Forum>();
		seznami = new ArrayList<Seznam>();
		prejete_prosnje = new ArrayList<>();
	};
	public Uporabnik(String username, String email, String geslo) {
		this();
		this.username = username;
		this.email = email;
		this.geslo = geslo;
	}

	public ArrayList<Skupina> vrniSkupine() {
		return null;
	}

	public void posljiProsnjo(Skupina sku) {

	}

	public static ArrayList<Vsebina> isci_multimedijo(String niz) {
		return null;
	}

	public static ArrayList<Uporabnik> gps_iskanje(String niz) {
		return null;
	}

	public void potrdiProsnjo(Skupina sku, Uporabnik upo) {

	}

	public ArrayList<Skupina> vrniUstvarjeneSkupine() {
		return null;
	}

	public void dodajProsnjo(Prosnja pro) {

	}



	public String getUsername() {
		return this.username;
	}
}