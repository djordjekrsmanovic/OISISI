package controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import model.BazaStudenata;
import model.Student;
import model.Student.Status;
import view.AddStudentDialog;
import view.OsnovneInformacijaTab;
import view.StudentJTable;

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
		String ime=OsnovneInformacijaTab.getFieldIme().getText().trim();
		String prezime=OsnovneInformacijaTab.getFieldPrezime().getText().trim();
		String datumRodjenja=OsnovneInformacijaTab.getFieldDatum().getText().trim();
		String adresaStanovanja=OsnovneInformacijaTab.getFieldAdresa().getText().trim();
		String brojTelefona=OsnovneInformacijaTab.getFieldBrTel().getText().trim();
		String mailAdresa=OsnovneInformacijaTab.getFieldMail().getText().trim();
		String brojIndeksa=OsnovneInformacijaTab.getFieldBrIndeks().getText().trim();
		String godinaUpisa=OsnovneInformacijaTab.getFieldGodUpis().getText().trim();
		int trenutnaGodinaStudija=OsnovneInformacijaTab.getComboGodinaStudija().getSelectedIndex()+1;
		int nacinFinansiranja=OsnovneInformacijaTab.getComboStatus().getSelectedIndex();
		
		for (Student s:BazaStudenata.getInstance().getStudenti()) {
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
				if (nacinFinansiranja==0) {
					s.setStatus(Status.B);
				}else {
					s.setStatus(Status.S);
				}
				break;
			}
		}
		StudentJTable.getInstance().azuriraj();;
		
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
