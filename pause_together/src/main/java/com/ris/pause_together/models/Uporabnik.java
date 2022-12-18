package com.ris.pause_together.models;

import jakarta.persistence.*;

import java.util.ArrayList;

@Entity
@Table(name = "uporabniki")
public class Uporabnik {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;
	@Column(name = "username")
	private String username;
	@Column(name = "email")
	private String email;
	@Column(name = "geslo")
	private String geslo;

	//tisti, ki bo imel foreign key, bo imel annotation joincolumn
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "profil_id")
	private Profil ima_profil;

	//private ArrayList<Skupina> skupine;

	//@OneToMany(mappedBy = "uporabnik", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	//private ArrayList<Seznam> seznami;

	/* private ArrayList<Prosnja> poslane_prosnje;
	private ArrayList<Pogovor> sodeluje;
	private ArrayList<Forum> ustvarjeni;
	private ArrayList<Prosnja> prejete_prosnje; */

	public Uporabnik(){
		//skupine = new ArrayList<Skupina>();
		//poslane_prosnje = new ArrayList<Prosnja>();
		//sodeluje = new ArrayList<Pogovor>();
		//ustvarjeni = new ArrayList<Forum>();
		//seznami = new ArrayList<Seznam>();
		//prejete_prosnje = new ArrayList<>();
	};
	public Uporabnik(String username, String email, String geslo) {
		this();
		this.username = username;
		this.email = email;
		this.geslo = geslo;
		//this.ima_profil = new Profil(username, "");
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