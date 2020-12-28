package model;

import java.util.Date;
import java.util.HashSet;

public class Profesor {
	String prezime;
	String ime;
	Date datumRodjenja;
	String adresaStanovanja;
	String telefon;
	String email;
	String adresaKancelarije;
	String brojLicneKarte;
	String titula;
	String zvanje;
	HashSet<Predmet> predajeNaPredmetima;
	
	public Profesor(String prezime, String ime, Date datumRodjenja, String adresaStanovanja, String telefon,
			String email, String adresaKancelarije, String brojLicneKarte, String titula, String zvanje) {
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
		this.predajeNaPredmetima = (HashSet<Predmet>)p.predajeNaPredmetima.clone();
	}



	@Override
	public String toString() {
		return "Profesor [prezime=" + prezime + ", ime=" + ime + ", datumRodjenja=" + datumRodjenja
				+ ", adresaStanovanja=" + adresaStanovanja + ", telefon=" + telefon + ", email=" + email
				+ ", adresaKancelarije=" + adresaKancelarije + ", brojLicneKarte=" + brojLicneKarte + ", titula="
				+ titula + ", zvanje=" + zvanje + ", predajeNaPredmetima=" + predajeNaPredmetima + "]";
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

	public String getTitula() {
		return titula;
	}

	public void setTitula(String titula) {
		this.titula = titula;
	}

	public String getZvanje() {
		return zvanje;
	}

	public void setZvanje(String zvanje) {
		this.zvanje = zvanje;
	}

	public HashSet<Predmet> getPredajeNaPredmetima() {
		return predajeNaPredmetima;
	}

	public void setPredajeNaPredmetima(HashSet<Predmet> predajeNaPredmetima) {
		this.predajeNaPredmetima = predajeNaPredmetima;
	}

}
