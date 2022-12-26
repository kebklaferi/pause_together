package com.ris.pause_together.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "vsebine")
public class Vsebina {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String naslov;
	private String avtor;
	private int leto_izdaje;
	private int ocena;

	@ManyToOne
	@JoinColumn(name = "seznam_id")
	@JsonIgnore
	private Seznam seznam;

	public Seznam getSeznam() {
		return seznam;
	}

	public void setSeznam(Seznam seznam) {
		this.seznam = seznam;
	}

	public Vsebina(){};
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