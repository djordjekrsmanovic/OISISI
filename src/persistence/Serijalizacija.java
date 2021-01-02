package persistence;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import model.BazaOcena;
import model.BazaPredmeta;
import model.BazaProfesora;
import model.BazaStudenata;

public class Serijalizacija {
	public static void execute() throws FileNotFoundException, IOException {

		File f;
		ObjectOutputStream oos;

		f = new File("ListaOcena.txt");
		oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(f)));
		try {
			oos.writeObject(BazaOcena.getInstance().getOcjene());
		} finally {
			oos.close();
		}

		f = new File("ListaPredmeta.txt");
		oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(f)));
		try {
			oos.writeObject(BazaPredmeta.getInstance().getPredmeti());
		} finally {
			oos.close();
		}

		f = new File("ListaProfesora.txt");
		oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(f)));
		try {
			oos.writeObject(BazaProfesora.getInstance().getProfesori());
		} finally {
			oos.close();
		}

		f = new File("ListaStudenata.txt");
		oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(f)));
		try {
			oos.writeObject(BazaStudenata.getInstance().getStudenti());
		} finally {
			oos.close();
		}

	}
}
