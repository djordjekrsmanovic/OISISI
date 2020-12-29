package controller;

import java.util.Arrays;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

import view.AddSubjectDialog;

public class ValidationSubject {
	private Boolean[] ret = new Boolean[5];
	private static ValidationSubject instance = null;

	public static ValidationSubject getInstance() {
		if (instance == null) {
			instance = new ValidationSubject();
		}
		return instance;
	}

	private ValidationSubject() {
		Arrays.fill(ret, Boolean.FALSE);
	}

	public boolean subjectValid() {
		boolean povratnaVrijednost = true;
		for (int i = 0; i < 3; i++) {
			povratnaVrijednost &= ret[i];
		}
		return povratnaVrijednost;
	}

	public boolean validate(String input, int redniBroj) {
		boolean povratnaVrijednost = true;
		switch (redniBroj) {
		case 0:
			ret[0] = checkSifra(input);
			break;
		case 1:
			ret[1] = checkNazivPredmeta(input);
			break;
		case 2:
			ret[2] = checkESPB(input);
			break;
		}
		for (int i = 0; i < 3; i++) {
			povratnaVrijednost &= ret[i];
		}
		if (povratnaVrijednost == true) {

			AddSubjectDialog.getOk().setEnabled(true);

		} else {

			AddSubjectDialog.getOk().setEnabled(false);
		}
		return povratnaVrijednost;

	}

	private boolean checkSifra(String sifra) {
		String regex = "[a-zA-z0-9]+";
		boolean ret = Pattern.matches(regex, sifra);
		if (ret == false && sifra.isEmpty() == false) {
			JOptionPane.showMessageDialog(null, "Pogrešan fromat . Šifra može samo da sadrži slova i brojeve.");
		}
		// TODO uraditi provjeru da li predmet sa unesenom sifrom vec postoji u bazi
		return ret;
	}

	private boolean checkNazivPredmeta(String naziv) {
		String regex = "[\\p{L}0-9\\s]+";
		boolean ret = Pattern.matches(regex, naziv);
		if (ret == false && naziv.isEmpty() == false) {
			JOptionPane.showMessageDialog(null, "Pogrešan fromat. Naziv može da sadrži slova i brojeve");
		}
		return ret;
	}

	private boolean checkESPB(String bodovi) {
		String regex = "[0-9]+";
		boolean ret = Pattern.matches(regex, bodovi);
		if (ret == false && bodovi.isEmpty() == false) {
			JOptionPane.showMessageDialog(null, "Pogrešan format.Unos može da sadrži samo brojeve");
			return false;
		}
		if (Integer.parseInt(bodovi) > 15) {
			JOptionPane.showMessageDialog(null, "Predmet ne može da ima više od 15 ESPB bodova");
			ret = false;
		}
		return ret;
	}

	public void setLogickeVirjednost() {
		Arrays.fill(ret, Boolean.FALSE); // posto koristimo signleton onda nakon sto se zatvori dijalog
											// postavljamo ove vrijednosti na false
	}

}
