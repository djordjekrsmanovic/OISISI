package model;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class BazaProfesora {
	private static BazaProfesora instance = null;
	private List<Profesor> profesori;
	private List<String> kolone;

	public static BazaProfesora getInstance() {
		if (instance == null) {
			instance = new BazaProfesora();

		}
		return instance;
	}

	private BazaProfesora() {
		initProfesori();
		this.kolone = new ArrayList<String>();
		this.kolone.add("Ime");
		this.kolone.add("Prezime");
		this.kolone.add("Titula");
		this.kolone.add("Zvanje");
	}

	private void initProfesori() {
		DateFormat datum = new SimpleDateFormat("dd.MM.yyyy");
		profesori = new ArrayList<Profesor>();
		try {
			profesori.add(new Profesor("Bajagić", "Momčilo", datum.parse("09.02.1960."), "Vase Stajića 16", "555-333",
					"jesimozdazaspala1@bajaga.com", "Šekspirova 17", "00792434", "Doktor", "Redovan profesor"));
			profesori.add(new Profesor("Torbica", "Momčilo", datum.parse("09.03.1960."), "Vase Stajića 16", "555-333",
					"jesimozdazaspala2@bajaga.com", "Šekspirova 17", "10792434", "Doktor", "Redovan profesor"));
			profesori.add(new Profesor("Bajagić", "Galeb", datum.parse("09.04.1960."), "Vase Stajića 16", "555-333",
					"jesimozdazaspala3@bajaga.com", "Šekspirova 17", "20792434", "Doktor", "Redovan profesor"));
			profesori.add(new Profesor("Torbica", "Galeb", datum.parse("09.05.1960."), "Vase Stajića 16", "555-333",
					"jesimozdazaspala4@bajaga.com", "Šekspirova 17", "30792434", "Doktor", "Redovan profesor"));
			profesori.add(new Profesor("Basara", "Momčilo", datum.parse("09.06.1960."), "Vase Stajića 16", "555-333",
					"jesimozdazaspala5@bajaga.com", "Šekspirova 17", "40792434", "Doktor", "Redovan profesor"));
			profesori.add(new Profesor("Bajagić", "Mia", datum.parse("09.07.1960."), "Vase Stajića 16", "555-333",
					"jesimozdazaspala6@bajaga.com", "Šekspirova 17", "50792434", "Doktor", "Redovan profesor"));
			profesori.add(new Profesor("Basara", "Mia", datum.parse("09.08.1960."), "Vase Stajića 16", "555-333",
					"jesimozdazaspala7@bajaga.com", "Šekspirova 17", "60792434", "Doktor", "Redovan profesor"));

		} catch (ParseException e) {
			e.printStackTrace();
		}

	}

	public void dodajProfesora(Profesor profesor) {
		profesori.add(profesor);
	}

	public int getNumberOfColumns() {
		return kolone.size();
	}

	public int getNumberOfRows() {
		return profesori.size();
	}

	public String getColumnName(int indeks) {
		return kolone.get(indeks);
	}

	public Profesor getRow(int rowIndex) {
		return profesori.get(rowIndex);
	}

	public String getValueAt(int row, int column) {
		Profesor profesor = profesori.get(row);
		switch (column) {
		case 0:
			return profesor.getIme();
		case 1:
			return profesor.getPrezime();
		case 2:
			return profesor.getTitula();
		case 3:
			return profesor.getZvanje();
		default:
			return null;
		}
	}

}
