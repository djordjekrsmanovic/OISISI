package model;

import java.io.Serializable;
import java.util.ArrayList;

public class Predmet implements Serializable {
	
	private static final long serialVersionUID = -3888488376100247644L;

	public enum Semestar {
		LETNJI, ZIMSKI
	}

	String sifra;
	String naziv;
	Semestar semestar;
	Integer godinaStudija;
	Profesor profesor;
	Integer espb;
	ArrayList<Student> polozili;
	ArrayList<Student> nisuPolozili;

	public Predmet(String sifra, String naziv, Semestar semestar, Integer godinaStudija, Profesor profesor,
			Integer espb, ArrayList<Student> polozili, ArrayList<Student> nisuPolozili) {
		super();
		this.sifra = sifra;
		this.naziv = naziv;
		this.semestar = semestar;
		this.godinaStudija = godinaStudija;
		this.profesor = profesor;
		this.espb = espb;
		this.polozili = polozili;
		this.nisuPolozili = nisuPolozili;
		polozili = new ArrayList<Student>();
		nisuPolozili = new ArrayList<Student>();
	}

	public Predmet() {
		polozili = new ArrayList<Student>();
		nisuPolozili = new ArrayList<Student>();
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

	public ArrayList<Student> getPolozili() {
		return polozili;
	}

	public void setPolozili(ArrayList<Student> polozili) {
		this.polozili = polozili;
	}

	public ArrayList<Student> getNisuPolozili() {
		return nisuPolozili;
	}

	public void setNisuPolozili(ArrayList<Student> nisuPolozili) {
		this.nisuPolozili = nisuPolozili;
	}

}
