package model;

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
//	HashSet<Student> polozili;
//	HashSet<Student> nisuPolozili;
}
