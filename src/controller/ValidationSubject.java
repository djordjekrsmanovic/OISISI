package controller;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

import model.BazaPredmeta;
import model.Predmet;
import view.AddSubjectDialog;
import view.EditSubjectDialog;

public class ValidationSubject {
	private Boolean[] ret = new Boolean[5];
	private static ValidationSubject instance = null;
	private static Boolean[] retEdit=new Boolean[5];

	public static ValidationSubject getInstance() {
		if (instance == null) {
			instance = new ValidationSubject();
		}
		return instance;
	}

	private ValidationSubject() {
		Arrays.fill(ret, Boolean.FALSE);
		Arrays.fill(retEdit, Boolean.TRUE);
	}

	public boolean subjectValid() {
		boolean povratnaVrijednost = true;
		for (int i = 0; i < 3; i++) {
			povratnaVrijednost &= ret[i];
		}
		return povratnaVrijednost;
	}
	
	public boolean editSubjectValid() {
		boolean povratnaVrijednost = true;
		for (int i = 0; i < 3; i++) {
			povratnaVrijednost &= retEdit[i];
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
	
	public boolean validateEdit(String input, int redniBroj) {
		boolean povratnaVrijednost = true;
		switch (redniBroj) {
		case 0:
			retEdit[0] = checkSifraEdit(input);
			break;
		case 1:
			retEdit[1] = checkNazivPredmeta(input);
			break;
		case 2:
			retEdit[2] = checkESPB(input);
			break;
		}
		for (int i = 0; i < 3; i++) {
			povratnaVrijednost &= retEdit[i];
		}
		if (povratnaVrijednost == true) {

			EditSubjectDialog.getOk().setEnabled(true);

		} else {

			EditSubjectDialog.getOk().setEnabled(false);
		}
		return povratnaVrijednost;

	}

	private Boolean checkSifraEdit(String sifra) {
		// TODO Auto-generated method stub
		String regex = "[a-zA-z0-9]+";
		boolean ret = Pattern.matches(regex, sifra);
		if (ret == false && sifra.isEmpty() == false) {
			JOptionPane.showMessageDialog(null, "Pogrešan fromat . Šifra može samo da sadrži slova i brojeve.");
		}
		if (provjeriJednoznacnostSifreEdit()==false) {
			return false;
		}
		return true;
	}
	
	private boolean provjeriJednoznacnostSifreEdit() {
		List<Predmet> predmeti = BazaPredmeta.getInstance().getPredmeti();

		for (Predmet p : predmeti) {

			if (p.getSifra().equalsIgnoreCase(EditSubjectDialog.getFieldSifra().getText().trim())) {
				if (p.getSifra() == EditSubjectDialog.getPredmet().getSifra()) {
					continue;
				} else {
					JOptionPane.showMessageDialog(null, "Predmet sa unešenom šifrom već postoji u bazi");
					return false;
				}
			}

		}
		return true;
	}

	private boolean checkSifra(String sifra) {
		String regex = "[a-zA-z0-9]+";
		boolean ret = Pattern.matches(regex, sifra);
		if (ret == false && sifra.isEmpty() == false) {
			JOptionPane.showMessageDialog(null, "Pogrešan fromat . Šifra može samo da sadrži slova i brojeve.");
		}
		// TODO uraditi provjeru da li predmet sa unesenom sifrom vec postoji u bazi
		List<Predmet> predmeti = BazaPredmeta.getInstance().getPredmeti();
		for (Predmet p:predmeti) {
			if (p.getSifra().equalsIgnoreCase(AddSubjectDialog.getFieldSifra().getText().trim())) {
				JOptionPane.showMessageDialog(null, "Predmet sa unešenom šifrom  već postoji u bazi");
				return false;
			}
		}

	
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
		
		return ret;
	}

	public void setLogickeVirjednost() {
		Arrays.fill(ret, Boolean.FALSE); // posto koristimo signleton onda nakon sto se zatvori dijalog
											// postavljamo ove vrijednosti na false
	}
	public void setLogickeVrijednostEdit() {
		Arrays.fill(ret, Boolean.TRUE);
	}

}
