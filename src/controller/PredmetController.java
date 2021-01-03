package controller;

import java.util.List;

import model.BazaPredmeta;
import model.BazaProfesora;
import model.BazaStudenata;
import model.Predmet;
import model.Profesor;
import model.Student;
import view.AddSubjectDialog;
import view.EditSubjectDialog;
import view.PredmetJTable;
import view.ProfessorJTable;

public class PredmetController {
	private static PredmetController instance = null;

	public static PredmetController getInstance() {
		if (instance == null) {
			instance = new PredmetController();
		}
		return instance;
	}

	private PredmetController() {
	}

	public void addSubject() {
		String sifra = AddSubjectDialog.getFieldSifra().getText().trim();
		String naziv = AddSubjectDialog.getFieldNaziv().getText().trim();
		Integer godinaStudija = AddSubjectDialog.getGodinaCombo().getSelectedIndex() + 1;
		Integer espb = Integer.parseInt(AddSubjectDialog.getFieldESPB().getText().trim());
		int semestar = AddSubjectDialog.getComboSemestar().getSelectedIndex();
		Predmet p = new Predmet();
		p.setSifra(sifra);
		p.setGodinaStudija(godinaStudija);
		p.setNaziv(naziv);
		p.setEspb(espb);
		if (semestar == 0) {
			p.setSemestar(Predmet.Semestar.LETNJI);
		} else {
			p.setSemestar(Predmet.Semestar.ZIMSKI);
		}
		BazaPredmeta.getInstance().dodajPredmet(p);
		PredmetJTable.getInstance().azuriraj();
	}

	public void editPredmet() {
		String sifra = EditSubjectDialog.getFieldSifra().getText().trim();
		String naziv = EditSubjectDialog.getFieldNaziv().getText().trim();
		Integer godinaStudija = EditSubjectDialog.getGodinaCombo().getSelectedIndex() + 1;
		Integer espb = Integer.parseInt(EditSubjectDialog.getFieldESPB().getText().trim());
		int semestar = EditSubjectDialog.getComboSemestar().getSelectedIndex();

		for (Predmet predmet : BazaPredmeta.getInstance().getPredmeti()) {
			if (predmet.getSifra().equalsIgnoreCase(EditSubjectDialog.getPredmet().getSifra())) {
				predmet.setSifra(sifra);
				predmet.setNaziv(naziv);
				predmet.setGodinaStudija(godinaStudija);
				predmet.setEspb(espb);
				if (semestar == 0) {
					predmet.setSemestar(Predmet.Semestar.LETNJI);
				} else {
					predmet.setSemestar(Predmet.Semestar.ZIMSKI);
				}
				break;
			}
		}
		PredmetJTable.getInstance().azuriraj();

	}

	public void izbrisiPredmet() {
		List<Predmet> predmeti = BazaPredmeta.getInstance().getPredmeti();
		String sifra = predmeti
				.get(PredmetJTable.getInstance().convertRowIndexToModel(PredmetJTable.getInstance().getSelectedRow()))
				.getSifra();
		int index = 1;

		// Uklanjanje iz liste predmeta.
		for (Predmet predmet : predmeti) {

			if (predmet.getSifra().equalsIgnoreCase(sifra)) {
				predmeti.remove(index - 1);
				break;
			}
			index++;
		}

		// Ukljanjanje iz liste predmeta koje predaje profesor.
		for (Profesor s : BazaProfesora.getInstance().getProfesori()) {
			index = 1;
			for (Predmet p : s.getPredajeNaPredmetima()) {
				if (p.getSifra().equalsIgnoreCase(sifra)) {
					s.getPredajeNaPredmetima().remove(index - 1);
					break;
				}
				index++;
			}
		}

		// Ukljanjanje iz liste nepolozenih ispita svakog studenta.
		for (Student s : BazaStudenata.getInstance().getStudenti()) {
			index = 1;
			for (Predmet p : s.getNepolozeniIspiti()) {
				if (p.getSifra().equalsIgnoreCase(sifra)) {
					s.getNepolozeniIspiti().remove(index - 1);
					break;
				}
				index++;
			}
		}

		// Ukljanjanje iz liste polozenih ispita svakog studenta. (Zakomentarisano jer
		// nema smisla da se, ako se neki predmet više ne predaje, on briše studentima
		// koji su ga položili.)
		/*
		 * for (Student s : BazaStudenata.getInstance().getStudenti()) { index = 1; for
		 * (Predmet p : s.getPolozeniIspiti()) { if
		 * (p.getSifra().equalsIgnoreCase(sifra)) { s.getPolozeniIspiti().remove(index -
		 * 1); break; } index++; } }
		 */

		ProfessorJTable.getInstance().azuriraj();
	}

}
