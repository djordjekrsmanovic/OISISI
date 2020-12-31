package model;

import java.util.ArrayList;
import java.util.Date;

public class Student {
	public enum Status{B,S};
	private String ime;
	private String prezime;
	private Date datumRodjenja;
	private String adresaStanovanja;
	private String telefon;
	private String mail;
	private String brojIndeksa;
	private int godinaUpisa;
	private int trenutnaGodinaStudija;
	private Status status;
	private double prosjecnaOcjena;
	private ArrayList<Ocena> polozeniPredmeti;
	private ArrayList<Predmet> nepolozeniIspiti;
	public Student(String ime,String prezime, Date datumRodjenja, String adresaStanovanja, String telefon, String mail,
			String brojIndeksa, int godinaUpisa, int trenutnaGodinaStudija, Status status, double prosjecnaOcjena) {
		super();
		this.ime = ime;
		this.prezime = prezime;
		this.datumRodjenja = datumRodjenja;
		this.adresaStanovanja = adresaStanovanja;
		this.telefon = telefon;
		this.mail = mail;
		this.brojIndeksa = brojIndeksa;
		this.godinaUpisa = godinaUpisa;
		this.trenutnaGodinaStudija = trenutnaGodinaStudija;
		this.status = status;
		this.prosjecnaOcjena = prosjecnaOcjena;
		this.polozeniPredmeti=new ArrayList<Ocena>();
		this.nepolozeniIspiti=new ArrayList<Predmet>();
		polozeniPredmeti=new ArrayList<Ocena>();
		nepolozeniIspiti=new ArrayList<Predmet>();
	}
	public Student() {
		// TODO Auto-generated c
		polozeniPredmeti=new ArrayList<Ocena>();
		nepolozeniIspiti=new ArrayList<Predmet>();
	}
	public Student(Student s) {
		this.ime = s.ime;
		this.prezime = s.prezime;
		this.datumRodjenja = s.datumRodjenja;
		this.adresaStanovanja = s.adresaStanovanja;
		this.telefon = s.telefon;
		this.mail = s.mail;
		this.brojIndeksa = s.brojIndeksa;
		this.godinaUpisa = s.godinaUpisa;
		this.trenutnaGodinaStudija = s.trenutnaGodinaStudija;
		this.status = s.status;
		this.prosjecnaOcjena = s.prosjecnaOcjena;
		this.nepolozeniIspiti=s.nepolozeniIspiti;
		this.polozeniPredmeti=s.polozeniPredmeti;
		
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
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getBrojIndeksa() {
		return brojIndeksa;
	}
	public void setBrojIndeksa(String brojIndeksa) {
		this.brojIndeksa = brojIndeksa;
	}
	public int getGodinaUpisa() {
		return godinaUpisa;
	}
	public void setGodinaUpisa(int godinaUpisa) {
		this.godinaUpisa = godinaUpisa;
	}
	public int getTrenutnaGodinaStudija() {
		return trenutnaGodinaStudija;
	}
	public void setTrenutnaGodinaStudija(int trenutnaGodinaStudija) {
		this.trenutnaGodinaStudija = trenutnaGodinaStudija;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public double getProsjecnaOcjena() {
		return prosjecnaOcjena;
	}
	public void setProsjecnaOcjena(double prosjecnaOcjena) {
		this.prosjecnaOcjena = prosjecnaOcjena;
	}
	@Override
	public String toString() {
		return "Student [prezime=" + prezime + ", ime=" + ime + ", datumRodjenja=" + datumRodjenja
				+ ", adresaStanovanja=" + adresaStanovanja + ", telefon=" + telefon + ", mail=" + mail
				+ ", brojIndeksa=" + brojIndeksa + ", godinaUpisa=" + godinaUpisa + ", trenutnaGodinaStudija="
				+ trenutnaGodinaStudija + ", prosjecnaOcjena=" + prosjecnaOcjena + "]";
	}
	public ArrayList<Ocena> getPolozeniPredmeti() {
		return polozeniPredmeti;
	}
	public void setPolozeniPredmeti(ArrayList<Ocena> polozeniPredmeti) {
		this.polozeniPredmeti = polozeniPredmeti;
	}
	public ArrayList<Predmet> getNepolozeniIspiti() {
		return nepolozeniIspiti;
	}
	public void setNepolozeniIspiti(ArrayList<Predmet> nepolozeniIspiti) {
		this.nepolozeniIspiti = nepolozeniIspiti;
	}
	
	
	
}
