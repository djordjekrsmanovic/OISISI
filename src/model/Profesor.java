package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class Profesor implements Serializable {
	
	private static final long serialVersionUID = 7006222375457275897L;

	public enum Titula {
		BSC, MSC, MR, DR, PROF
	}

	public enum Zvanje {
		ASISTENT, DOCENT, PROFESOR, EMERITUS
	}

	String prezime;
	String ime;
	Date datumRodjenja;
	String adresaStanovanja;
	String telefon;
	String email;
	String adresaKancelarije;
	String brojLicneKarte;
	Titula titula;
	Zvanje zvanje;
	ArrayList<Predmet> predajeNaPredmetima;

	public Profesor(String prezime, String ime, Date datumRodjenja, String adresaStanovanja, String telefon,
			String email, String adresaKancelarije, String brojLicneKarte, Titula titula, Zvanje zvanje) {
		super();
		this.prezime = prezime;
		this.ime = ime;
		this.datumRodjenja = datumRodjenja;
		this.adresaStanovanja = adresaStanovanja;
		this.telefon = telefon;
		this.email = email;
		this.adresaKancelarije = adresaKancelarije;
		this.brojLicneKarte = brojLicneKarte;
		this.titula = titula;
		this.zvanje = zvanje;
		predajeNaPredmetima = new ArrayList<>();
	}

	@SuppressWarnings("unchecked")
	public Profesor(Profesor p) {
		this.prezime = p.prezime;
		this.ime = p.ime;
		this.datumRodjenja = p.datumRodjenja;
		this.adresaStanovanja = p.adresaStanovanja;
		this.telefon = p.telefon;
		this.email = p.email;
		this.adresaKancelarije = p.adresaKancelarije;
		this.brojLicneKarte = p.brojLicneKarte;
		this.titula = p.titula;
		this.zvanje = p.zvanje;
		this.predajeNaPredmetima = (ArrayList<Predmet>) p.predajeNaPredmetima.clone();
	}

	@Override
	public String toString() {
		return "Profesor [prezime=" + prezime + ", ime=" + ime + ", datumRodjenja=" + datumRodjenja
				+ ", adresaStanovanja=" + adresaStanovanja + ", telefon=" + telefon + ", email=" + email
				+ ", adresaKancelarije=" + adresaKancelarije + ", brojLicneKarte=" + brojLicneKarte + ", titula="
				+ titula.name() + ", zvanje=" + zvanje.name() + ", predajeNaPredmetima=" + predajeNaPredmetima + "]";
	}

	public String getPrezime() {
		return prezime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public Date getDatumRodjenja() {
		return datumRodjenja;
	}

	public void setDatumRodjenja(Date datumRodjenja) {
		this.datumRodjenja = datumRodjenja;
	}

	public String getAdresaStanovanja() {
		return adresaStanovanja;
	}

	public void setAdresaStanovanja(String adresaStanovanja) {
		this.adresaStanovanja = adresaStanovanja;
	}

	public String getTelefon() {
		return telefon;
	}

	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAdresaKancelarije() {
		return adresaKancelarije;
	}

	public void setAdresaKancelarije(String adresaKancelarije) {
		this.adresaKancelarije = adresaKancelarije;
	}

	public String getBrojLicneKarte() {
		return brojLicneKarte;
	}

	public void setBrojLicneKarte(String brojLicneKarte) {
		this.brojLicneKarte = brojLicneKarte;
	}

	public Titula getTitula() {
		return titula;
	}

	public void setTitula(Titula titula) {
		this.titula = titula;
	}

	public Zvanje getZvanje() {
		return zvanje;
	}

	public void setZvanje(Zvanje zvanje) {
		this.zvanje = zvanje;
	}

	public ArrayList<Predmet> getPredajeNaPredmetima() {
		return predajeNaPredmetima;
	}

	public void setPredajeNaPredmetima(ArrayList<Predmet> predajeNaPredmetima) {
		this.predajeNaPredmetima = predajeNaPredmetima;
	}

}
