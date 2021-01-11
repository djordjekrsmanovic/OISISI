package model;

import java.util.ArrayList;
import java.util.List;

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
