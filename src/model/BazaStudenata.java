package model;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import model.Student.Status;
import view.StudentJTable;

public class BazaStudenata {
	private static BazaStudenata instance=null;
	private List<Student> studenti;
	private List<String> kolone;
	
	public static BazaStudenata getInstance() {
		if (instance==null) {
			instance=new BazaStudenata();
			
		}
		return instance;
	}
	
	private BazaStudenata() {
		initStudenti();
		this.kolone=new ArrayList<String>();
		this.kolone.add("Indeks");
		this.kolone.add("Ime");
		this.kolone.add("Prezime");
		this.kolone.add("Godina studija");
		this.kolone.add("Status");
		this.kolone.add("Prosek");
	}
	
	
	

	private void initStudenti() {
		DateFormat datum=new SimpleDateFormat("dd.MM.yyyy");
		studenti=new ArrayList<Student>();
		try {
			studenti.add(new Student("Luka", "Jovanović", datum.parse("01.01.2000."), "Karađorđeva 83, Novi Sad", "021/333-555",
					 "luka.jovanovic@mailinator.com", "RA-1-2019", 2019, 1, Status.B, 0));
			studenti.add(new Student("Milenko", "Jovanović", datum.parse("03.01.1999."), "Alekse Šantića 4, Novi Sad", "021/333-555",
					 "milenko.jovanovic@gmail.com", "RA-2-2019", 2019, 1, Status.B, 0));
			studenti.add(new Student("Đorđe", "Krsmanovic", datum.parse("01.01.2000."), "Barakovac bb,Foča", "021/333-555",
					 "djordje1499@gmail.com", "RA-71-2018", 2018, 1, Status.B, 0));
			studenti.add(new Student("Jelena", "Nikolić", datum.parse("01.01.2000."), "Gogoljeva 4, Novi Sad", "021/333-555",
					 "luka.jovanovic@mailinator.com", "RA-8-2019", 2019, 1, Status.B, 0));

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	public void dodajStudenta(Student s){
		studenti.add(s);
	}
	
	public int getNumberOfColumns() {
		return kolone.size();
	}
	
	public int getNumberOfRows() {
		return studenti.size();
	}
	
	public String getColumnName(int indeks) {
		return kolone.get(indeks);
	}
	
	public Student getRow(int rowIndex) {
		return studenti.get(rowIndex);
	}
	
	public String getValueAt(int row,int column) {
		Student st=studenti.get(row);
		switch(column) {
		case 0:
			return st.getBrojIndeksa();
		case 1:
			return st.getIme();
		case 2:
			return st.getPrezime();
		case 3:
			return Integer.toString(st.getTrenutnaGodinaStudija());
		case 4:
			return st.getStatus().toString();
		case 5:
			return Double.toString(st.getProsjecnaOcjena());
		default:
			return null;
		}
	}

//	public  void ispisi() {
//		for(Student s:studenti) {
//			System.out.print(s);
//		}
//	}

	public List<Student> getStudenti() {
		return studenti;
	}

	public void setStudenti(List<Student> studenti) {
		this.studenti = studenti;
	}
	
	public void brisiStudenta() {
		int row=StudentJTable.getInstance().getSelectedRow();

		Student s=new Student(findStudentByRow(row));
		int index=1;
		for (Student student:studenti) {
			
			if (student.getBrojIndeksa().equalsIgnoreCase(s.getBrojIndeksa())) {
//				System.out.println("Usao u brisanje");
				studenti.remove(index-1);
				break;
			}
			index++;
		}
		for (Student st:studenti) {
			System.out.println(st);
		}
		StudentJTable.getInstance().azuriraj();
	}
	private Student findStudentByRow(int row) {
		return studenti.get(row);
	}
}
