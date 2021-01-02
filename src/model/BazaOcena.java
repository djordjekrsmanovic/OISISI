package model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class BazaOcena {

	private static BazaOcena instance = null;
	private List<Ocena> ocjene;
	private List<String> kolone;

	public static BazaOcena getInstance() {
		if (instance == null) {
			instance = new BazaOcena();
		}
		return instance;
	}

	private BazaOcena() {

		ocjene = new ArrayList<Ocena>();
		kolone = new ArrayList<String>();
		kolone.add("Šifra predmeta");
		kolone.add("Naziv predmeta");
		kolone.add("ESPB");
		kolone.add("Ocena");
		kolone.add("Datum");

	}

	public void initOcjene() {
		Locale.setDefault(Locale.ENGLISH);
		DateFormat datum = new SimpleDateFormat("dd.MM.yyyy");
		Student s = BazaStudenata.getInstance().getStudenti().get(0);
		Predmet p = BazaPredmeta.getInstance().getPredmeti().get(3);

		try {
			// o1Date = datum.parse("10.1.2020.");
			Ocena o1 = new Ocena(s, p, 8, datum.parse("10.1.2020"));
			ocjene.add(o1);
			Predmet p2 = BazaPredmeta.getInstance().getPredmeti().get(4);
			Ocena o2 = new Ocena(s, p2, 10, datum.parse("3.3.2020"));
			ocjene.add(o2);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public int getNumberOfColumns() {
		return kolone.size();
	}

	public int getNumberOfRows() {
		return ocjene.size();
	}

	public String getColumnName(int indeks) {
		return kolone.get(indeks);
	}

	public Ocena getRow(int rowIndex) {
		return ocjene.get(rowIndex);
	}

	public String getValueAt(int row, int column, String brojIndeksa) {
		Ocena ocjena = BazaStudenata.getInstance().getStudentByBrojIndeksa(brojIndeksa).getPolozeniPredmeti().get(row);
		switch (column) {
		case 0:
			return ocjena.getP().getSifra();
		case 1:
			return ocjena.getP().getNaziv();
		case 2:
			return ocjena.getP().getEspb().toString();
		case 3:
			return Integer.toString(ocjena.getVrijednostOcjene());
		case 4:
			return ocjena.getDatumPolaganja().toString();
		default:
			return null;
		}
	}

	public List<Ocena> getOcjene() {
		return ocjene;
	}

	public void setOcjene(List<Ocena> ocjene) {
		this.ocjene = ocjene;
	}

}
