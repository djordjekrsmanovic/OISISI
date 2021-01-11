package model;

import java.util.ArrayList;
import java.util.List;

public class BazaStudenata {
	private static BazaStudenata instance = null;
	private List<Student> studenti;
	private List<String> kolone;

	public static BazaStudenata getInstance() {
		if (instance == null) {
			instance = new BazaStudenata();

		}
		return instance;
	}

	private BazaStudenata() {
		initStudenti();
		this.kolone = new ArrayList<String>();
		this.kolone.add("Indeks");
		this.kolone.add("Ime");
		this.kolone.add("Prezime");
		this.kolone.add("Godina studija");
		this.kolone.add("Status");
		this.kolone.add("Prosek");
	}

	private void initStudenti() {
		studenti = new ArrayList<Student>();
//		DateFormat datum=new SimpleDateFormat("dd.MM.yyyy");
//		try {
//			

//			studenti.add(new Student("Luka", "Jovanović", datum.parse("01.01.2000."), "Karađorđeva 83, Novi Sad", "021/333-555",
//					 "luka.jovanovic@mailinator.com", "RA-1-2019", 2019, 1, Status.B, 0));
//			studenti.add(new Student("Milenko", "Jovanović", datum.parse("03.01.1999."), "Alekse Šantića 4, Novi Sad", "021/333-555",
//					 "milenko.jovanovic@gmail.com", "RA-2-2019", 2019, 1, Status.B, 0));
//			studenti.add(new Student("Đorđe", "Krsmanovic", datum.parse("01.01.2000."), "Barakovac bb,Foča", "021/333-555",
//					 "djordje1499@gmail.com", "RA-71-2018", 2018, 1, Status.B, 0));
//			studenti.add(new Student("Jelena", "Nikolić", datum.parse("01.01.2000."), "Gogoljeva 4, Novi Sad", "021/333-555",
//					 "luka.jovanovic@mailinator.com", "RA-8-2019", 2019, 1, Status.B, 0));

//			studenti.add(new Student("Marko","Milosevic",datum.parse("12.03.2001."),"Karađorđeva 83, Novi Sad","021/333-555","marko.milosevic@mailinator.com","RA-2-2020",2020,1,Status.B,0));											
//			studenti.add(new Student("Marija","Milić",datum.parse("12.01.2000."),"Stražilovska 12, Novi Sad","021/555-2222","marija.milic@mailinator.com","RA-3-2019",2019,2,Status.S,0));											
//			studenti.add(new Student("Nikola","Nikolic",datum.parse("30.08.2001."),"Knez Mihajlova 16, Beograd","021/135-463","nikola.nikolic@mailinator.com","RA-3-2017",2017,1,Status.B,0));											
//			studenti.add(new Student("Pera","Peric",datum.parse("07.06.1995."),"Gogoljeva 3, Novi Sad","021/903-463","pera.peric@mailinator.com","RA-134-2015",2015,3,Status.S,0));											
//			studenti.add(new Student("Sofija","Ilic",datum.parse("06.05.1999."),"Miše Dimitrijevića 44, Novi Sad","021/731-067","sofija.ilic@mailinator.com","RA-5-2019",2019,3,Status.B,0));											
//			studenti.add(new Student("Martina","Lukic",datum.parse("16.05.1999."),"Vojvode Stepe 180, Beograd","011/4333-800","martina.lukic@mailinator.com","RA-8-2018",2018,3,Status.S,0));											
//			studenti.add(new Student("Stojan","Stojakovic",datum.parse("19.10.2001."),"1300 Kaplara, Šabac","011/3130-007","stojan.stojakovic@mailinator.com","RA-10-2017",2017,1,Status.B,0));											
//			studenti.add(new Student("Milan","Milanovic",datum.parse("02.11.2000."),"Surepova 12, Šabac","015/313-061","milan.milanovic@mailinator.com","RA-12-2017",2017,2,Status.S,0));											
//			studenti.add(new Student("Miroslav","Milic",datum.parse("11.10.2000."),"Milovana Glišića, Valjevo","021/351-091","miroslav.milic@mailinator.com","RA-16-2019",2019,2,Status.B,0));											
//			studenti.add(new Student("Stefan","Gojic",datum.parse("01.05.1999."),"Bulevar Mihajla Pupina, Novi Sad","015/324-500","stefan.gojic@mailinator.com","RA-21-2015",2015,3,Status.S,0));											
//			studenti.add(new Student("Anastasija","Jokic",datum.parse("11.07.1999."),"Braće Ribnikar 12, Novi Sad","011/2333-900","anastasija.jokic@mailinator.com","RA-9-2020",2020,3,Status.B,0));											
//			studenti.add(new Student("Bogdan","Bogdanovic",datum.parse("23.07.1999."),"Cara Dušana 42, Subotica","021/231-114","bogdan.bogdanovic@mailinator.com","RA-4-2017",2017,3,Status.S,0));											
//			studenti.add(new Student("Ana","Dabovic",datum.parse("12.12.2001."),"Marka Kraljevića 1, Kikinda","014/303-007","ana.dabovic@mailinator.com","RA-30-2019",2019,1,Status.B,0));											
//			studenti.add(new Student("Mika","Mikic",datum.parse("05.11.2001."),"Nikole Stojanovića 2, Kraljevo","015/101-909","mika.mikic@mailinator.com","RA-1-2020",2020,1,Status.S,0));											
//			studenti.add(new Student("Jovan","Deretic",datum.parse("10.09.1998."),"Marka Bratića 99, Niš","002/200-300","jovan.deretic@mailinator.com","RA-11-2018",2018,4,Status.B,0));											
//			studenti.add(new Student("Nikola","Miskovic",datum.parse("03.08.1998."),"Cara Dušana 12, Banja Luka","022/123-456","nikola.miskovic@mailinator.com","RA-12-2018",2018,4,Status.S,0));											
//			studenti.add(new Student("Martin","Stojanovic",datum.parse("01.05.1998."),"Borisa Bačkog 1, Bijeljina","024/321-775","martin.stojanovic@mailinator.com","RA-13-2018",2018,4,Status.S,0));											
//			studenti.add(new Student("Tomislav","Novakovic",datum.parse("25.02.1996."),"Mirka Maksića 10, Kruševac","011/1188-379","tomislav.novakovic@mailinator.com","RA-14-2018",2018,4,Status.B,0));											
//			studenti.add(new Student("Lena","Ivic",datum.parse("11.05.1998."),"Stari Most 6, Sremska Mitrovica","024/333-555","lena.ivic@mailinator.com","RA-154-2016",2016,4,Status.B,0));											
//			studenti.add(new Student("Jovan","Lazic",datum.parse("22.01.2001."),"Nevesinjskih ustanika 10, Nevesinje","025/1189-479","jovan.lazic@mailinator.com","RA-23-2020",2020,1,Status.B,0));											
//			studenti.add(new Student("Isidora","Mikic",datum.parse("31.12.2000."),"Radničка 11, Novi Sad","011/1122-366","isidora.mikic@mailinator.com","RA-1-2019",2019,2,Status.B,0));											
//			studenti.add(new Student("Vladimir","Ilic",datum.parse("31.08.1998."),"Miloša Obilića 1, Beograd","0211122-367","vladimir.ilic@mailinator.com","SW-4-2014",2014,4,Status.B,0));											
//			studenti.add(new Student("Mirko","Alicic",datum.parse("21.07.1999."),"Heroja Pinkija 112, Novi Sad","012/1122-368","mirko.alicic@mailinator.com","SW-17-2015",2015,3,Status.S,0));											
//			studenti.add(new Student("Milisav","Perkovic",datum.parse("28.09.1998."),"Pavla Bakića 26, Novi Sad","012/1122-369","milisav.pejkovic@mailinator.com","SW-17-2016",2016,4,Status.S,0));											
//			studenti.add(new Student("Purisa","Djordjevic",datum.parse("29.02.2000."),"Pavla Papa 1, Novi Sad","011/1543-370","purisa.djordjevic@mailinator.com","SW-27-2018",2018,2,Status.B,0));											
//			studenti.add(new Student("Mikica","Kovacevic",datum.parse("23.03.1999."),"Valentina Vodnika 112, Novi Sad","011/1992-371","mikica.kovacevic@mailinator.com","RA-226-2017",2017,3,Status.S,0));											
//			studenti.add(new Student("Miloš","Milić",datum.parse("21.10.2001."),"Neznanog junaka 12, Beograd","011/8172-372","milos.milic@mailinator.com","SW-12-2020",2020,1,Status.S,0));											
//
//		} catch (ParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

	}

	public void dodajPredmet() {

		Student s;
		s = studenti.get(0);

		s.getNepolozeniIspiti().add(BazaPredmeta.getInstance().getPredmeti().get(0));
		s.getNepolozeniIspiti().add(BazaPredmeta.getInstance().getPredmeti().get(1));
		s.getNepolozeniIspiti().add(BazaPredmeta.getInstance().getPredmeti().get(2));
		s.getPolozeniPredmeti().add(BazaOcena.getInstance().getOcjene().get(0));
		s.getPolozeniPredmeti().add(BazaOcena.getInstance().getOcjene().get(1));
		Student s1 = studenti.get(1);
		s1.getNepolozeniIspiti().add(BazaPredmeta.getInstance().getPredmeti().get(2));
		s1.getNepolozeniIspiti().add(BazaPredmeta.getInstance().getPredmeti().get(3));
		s1.getPolozeniPredmeti().add(BazaOcena.getInstance().getOcjene().get(1));

	}

	public Student getStudentByBrojIndeksa(String brojIndeksa) {
		for (Student s : studenti) {
			if (s.getBrojIndeksa() == brojIndeksa) {
				return s;
			}
		}
		return null;
	}

	public float getProsjek(String indeks) {
		float prosjek = 0;
		for (Student s : studenti) {
			if (s.getBrojIndeksa().equalsIgnoreCase(indeks)) {
				for (Ocena o : s.getPolozeniPredmeti()) {
					prosjek += o.getVrijednostOcjene();
				}
				if (s.getPolozeniPredmeti().size() > 0) {
					prosjek = prosjek / s.getPolozeniPredmeti().size();
				}
				break;
			}
		}
		return prosjek;
	}

	public int getESPB(String indeks) {
		int espb = 0;
		for (Student s : studenti) {
			if (s.getBrojIndeksa().equalsIgnoreCase(indeks)) {
				for (Ocena o : s.getPolozeniPredmeti()) {
					espb += o.getP().getEspb();
				}
				break;
			}

		}
		return espb;
	}

	public void dodajStudenta(Student s) {
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

	public String getValueAt(int row, int column) {
		Student st = studenti.get(row);
		switch (column) {
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

	public Student findStudentByRow(int row) {
		return studenti.get(row);
	}

	public Student findStudentByIndeks(String indeks) {
		for (Student s : studenti) {
			if (s.getBrojIndeksa().equalsIgnoreCase(indeks)) {
				return s;
			}
		}
		return null;
	}
}
