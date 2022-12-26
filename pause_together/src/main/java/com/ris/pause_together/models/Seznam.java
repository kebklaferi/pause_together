package com.ris.pause_together.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonView;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "Seznami")
public class Seznam {

	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private Long id;
	@Column(name = "naziv")
	private String naziv;

	//mappedBy mora bit enak temu
	@ManyToOne
	@JoinColumn(name = "uporabnik_id")
	@JsonIgnore
	private Uporabnik uporabnik;


	@Column(name = "vsebine")
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "seznam_id")
	private List<Vsebina> vsebine;



	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}
	public Seznam(){

	};
	public Seznam(String naz){
		this.naziv = naz;
	}

	public Uporabnik getUporabnik() {
		return uporabnik;
	}

	public void setUporabnik(Uporabnik uporabnik) {
		this.uporabnik = uporabnik;
	}

	public List<Vsebina> getVsebine() {
		return vsebine;
	}

	public void setVsebine(ArrayList<Vsebina> vsebine) {
		this.vsebine = vsebine;
	}

	//-------------------------------
	/*
	public Seznam() {

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
	*/
}