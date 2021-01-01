package controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import model.BazaStudenata;
import model.Ocena;
import model.Predmet;
import model.Student;
import model.Student.Status;
import view.AbstractTableNepolozeni;
import view.AddStudentDialog;
import view.NepolozeniJTable;
import view.OcenaJTable;
import view.OsnovneInformacijaTab;
import view.StudentJTable;
import view.UpisOceneDialog;

public class StudentControler {

	private static StudentControler instance = null;

	public static StudentControler getInstance() {
		if (instance == null) {
			instance = new StudentControler();
		}
		return instance;
	}

	StudentControler() {
	}

	public void addStudent() {
		String ime = AddStudentDialog.getFieldIme().getText().trim();
		String prezime = AddStudentDialog.getFieldPrezime().getText().trim();
		String datumRodjenja = AddStudentDialog.getFieldDatum().getText().trim();
		String adresaStanovanja = AddStudentDialog.getFieldAdresa().getText().trim();
		String brojTelefona = AddStudentDialog.getFieldBrTel().getText().trim();
		String mailAdresa = AddStudentDialog.getFieldMail().getText().trim();
		String brojIndeksa = AddStudentDialog.getFieldBrIndeks().getText().trim();
		String godinaUpisa = AddStudentDialog.getFieldGodUpis().getText().trim();
		int trenutnaGodinaStudija = AddStudentDialog.getComboGodinaStudija().getSelectedIndex() + 1;
		int nacinFinansiranja = AddStudentDialog.getComboStatus().getSelectedIndex();

		Date datumRod = convertStringtoDate(datumRodjenja);
		Student student = new Student();
		student.setIme(ime);
		student.setPrezime(prezime);
		student.setDatumRodjenja(datumRod);
		student.setAdresaStanovanja(adresaStanovanja);
		student.setTelefon(brojTelefona);
		student.setMail(mailAdresa);
		student.setBrojIndeksa(brojIndeksa);
		student.setGodinaUpisa(Integer.parseInt(godinaUpisa));
		student.setTrenutnaGodinaStudija(trenutnaGodinaStudija);
		student.setProsjecnaOcjena(0);
		if (nacinFinansiranja == 0) {
			student.setStatus(Status.B);
		} else {
			student.setStatus(Status.S);
		}

		BazaStudenata bazaStudenata = BazaStudenata.getInstance();
		bazaStudenata.dodajStudenta(student);
		StudentJTable.getInstance().azuriraj();

	}

	public void editStudent() {
		String ime = OsnovneInformacijaTab.getFieldIme().getText().trim();
		String prezime = OsnovneInformacijaTab.getFieldPrezime().getText().trim();
		String datumRodjenja = OsnovneInformacijaTab.getFieldDatum().getText().trim();
		String adresaStanovanja = OsnovneInformacijaTab.getFieldAdresa().getText().trim();
		String brojTelefona = OsnovneInformacijaTab.getFieldBrTel().getText().trim();
		String mailAdresa = OsnovneInformacijaTab.getFieldMail().getText().trim();
		String brojIndeksa = OsnovneInformacijaTab.getFieldBrIndeks().getText().trim();
		String godinaUpisa = OsnovneInformacijaTab.getFieldGodUpis().getText().trim();
		int trenutnaGodinaStudija = OsnovneInformacijaTab.getComboGodinaStudija().getSelectedIndex() + 1;
		int nacinFinansiranja = OsnovneInformacijaTab.getComboStatus().getSelectedIndex();

		for (Student s : BazaStudenata.getInstance().getStudenti()) {
			if (s.getBrojIndeksa().equalsIgnoreCase(OsnovneInformacijaTab.getStudent().getBrojIndeksa())) {
				s.setIme(ime);
				s.setPrezime(prezime);
				s.setDatumRodjenja(convertStringtoDate(datumRodjenja));
				s.setAdresaStanovanja(adresaStanovanja);
				s.setTelefon(brojTelefona);
				s.setMail(mailAdresa);
				s.setBrojIndeksa(brojIndeksa);
				s.setGodinaUpisa(Integer.parseInt(godinaUpisa));
				s.setTrenutnaGodinaStudija(trenutnaGodinaStudija);
				if (nacinFinansiranja == 0) {
					s.setStatus(Status.B);
				} else {
					s.setStatus(Status.S);
				}
				break;
			}
		}
		StudentJTable.getInstance().azuriraj();
		;

	}

	public void brisiStudenta() {
		int row = StudentJTable.getInstance().convertRowIndexToModel(StudentJTable.getInstance().getSelectedRow());
		Student s = new Student(BazaStudenata.getInstance().findStudentByRow(row));
		List<Student> studenti = BazaStudenata.getInstance().getStudenti();
		int index = 1;
		for (Student student : studenti) {

			if (student.getBrojIndeksa().equalsIgnoreCase(s.getBrojIndeksa())) {
//				System.out.println("Usao u brisanje");
				studenti.remove(index - 1);
				break;
			}
			index++;
		}
		for (Student st : studenti) {
			System.out.println(st);
		}
		StudentJTable.getInstance().azuriraj();
	}

	public void upisOcene() {
		AbstractTableNepolozeni atn = new AbstractTableNepolozeni();
		Student student = atn.getStudentAtRow(NepolozeniJTable.getInstance().getSelectedRow());
		int index = 0;
		for (Predmet predmet : student.getNepolozeniIspiti()) {
			if (predmet.getSifra().equals(UpisOceneDialog.getFieldSifra().getText())) {
				System.out.println("qdfgsgsdg");
				student.getNepolozeniIspiti().remove(index);
				Ocena ocena = OcenaController.getInstance().addOcena(student, predmet);
				student.getPolozeniPredmeti().add(ocena);
				NepolozeniJTable.getInstance().azuriraj();
				OcenaJTable.getInstance().azuriraj();
				return;
			}
			++index;
		}
	}
	
	public void ponistiOcjenu(String brojIndeksa) {
		Student student=BazaStudenata.getInstance().getStudentByBrojIndeksa(brojIndeksa);
		int indeksPredmetaZaPonistavanje=OcenaJTable.getInstance().convertRowIndexToModel(OcenaJTable.getInstance().getSelectedRow());
		Predmet p=student.getPolozeniPredmeti().get(indeksPredmetaZaPonistavanje).getP();
		student.getPolozeniPredmeti().remove(indeksPredmetaZaPonistavanje); //ponistavanje ocjene 
		student.getNepolozeniIspiti().add(p); //dodavanje predmeta u nepolozene predmete
		OcenaJTable.getInstance().azuriraj();
		NepolozeniJTable.getInstance().azuriraj();
		OcenaController.getInstance().removeOcjena(OsnovneInformacijaTab.getStudent(),p);
		student.setProsjecnaOcjena(BazaStudenata.getInstance().getProsjek(brojIndeksa));
	}
	
	public void ukloniPredmet(String brojIndeksa) {
		Student student=BazaStudenata.getInstance().getStudentByBrojIndeksa(brojIndeksa);
		int indeksPredmetaZaUklanjanje=NepolozeniJTable.getInstance().convertRowIndexToModel(NepolozeniJTable.getInstance().getSelectedRow());
		student.getNepolozeniIspiti().remove(indeksPredmetaZaUklanjanje);
		NepolozeniJTable.getInstance().azuriraj();
	}

	public Date convertStringtoDate(String date) {
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

}
