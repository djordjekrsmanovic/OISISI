package model;

import java.util.HashSet;

public class Predmet {
	enum Semestar {
		LETNJI, ZIMSKI
	}

	String sifra;
	String naziv;
	Semestar semestar;
	Integer godinaStudija;
	Profesor profesor;
	Integer espb;
	HashSet<Student> polozili;
	HashSet<Student> nisuPolozili;

	public Predmet(String sifra, String naziv, Semestar semestar, Integer godinaStudija, Profesor profesor,
			Integer espb, HashSet<Student> polozili, HashSet<Student> nisuPolozili) {
		super();
		this.sifra = sifra;
		this.naziv = naziv;
		this.semestar = semestar;
		this.godinaStudija = godinaStudija;
		this.profesor = profesor;
		this.espb = espb;
		this.polozili = polozili;
		this.nisuPolozili = nisuPolozili;
	}

	public String getSifra() {
		return sifra;
	}

	public void setSifra(String sifra) {
		this.sifra = sifra;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public Semestar getSemestar() {
		return semestar;
	}

	public void setSemestar(Semestar semestar) {
		this.semestar = semestar;
	}

	public Integer getGodinaStudija() {
		return godinaStudija;
	}

	public void setGodinaStudija(Integer godinaStudija) {
		this.godinaStudija = godinaStudija;
	}

	public Profesor getProfesor() {
		return profesor;
	}

	public void setProfesor(Profesor profesor) {
		this.profesor = profesor;
	}

	public Integer getEspb() {
		return espb;
	}

	public void setEspb(Integer espb) {
		this.espb = espb;
	}

	public HashSet<Student> getPolozili() {
		return polozili;
	}

	public void setPolozili(HashSet<Student> polozili) {
		this.polozili = polozili;
	}

	public HashSet<Student> getNisuPolozili() {
		return nisuPolozili;
	}

	public void setNisuPolozili(HashSet<Student> nisuPolozili) {
		this.nisuPolozili = nisuPolozili;
	}

	

}
