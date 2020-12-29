package controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

import model.BazaStudenata;
import model.Student;
import view.AddStudentDialog;

public class ValidationStudent {

	private Boolean[] ret = new Boolean[10];
	private static ValidationStudent instance = null;

	public static ValidationStudent getInstance() {
		if (instance == null) {
			instance = new ValidationStudent();
		}
		return instance;
	}

	private ValidationStudent() {
		Arrays.fill(ret, Boolean.FALSE);
	}

	public boolean studentValid() {
		boolean povratnaVrijednost = true;
		for (int i = 0; i < 8; i++) {
			povratnaVrijednost &= ret[i];
		}
		return povratnaVrijednost;
	}

	public boolean validate(String input, int redniBroj) {
		boolean povratnaVrijednost = true;
		switch (redniBroj) {
		case 0:
			ret[0] = checkIme(input);
			break;
		case 1:
			ret[1] = checkPrezime(input);
			break;
		case 2:
			ret[2] = checkDate(input);
			break;
		case 3:
			ret[3] = checkAdresa(input);
			break;
		case 4:
			ret[4] = checkPhoneNumber(input);
			break;
		case 5:
			ret[5] = checkMail(input);
			break;
		case 6:
			ret[6] = checkBrojIndeksa(input);
			break;
		case 7:
			ret[7] = checkGodinaUpisa(input);
			break;
		}
		for (int i = 0; i < 8; i++) {
			povratnaVrijednost &= ret[i];
		}
		if (povratnaVrijednost == true) {

			AddStudentDialog.getOK().setEnabled(true);

		} else {

			AddStudentDialog.getOK().setEnabled(false);
		}
		return povratnaVrijednost;
	}

	private boolean checkIme(String input) {
		// ime moze da sadrzi razmak
		boolean ret = true;
		if (input.contains(" ")) {
			String[] parts = input.split(" ");
			for (String p : parts) {
				if (p.isEmpty())
					continue;
				ret = Pattern.matches("\\p{L}+", p);
				if (ret == false && input.isEmpty() == false) {
					JOptionPane.showMessageDialog(null, "Pogrešan format imena.Ime može samo da sadrži slova.");
					return ret;
				}
			}
		} else {
			ret = Pattern.matches("\\p{L}+", input);

		}

		if (ret == false && input.isEmpty() == false) {
			JOptionPane.showMessageDialog(null, "Pogrešan format imea. Ime može samo da sadrži slova");
		}
		return ret;

	}

	private boolean checkPrezime(String input) {
		// prezime moze sadrzati '-'
		boolean ret = true;
		if (input.contains("-")) {
			String[] parts = input.split("-");
			for (String p : parts) {
				p = p.trim();
				ret = Pattern.matches("\\p{L}+", p);
				if (ret == false && input.isEmpty() == false) {
					JOptionPane.showMessageDialog(null,
							"Pogrešan format prezimena. Prezime može da sadrži slova i znak '-'");
					return ret;
				}
			}
		} else {
			ret = Pattern.matches("\\p{L}+", input);
		}
		if (ret == false && input.isEmpty() == false) {
			JOptionPane.showMessageDialog(null, "Pogrešan format prezimena. Prezime može da sadrži slova i znak '-'");
		}
		return ret;
	}

	private boolean checkMail(String mail) {
		boolean ret = true;
		ret = Pattern.matches("^([\\w-\\.]+){1,64}@([\\w&&[^_]]+){2,255}(.)+[a-z]{2,}$", mail); // https://stackoverflow.com/questions/8204680/java-regex-email
		if (ret == false && mail.isEmpty() == false) {
			JOptionPane.showMessageDialog(null, "Pogrešan format mail adrese");
		}
		return ret;
	}

	private boolean checkPhoneNumber(String number) {
		boolean ret = true;
		String regex = "\\+?[0-9][0-9/-]+";
		ret = Pattern.matches(regex, number);
		if (ret == false && number.isEmpty() == false) {
			JOptionPane.showMessageDialog(null,
					"Pogrešan format.Broj telefona smije da sadrži brojeve i znakove '/' i '-'");
		}
		return ret;
	}

	private boolean checkBrojIndeksa(String br) {
		boolean ret = true;
		String regex = "[a-zA-Z]{2,3}[\\-][0-9]{1,3}[\\-][0-9]{4}";

		ret = Pattern.matches(regex, br);
		if (ret == false && br.isEmpty() == false) {
			JOptionPane.showMessageDialog(null, "Pogrešan format indeksa.Format treba da bude smjer-broj-godina upisa");
			return ret;
		}

		List<Student> studenti = BazaStudenata.getInstance().getStudenti();

		for (Student s : studenti) {

			if (s.getBrojIndeksa().equalsIgnoreCase(AddStudentDialog.getFieldBrIndeks().getText().trim())) {
				JOptionPane.showMessageDialog(null, "Student sa unešenim brojem indeksa već postoji u bazi");
				return false;
			}
		}

		return ret;
	}

	private boolean checkAdresa(String adresa) {
		boolean ret = true;
		String regex = "[\\p{L}0-9\\s,]+";
		ret = Pattern.matches(regex, adresa);
		if (ret == false && adresa.isEmpty() == false) {
			JOptionPane.showMessageDialog(null,
					"Pogrešan format adrese. Adresa smije da sadrži slova brojeve i znak ','");
		}
		return ret;
	}

	private boolean checkGodinaUpisa(String godina) {
		boolean ret = true;
		String regex = "\\s*[1-9][0-9]{3}\\s*";
		ret = Pattern.matches(regex, godina);
		if (ret == false && godina.isEmpty() == false) {
			JOptionPane.showMessageDialog(null, "Unijeli ste pogrešnu godinu upisa.");
		}
		return ret;
	}

	private boolean checkDate(String date) {
		String regex = "[0-9]{1,2}\\.[0-9]{1,2}\\.[0-9]{4}\\.";
		boolean ret = Pattern.matches(regex, date);
		if (ret == false && date.isEmpty() == false) {
			JOptionPane.showMessageDialog(null,
					"Format datuma nije dobar.Datum mora biti u formatu dd.mm.yyyy. ili d.m.yyyy.");
			return false;
		}
		Date datumRod = convertStringtoDate(date);
		if (datumRod == null && date.isEmpty() == false) {
			JOptionPane.showMessageDialog(null,
					"Format datuma nije dobar.Datum mora biti u formatu dd.mm.yyyy. ili d.m.yyyy.");
			return false;
		}
		return true;
	}

	private Date convertStringtoDate(String date) {
		DateFormat format = new SimpleDateFormat("dd.MM.yyyy");
		Date retDate = null;
		try {
			retDate = format.parse(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			retDate = null;
		}

		return retDate;
	}

	public void setLogickeVirjednost() {
		Arrays.fill(ret, Boolean.FALSE); // posto koristimo signleton onda nakon sto se zatvori dijalog
											// postavljamo ove vrijednosti na false
	}
}
