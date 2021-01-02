package persistence;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import model.Ocena;
import model.Predmet;
import model.Profesor;
import model.Student;

public class Deserijalizacija {

	private static Deserijalizacija instance = null;

	public static Deserijalizacija getInstance() {
		if (instance == null) {
			instance = new Deserijalizacija();
		}
		return instance;
	}

	private Deserijalizacija() {
	}

	@SuppressWarnings("unchecked")
	public  ArrayList<Student> deserijalizacijaStudenata() throws ClassNotFoundException {
		String naziv = "ListaStudenata.txt";
		ArrayList<Student> studenti = new ArrayList<Student>();
		try {
			FileInputStream file = new FileInputStream(naziv);
			ObjectInputStream in = new ObjectInputStream(file);
			studenti = (ArrayList<Student>) in.readObject();
			in.close();
			file.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return studenti;

	}

	@SuppressWarnings("unchecked")
	public  ArrayList<Predmet> deserijalizacijaPredmeta() throws ClassNotFoundException {
		String naziv = "ListaPredmeta.txt";
		ArrayList<Predmet> predmeti = new ArrayList<>();
		try {
			FileInputStream file = new FileInputStream(naziv);
			ObjectInputStream in = new ObjectInputStream(file);
			predmeti = (ArrayList<Predmet>) in.readObject();
			in.close();
			file.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return predmeti;

	}
	@SuppressWarnings("unchecked")
	public ArrayList<Profesor> deserijalizacijaProfesora() throws ClassNotFoundException {
		String naziv = "ListaProfesora.txt";
		ArrayList<Profesor> profesori = new ArrayList<>();
		try {
			FileInputStream file = new FileInputStream(naziv);
			ObjectInputStream in = new ObjectInputStream(file);
			profesori = (ArrayList<Profesor>) in.readObject();
			in.close();
			file.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return profesori;

	}
	
	@SuppressWarnings("unchecked")
	public  ArrayList<Ocena> deserijalizacijaOcena() throws ClassNotFoundException {
		String naziv = "ListaOcena.txt";
		ArrayList<Ocena> ocene = new ArrayList<>();
		try {
			FileInputStream file = new FileInputStream(naziv);
			ObjectInputStream in = new ObjectInputStream(file);
			ocene= (ArrayList<Ocena>) in.readObject();
			in.close();
			file.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ocene;

	}
}
