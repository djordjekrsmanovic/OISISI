package controller;

import model.BazaPredmeta;
import model.BazaStudenata;
import model.Predmet;
import model.Profesor;
import model.Student;
import view.AddStudentDialog;
import view.AddSubjectDialog;
import view.EditSubjectDialog;
import view.OsnovneInformacijaTab;
import view.PredmetJTable;
import view.StudentJTable;
import model.Predmet.Semestar;
import model.Student.Status;

public class PredmetController {
	private static PredmetController instance=null;
	
	public static PredmetController getInstance() {
		if (instance==null) {
			instance=new PredmetController();
		}
		return instance;
	}
	
	private PredmetController() {}
	
	public void addSubject() {
		String sifra=AddSubjectDialog.getFieldSifra().getText().trim();
		String naziv=AddSubjectDialog.getFieldNaziv().getText().trim();
		Integer godinaStudija=AddSubjectDialog.getGodinaCombo().getSelectedIndex()+1;
		Integer espb=Integer.parseInt(AddSubjectDialog.getFieldESPB().getText().trim());
		int semestar=AddSubjectDialog.getComboSemestar().getSelectedIndex();
		Predmet p=new Predmet();
		p.setSifra(sifra);
		p.setGodinaStudija(godinaStudija);
		p.setNaziv(naziv);
		p.setEspb(espb);
		if (semestar==0) {
			p.setSemestar(Predmet.Semestar.LETNJI);
		}else {
			p.setSemestar(Predmet.Semestar.ZIMSKI);
		}
		BazaPredmeta.getInstance().dodajPredmet(p);
		PredmetJTable.getInstance().azuriraj();
	}
	
	public void editPredmet() {
		String sifra=EditSubjectDialog.getFieldSifra().getText().trim();
		String naziv=EditSubjectDialog.getFieldNaziv().getText().trim();
		Integer godinaStudija=EditSubjectDialog.getGodinaCombo().getSelectedIndex()+1;
		Integer espb=Integer.parseInt(EditSubjectDialog.getFieldESPB().getText().trim());
		int semestar=EditSubjectDialog.getComboSemestar().getSelectedIndex();
		
		for (Predmet predmet:BazaPredmeta.getInstance().getPredmeti()) {
			if (predmet.getSifra().equalsIgnoreCase(EditSubjectDialog.getPredmet().getSifra())) {
				predmet.setSifra(sifra);
				predmet.setNaziv(naziv);
				predmet.setGodinaStudija(godinaStudija);
				predmet.setEspb(espb);
				if (semestar==0) {
					predmet.setSemestar(Predmet.Semestar.LETNJI);
				}else {
					predmet.setSemestar(Predmet.Semestar.ZIMSKI);
				}
				break;
			}
		}
		PredmetJTable.getInstance().azuriraj();
		
	}

	
}
