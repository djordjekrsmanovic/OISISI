package model;

import java.util.ArrayList;
import java.util.List;

import view.DodajPredmetProfesoruJTable;
import view.ProfessorJTable;

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
		this.kolone = new ArrayList<String>();
		this.kolone.add("Ime");
		this.kolone.add("Prezime");
		this.kolone.add("Titula");
		this.kolone.add("Zvanje");
		profesori = new ArrayList<Profesor>();
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

	

	public void setProfesori(List<Profesor> profesori) {
		this.profesori = profesori;
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
				if (!profesor.getPredajeNaPredmetima().contains(predmet)) {
					profesor.getPredajeNaPredmetima().add(predmet);
				}
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
