package model;

import java.util.ArrayList;
import java.util.List;

import persistence.Deserijalizacija;
import view.PredmetJTable;
import view.ProfessorJTable;

public class BazaPredmeta {

	private static BazaPredmeta instance = null;
	private List<Predmet> predmeti;
	private List<String> kolone;

	public static BazaPredmeta getInstance() {
		if (instance == null) {
			instance = new BazaPredmeta();

		}
		return instance;
	}

	private BazaPredmeta() {
		this.kolone = new ArrayList<String>();
		this.kolone.add("Šifra");
		this.kolone.add("Naziv");
		this.kolone.add("ESPB");
		this.kolone.add("Godina");
		this.kolone.add("Semestar");
		predmeti = new ArrayList<Predmet>();
		initPredmeti();
	}

	private void initPredmeti() {
		/*
		predmeti.add(new Predmet("E221", "Helenska filozofija", Predmet.Semestar.LETNJI, 1, null, 12, null, null));
		predmeti.add(new Predmet("E222", "Estetika", Predmet.Semestar.LETNJI, 2, null, 16, null, null));
		predmeti.add(new Predmet("E223", "Odbojka", Predmet.Semestar.ZIMSKI, 1, null, 6, null, null));
		predmeti.add(new Predmet("E224", "Teorija nepokretne tačke", Predmet.Semestar.LETNJI, 1, null, 12, null, null));
		predmeti.add(new Predmet("E225", "Topologija 4", Predmet.Semestar.ZIMSKI, 4, null, 13, null, null));
		*/
		try {
			predmeti = Deserijalizacija.getInstance().deserijalizacijaPredmeta();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	

	public void dodajPredmet(Predmet predmet) {
		predmeti.add(predmet);
	}
	

	public int getNumberOfColumns() {
		return kolone.size();
	}

	public int getNumberOfRows() {
		return predmeti.size();
	}

	public String getColumnName(int indeks) {
		return kolone.get(indeks);
	}

	public Predmet getRow(int rowIndex) {
		return predmeti.get(rowIndex);
	}

	public String getValueAt(int row, int column) {
		Predmet predmet = predmeti.get(row);
		switch (column) {
		case 0:
			return predmet.getSifra();
		case 1:
			return predmet.getNaziv();
		case 2:
			return predmet.getEspb().toString();
		case 3:
			return predmet.getGodinaStudija().toString();
		case 4:
			return predmet.getSemestar().name();
		default:
			return null;
		}
	}

	public List<Predmet> getPredmeti() {
		return predmeti;
	}

	public void setPredmeti(List<Predmet> predmeti) {
		this.predmeti = predmeti;
	}

	public int getNepolozeniNumberOfRows(String brojIndeksa) {
		return BazaStudenata.getInstance().getStudentByBrojIndeksa(brojIndeksa).getNepolozeniIspiti().size();
	}

	public Object getNepolozeniValueAt(int rowIndex, int columnIndex, String brojIndeksa) {
		Predmet predmet = BazaStudenata.getInstance().getStudentByBrojIndeksa(brojIndeksa).getNepolozeniIspiti()
				.get(rowIndex);
		switch (columnIndex) {
		case 0:
			return predmet.getSifra();
		case 1:
			return predmet.getNaziv();
		case 2:
			return predmet.getEspb().toString();
		case 3:
			return predmet.getGodinaStudija().toString();
		case 4:
			return predmet.getSemestar().name();
		default:
			return null;
		}
	}

	public Object getProfessorValueAt(int rowIndex, int columnIndex, String brojLicneKarte) {
		Predmet predmet = BazaProfesora.getInstance().getProfesorByBrojLicneKarte(brojLicneKarte)
				.getPredajeNaPredmetima().get(rowIndex);
		switch (columnIndex) {
		case 0:
			return predmet.getSifra();
		case 1:
			return predmet.getNaziv();
		case 2:
			return predmet.getGodinaStudija().toString();
		case 3:
			return predmet.getSemestar().name();
		default:
			return null;
		}
	}

}
