package controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import model.BazaOcena;
import model.Ocena;
import model.Predmet;
import model.Student;
import view.UpisOceneDialog;

public class OcenaController {
	private static OcenaController instance = null;

	public static OcenaController getInstance() {
		if (instance == null) {
			instance = new OcenaController();
		}
		return instance;
	}

	public Ocena addOcena(Student student, Predmet predmet) {
		Ocena ocena = new Ocena(student, predmet, (int)UpisOceneDialog.getComboOcena().getSelectedItem(), convertStringtoDate(UpisOceneDialog.getFieldDatum().getText()));
		BazaOcena.getInstance().getOcjene().add(ocena);
		return ocena;
	}
	
	private Date convertStringtoDate(String date) {
		DateFormat format = new SimpleDateFormat("dd.MM.yyyy");
		Date retDate = null;
		try {
			retDate = format.parse(date);
		} catch (Exception e) {
			retDate = null;
		}

		return retDate;
	}

	public void removeOcjena(Student student, Predmet p) {
		int index=0;
		for (Ocena o:BazaOcena.getInstance().getOcjene()) {
			if (o.getP().getSifra().equalsIgnoreCase(p.getSifra()) && o.getS().getBrojIndeksa().equalsIgnoreCase(student.getBrojIndeksa())) {
				BazaOcena.getInstance().getOcjene().remove(index);
				break;
			}
			index++;
		}
		
	}
}
