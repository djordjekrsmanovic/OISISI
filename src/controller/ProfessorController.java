package controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import model.BazaProfesora;
import model.Profesor;
import view.AddProfessorDialog;
import view.EditProfessorDialogInformacije;
import view.ProfPredJTable;
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

		int titulaInd = AddProfessorDialog.getComboTitula().getSelectedIndex();
		Profesor.Titula titula;
		int zvanjeInd = AddProfessorDialog.getComboZvanje().getSelectedIndex();
		Profesor.Zvanje zvanje;

		switch (titulaInd) {
		case 0:
			titula = Profesor.Titula.BSC;
			break;
		case 1:
			titula = Profesor.Titula.MSC;
			break;
		case 2:
			titula = Profesor.Titula.MR;
			break;
		case 3:
			titula = Profesor.Titula.DR;
			break;
		case 4:
			titula = Profesor.Titula.PROF;
			break;
		default:
			titula = Profesor.Titula.PROF;
		}

		switch (zvanjeInd) {
		case 0:
			zvanje = Profesor.Zvanje.ASISTENT;
			break;
		case 1:
			zvanje = Profesor.Zvanje.DOCENT;
			break;
		case 2:
			zvanje = Profesor.Zvanje.PROFESOR;
			break;
		case 3:
			zvanje = Profesor.Zvanje.EMERITUS;
			break;
		default:
			zvanje = Profesor.Zvanje.EMERITUS;
		}

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
		int titulaInd = EditProfessorDialogInformacije.getComboTitula().getSelectedIndex();
		int zvanjeInd = EditProfessorDialogInformacije.getComboZvanje().getSelectedIndex();
		Profesor.Titula titula;
		Profesor.Zvanje zvanje;
		switch (titulaInd) {
		case 0:
			titula = Profesor.Titula.BSC;
			break;
		case 1:
			titula = Profesor.Titula.MSC;
			break;
		case 2:
			titula = Profesor.Titula.MR;
			break;
		case 3:
			titula = Profesor.Titula.DR;
			break;
		case 4:
			titula = Profesor.Titula.PROF;
			break;
		default:
			titula = Profesor.Titula.PROF;
		}

		switch (zvanjeInd) {
		case 0:
			zvanje = Profesor.Zvanje.ASISTENT;
			break;
		case 1:
			zvanje = Profesor.Zvanje.DOCENT;
			break;
		case 2:
			zvanje = Profesor.Zvanje.PROFESOR;
			break;
		case 3:
			zvanje = Profesor.Zvanje.EMERITUS;
			break;
		default:
			zvanje = Profesor.Zvanje.EMERITUS;
		}

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
	
	public void ukloniPredmet(String brojLicne) {
		int row=ProfPredJTable.getInstance().convertRowIndexToModel(ProfPredJTable.getInstance().getSelectedRow());
		Profesor profesor=BazaProfesora.getInstance().findProfesorByLicna(brojLicne);
		profesor.getPredajeNaPredmetima().get(row).setProfesor(null);
		profesor.getPredajeNaPredmetima().remove(row);
		
		ProfPredJTable.getInstance().azuriraj();
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
