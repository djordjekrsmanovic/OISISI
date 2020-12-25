package controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import model.BazaProfesora;
import model.Profesor;
import view.AddProfessorDialog;
import view.ProfessorJTable;

public class ProfessorController {

	private static ProfessorController instance = null;

	public static ProfessorController getInstance() {
		if (instance == null) {
			instance = new ProfessorController();
		}
		return instance;
	}

	public boolean addStudent() {

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

		

		Profesor profesor = new Profesor(prezime, ime, datumRodjenja, adresaStanovanja, telefon, email, adresaKancelarije,
				brojLicneKarte, titula, zvanje);

		BazaProfesora bazaProfesora = BazaProfesora.getInstance();
		bazaProfesora.dodajProfesora(profesor);
		ProfessorJTable.getInstance().azuriraj();
		return true;

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
