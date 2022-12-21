package com.ris.pause_together.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Uporabniki")
public class Uporabnik {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;

	@Column(name = "username")
	private String username;

	@Column
	private String geslo;
	@Column
	private String email;

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "uporabnik_id")
	private List<Seznam> seznami;

	@OneToOne(cascade = CascadeType.ALL)
	private Profil profil;


	public Uporabnik (){
		this.seznami = new ArrayList<Seznam>();
	}
	public Uporabnik(String geslo, String email, String username, List<Seznam> polje) {
		this.seznami = polje;
		this.geslo = geslo;
		this.email = email;
		this.username = username;
	}

	//private ArrayList<Skupina> skupine;

	/* private ArrayList<Prosnja> poslane_prosnje;
	private ArrayList<Pogovor> sodeluje;
	private ArrayList<Forum> ustvarjeni;
	private ArrayList<Prosnja> prejete_prosnje; */

	//---------------------------------------


	/*
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
		this.mail = email;
		this.password = geslo;
		//this.ima_profil = new Profil(username, "");
	}

	 */

	public List<Seznam> getSeznami() {
		return seznami;
	}

	public void setSeznami(List<Seznam> seznami) {
		this.seznami = seznami;
	}

	public Profil getProfil() {
		return profil;
	}

	public void setProfil(Profil profil) {
		this.profil = profil;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getGeslo() {
		return geslo;
	}

	public void setGeslo(String geslo) {
		this.geslo = geslo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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