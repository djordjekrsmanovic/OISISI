package controller;

import model.BazaPredmeta;
import model.Predmet;
import model.Profesor;
import view.AddStudentDialog;
import view.AddSubjectDialog;
import view.PredmetJTable;
import model.Predmet.Semestar;

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
	
}
