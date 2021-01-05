package persistence;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import model.BazaOcena;
import model.BazaPredmeta;
import model.BazaProfesora;
import model.BazaStudenata;
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

	private ObjectInputStream objectInputStream;

	private Deserijalizacija() {
	}

	public void deserijalizuj(){
		String naziv = "Baza.txt";
		SerializationClass src = new SerializationClass();
		try {
			File file = new File(naziv);
			if (file.exists() == true && file.length() != 0) {
				objectInputStream = new ObjectInputStream(new BufferedInputStream(new FileInputStream(file)));
				try {
					src = (SerializationClass) objectInputStream.readObject();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				BazaStudenata.getInstance().setStudenti(src.getStudenti());
				BazaOcena.getInstance().setOcjene(src.getOcene());
				BazaPredmeta.getInstance().setPredmeti(src.getPredmeti());
				BazaProfesora.getInstance().setProfesori(src.getProfesori());
				objectInputStream.close();
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}

}
