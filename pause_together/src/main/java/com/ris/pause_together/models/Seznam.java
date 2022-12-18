package com.ris.pause_together.models;

import com.fasterxml.jackson.annotation.JsonView;
import jakarta.persistence.*;

import java.util.ArrayList;


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
	@JoinColumn(name = "uporabnik_id", insertable = false, updatable = false)
	private Uporabnik uporabnik;

	/*
	@Column(name = "vsebine")
	private ArrayList<Vsebina> vsebine;

	 */

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