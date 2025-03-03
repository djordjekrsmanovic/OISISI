package controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

import model.BazaProfesora;
import model.Profesor;
import view.AddProfessorDialog;
import view.EditProfessorDialogInformacije;

public class ValidationProfessor {

	Boolean[] retVal = new Boolean[8];
	Boolean[] retValEdit = new Boolean[8];

	private static ValidationProfessor instance = null;

	public static ValidationProfessor getInstance() {
		if (instance == null) {
			instance = new ValidationProfessor();
		}
		return instance;
	}

	private ValidationProfessor() {
		reset();
	}

	public void reset() {
		Arrays.fill(retVal, Boolean.FALSE);
		Arrays.fill(retValEdit, Boolean.TRUE);
	}

	public boolean professorValidAdd() {

		for (Boolean v : retVal) {
			if (!v)
				return false;
		}

		return true;
	}

	public boolean professorValidEdit() {

		for (Boolean v : retValEdit) {
			if (!v)
				return false;
		}

		return true;
	}

	private void fieldValidationAdd(String input, int fieldNum) {
		switch (fieldNum) {
		case 0:
			retVal[fieldNum] = checkIme(input);
			break;
		case 1:
			retVal[fieldNum] = checkPrezime(input);
			break;
		case 2:
			retVal[fieldNum] = checkDate(input);
			break;
		case 3:
			retVal[fieldNum] = checkAdresa(input);
			break;
		case 4:
			retVal[fieldNum] = checkPhoneNumber(input);
			break;
		case 5:
			retVal[fieldNum] = checkMail(input);
			break;
		case 6:
			retVal[fieldNum] = checkAdresa(input);
			break;
		case 7:
			retVal[fieldNum] = checkLKNumber(input);
			break;
		}
	}

	private void fieldValidationEdit(String input, int fieldNum) {
		switch (fieldNum) {
		case 0:
			retValEdit[fieldNum] = checkIme(input);
			break;
		case 1:
			retValEdit[fieldNum] = checkPrezime(input);
			break;
		case 2:
			retValEdit[fieldNum] = checkDate(input);
			break;
		case 3:
			retValEdit[fieldNum] = checkAdresa(input);
			break;
		case 4:
			retValEdit[fieldNum] = checkPhoneNumber(input);
			break;
		case 5:
			retValEdit[fieldNum] = checkMail(input);
			break;
		case 6:
			retValEdit[fieldNum] = checkAdresa(input);
			break;
		case 7:
			retValEdit[fieldNum] = checkLKNumber(input);
			break;
		}
	}

	public boolean validateAdd(String input, int fieldNum) {
		fieldValidationAdd(input, fieldNum);

		if (professorValidAdd()) {
			AddProfessorDialog.getOk().setEnabled(true);
		} else {
			AddProfessorDialog.getOk().setEnabled(false);
		}

		return professorValidAdd();
	}

	public boolean validateEdit(String input, int fieldNum) {
		fieldValidationEdit(input, fieldNum);

		if (professorValidEdit()) {
			EditProfessorDialogInformacije.getOk().setEnabled(true);
		} else {
			EditProfessorDialogInformacije.getOk().setEnabled(false);
		}

		return professorValidEdit();
	}

	public boolean checkIme(String input) {
		boolean ret = true;
		if (input.contains(" ")) {
			String[] parts = input.split(" ");
			for (String p : parts) {
				if (p.isEmpty())
					continue;
				ret = Pattern.matches("\\p{L}+", p);
				if (ret == false && !input.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Format imena nije dobar");
					return ret;
				}
			}
		} else {
			ret = Pattern.matches("\\p{L}+", input);

		}
		if (ret == false && !input.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Format imena nije dobar");
		}
		return ret;

	}

	public boolean checkPrezime(String input) {
		boolean ret = true;
		if (input.contains("-")) {
			String[] parts = input.split("-");
			for (String p : parts) {
				p = p.trim();
				ret = Pattern.matches("\\p{L}+", p);
				if (ret == false && !input.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Format prezimena nije dobar");
					return ret;
				}
			}
		} else {
			ret = Pattern.matches("\\p{L}+", input);
		}
		if (ret == false && !input.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Format prezimena nije dobar");
		}

		return ret;
	}

	public boolean checkDate(String date) {
		String regex = "[0-9]{1,2}.[0-9]{1,2}.[0-9]{4}.";
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

	public boolean checkMail(String mail) {
		boolean ret = true;
		ret = Pattern.matches("^([\\w-\\.]+){1,64}@([\\w&&[^_]]+){2,255}.[a-z]{2,}.[a-z]{2,}$", mail); // https://stackoverflow.com/questions/8204680/java-regex-email
		if (ret == false && !mail.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Unijeli ste pogresnu e-mail adresu");
		}
		return ret;
	}

	public boolean checkPhoneNumber(String number) {
		boolean ret = true;
		String regex = "\\+?[0-9][0-9/-]+";
		ret = Pattern.matches(regex, number);
		if (ret == false && !number.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Unijeli ste pogresan broj telefona");
		}
		return ret;
	}

	public boolean checkLKNumber(String number) {
		for (Profesor p : BazaProfesora.getInstance().getProfesori()) {
				if (number.equals(p.getBrojLicneKarte())) {
					JOptionPane.showMessageDialog(null, "Unijeli ste postojeći broj lične karte");	
					return false;
				}
		}
		
		boolean ret = true;
		String regex = "^[0-9]*$";
		ret = Pattern.matches(regex, number);
		if (ret == false && !number.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Unijeli ste pogrešan broj lične karte");
		}
		return ret;
	}

	public boolean checkAdresa(String adresa) {
		boolean ret = true;
		String regex = "[\\p{L}0-9\\s]+";
		ret = Pattern.matches(regex, adresa);
		if (ret == false && !adresa.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Unijeli ste pogresnu adresu");
		}
		return ret;
	}


	public Date convertStringtoDate(String date) {
		DateFormat format = new SimpleDateFormat("dd.MM.yyyy");
		Date retDate = null;
		try {
			retDate = format.parse(date);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			retDate = null;
		}

		return retDate;
	}

}
