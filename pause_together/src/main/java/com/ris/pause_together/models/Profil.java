package com.ris.pause_together.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

@Entity
@Table(name = "Profili")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Profil {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;
	@Column
	private String ime;
	@Column
	private String priimek;
	@Column
	private int starost;
	@Column
	private String slika;

	public void spremeniSliko() {

	}

	public void spremeniPodatke() {

	}

	public Profil(String im, String pr) {
		this.ime = im;
		this.priimek = pr;
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