package controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import model.BazaProfesora;
import model.Profesor;
import view.AddProfessorDialog;
import view.EditProfessorDialogInformacije;
import view.ProfessorJTable;

public class ProfessorController {

	private static ProfessorController instance = null;

	public static ProfessorController getInstance() {
		if (instance == null) {
			instance = new ProfessorController();
		}
		return instance;
	}

	public void addProfessor() {

		String prezime = AddProfessorDialog.getFieldPrezime().getText().trim();
		String ime = AddProfessorDialog.getFieldIme().getText().trim();
		Date datumRodjenja = convertStringtoDate(AddProfessorDialog.getFieldDatum().getText().trim());
		String adresaStanovanja = AddProfessorDialog.getFieldAdresa().getText().trim();
		String telefon = AddProfessorDialog.getFieldBrTel().getText().trim();
		String email = AddProfessorDialog.getFieldMail().getText().trim();
		String adresaKancelarije = AddProfessorDialog.getFieldAdrKanc().getText().trim();
		String brojLicneKarte = AddProfessorDialog.getFieldBrLK().getText().trim();
		String titula = AddProfessorDialog.getFieldTitula().getText().trim();
		String zvanje = AddProfessorDialog.getFieldZvanje().getText().trim();

		Profesor profesor = new Profesor(prezime, ime, datumRodjenja, adresaStanovanja, telefon, email,
				adresaKancelarije, brojLicneKarte, titula, zvanje);

		BazaProfesora bazaProfesora = BazaProfesora.getInstance();
		bazaProfesora.dodajProfesora(profesor);
		ProfessorJTable.getInstance().azuriraj();
	}

	public void editProfessor() {
		String prezime = EditProfessorDialogInformacije.getFieldPrezime().getText().trim();
		String ime = EditProfessorDialogInformacije.getFieldIme().getText().trim();
		Date datumRodjenja = convertStringtoDate(EditProfessorDialogInformacije.getFieldDatum().getText().trim());
		String adresaStanovanja = EditProfessorDialogInformacije.getFieldAdresa().getText().trim();
		String telefon = EditProfessorDialogInformacije.getFieldBrTel().getText().trim();
		String email = EditProfessorDialogInformacije.getFieldMail().getText().trim();
		String adresaKancelarije = EditProfessorDialogInformacije.getFieldAdrKanc().getText().trim();
		String brojLicneKarte = EditProfessorDialogInformacije.getFieldBrLK().getText().trim();
		String titula = EditProfessorDialogInformacije.getFieldTitula().getText().trim();
		String zvanje = EditProfessorDialogInformacije.getFieldZvanje().getText().trim();

		for (Profesor profesor : BazaProfesora.getInstance().getProfesori()) {
			if (profesor.getBrojLicneKarte()
					.equalsIgnoreCase(EditProfessorDialogInformacije.getProfesor().getBrojLicneKarte())) {
				profesor.setPrezime(prezime);
				profesor.setIme(ime);
				profesor.setDatumRodjenja(datumRodjenja);
				profesor.setAdresaStanovanja(adresaStanovanja);
				profesor.setTelefon(telefon);
				profesor.setEmail(email);
				profesor.setAdresaKancelarije(adresaKancelarije);
				profesor.setBrojLicneKarte(brojLicneKarte);
				profesor.setTitula(titula);
				profesor.setZvanje(zvanje);
				break;
			}
		}

		ProfessorJTable.getInstance().azuriraj();
	}

	public Date convertStringtoDate(String date) {
		DateFormat format = new SimpleDateFormat("dd.MM.yyyy");
		Date retDate = null;
		try {
			retDate = format.parse(date);
		} catch (Exception e) {
			retDate = null;
		}

		return retDate;
	}

}
