package model;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import view.DodajPredmetProfesoruJTable;
import view.ProfessorJTable;

public class BazaProfesora implements Serializable {

	private static final long serialVersionUID = -6207105318745118741L;
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
		this.kolone = new ArrayList<String>();
		this.kolone.add("Ime");
		this.kolone.add("Prezime");
		this.kolone.add("Titula");
		this.kolone.add("Zvanje");
		profesori = new ArrayList<Profesor>();
		initProfesori();
	}

	private void initProfesori() {
		DateFormat datum = new SimpleDateFormat("dd.MM.yyyy");
		try {
			profesori.add(new Profesor("Bajagić", "Momčilo", datum.parse("09.02.1960."), "Vase Stajića 16", "555-333",
					"jesimozdazaspala1@bajaga.com", "Šekspirova 17", "00792434", Profesor.Titula.DR,
					Profesor.Zvanje.DOCENT));
			profesori.add(new Profesor("Torbica", "Momčilo", datum.parse("09.03.1960."), "Vase Stajića 16", "555-333",
					"jesimozdazaspala2@bajaga.com", "Šekspirova 17", "10792434", Profesor.Titula.DR,
					Profesor.Zvanje.EMERITUS));
			profesori.add(new Profesor("Bajagić", "Galeb", datum.parse("09.04.1960."), "Vase Stajića 16", "555-333",
					"jesimozdazaspala3@bajaga.com", "Šekspirova 17", "20792434", Profesor.Titula.DR,
					Profesor.Zvanje.PROFESOR));
			profesori.add(new Profesor("Torbica", "Galeb", datum.parse("09.05.1960."), "Vase Stajića 16", "555-333",
					"jesimozdazaspala4@bajaga.com", "Šekspirova 17", "30792434", Profesor.Titula.DR,
					Profesor.Zvanje.DOCENT));
			profesori.add(new Profesor("Basara", "Momčilo", datum.parse("09.06.1960."), "Vase Stajića 16", "555-333",
					"jesimozdazaspala5@bajaga.com", "Šekspirova 17", "40792434", Profesor.Titula.DR,
					Profesor.Zvanje.DOCENT));
			profesori.add(new Profesor("Bajagić", "Mia", datum.parse("09.07.1960."), "Vase Stajića 16", "555-333",
					"jesimozdazaspala6@bajaga.com", "Šekspirova 17", "50792434", Profesor.Titula.DR,
					Profesor.Zvanje.DOCENT));
			profesori.add(new Profesor("Basara", "Mia", datum.parse("09.08.1960."), "Vase Stajića 16", "555-333",
					"jesimozdazaspala7@bajaga.com", "Šekspirova 17", "60792434", Profesor.Titula.DR,
					Profesor.Zvanje.DOCENT));

		} catch (ParseException e) {
			e.printStackTrace();
		}

	}

	public void dodajProfesora(Profesor profesor) {
		profesori.add(profesor);
	}

	// Varijanta funkcije koja vraća sve predmete koje profesor ne predaje, koristi
	// se u slučaju kad jedan predmet može držati više profesora.
	/*
	 * public List<Predmet> getPredmetiKojeProfesorNePredaje() { int row =
	 * ProfessorJTable.getInstance().convertRowIndexToModel(ProfessorJTable.
	 * getInstance().getSelectedRow()); Profesor p =
	 * BazaProfesora.getInstance().findProfessorByRow(row); String brojLicneKarte =
	 * p.getBrojLicneKarte(); ArrayList<Predmet> ret = null; for (Profesor profesor
	 * : profesori) { if
	 * (profesor.getBrojLicneKarte().equalsIgnoreCase(brojLicneKarte)) { ret = new
	 * ArrayList<Predmet>(BazaPredmeta.getInstance().getPredmeti()); for (Predmet
	 * predmet : profesor.getPredajeNaPredmetima()) { if (ret.contains(predmet)) {
	 * ret.remove(predmet); } } return ret; } } return null; }
	 */

	// Varijanta funkcije koja vraća sve predmete koje niko ne predaje, koristi se u
	// slučaju kad jedan predmet drži isključivo jedan profesor.

	public List<Predmet> getPredmetiKojeProfesorNePredaje() {

		ArrayList<Predmet> ret = new ArrayList<Predmet>(BazaPredmeta.getInstance().getPredmeti());
		for (Profesor profesor : profesori) {
			for (Predmet predmet : profesor.getPredajeNaPredmetima()) {
				if (ret.contains(predmet)) {
					ret.remove(predmet);
				}
			}
		}
		return ret;
	}

	public void izbrisiProfesora() {
		String brojLicneKarte = profesori.get(ProfessorJTable.getInstance().getSelectedRow()).brojLicneKarte;
		int index = 1;
		for (Profesor profesor : profesori) {

			if (profesor.getBrojLicneKarte().equalsIgnoreCase(brojLicneKarte)) {
				profesori.remove(index - 1);
				for (Predmet p : profesor.getPredajeNaPredmetima()) {
					p.setProfesor(null);
				}
				break;
			}
			index++;
		}

		ProfessorJTable.getInstance().azuriraj();
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
			return profesor.getTitula().name();
		case 3:
			return profesor.getZvanje().name();
		default:
			return null;
		}
	}

	public List<Profesor> getProfesori() {
		return profesori;
	}

	public Profesor findProfessorByRow(int row) {
		return profesori.get(row);
	}

	public int getPredmetiNumberOfRows(String brojLicneKarte) {
		for (Profesor p : profesori) {
			if (p.getBrojLicneKarte().equals(brojLicneKarte)) {
				return p.getPredajeNaPredmetima().size();
			}
		}
		return 0;
	}

	public Profesor getProfesorByBrojLicneKarte(String brojLicneKarte) {
		for (Profesor p : profesori) {
			if (p.getBrojLicneKarte().equals(brojLicneKarte)) {
				return p;
			}
		}
		return null;
	}

	public void dodajPredmet() {
		int row = ProfessorJTable.getInstance().convertRowIndexToModel(ProfessorJTable.getInstance().getSelectedRow());
		Profesor p = BazaProfesora.getInstance().findProfessorByRow(row);
		String brojLicneKarte = p.getBrojLicneKarte();
		Predmet predmet = getPredmetiKojeProfesorNePredaje()
				.get(DodajPredmetProfesoruJTable.getInstance().getSelectedRow());
		for (Profesor profesor : profesori) {

			if (profesor.getBrojLicneKarte().equalsIgnoreCase(brojLicneKarte)) {
				profesor.getPredajeNaPredmetima().add(predmet);
				predmet.setProfesor(profesor);
				return;
			}
		}
	}

	public Profesor findProfesorByLicna(String brojLicne) {
		for (Profesor p : profesori) {
			if (p.getBrojLicneKarte().equalsIgnoreCase(brojLicne)) {
				return p;
			}
		}
		return null;
	}

}
