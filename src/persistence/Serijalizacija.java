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

		f = new File("BazaOcena.txt");
		oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(f)));
		try {
			oos.writeObject(BazaOcena.getInstance());
		} finally {
			oos.close();
		}

		f = new File("BazaPredmeta.txt");
		oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(f)));
		try {
			oos.writeObject(BazaPredmeta.getInstance());
		} finally {
			oos.close();
		}

		f = new File("BazaProfesora.txt");
		oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(f)));
		try {
			oos.writeObject(BazaProfesora.getInstance());
		} finally {
			oos.close();
		}

		f = new File("BazaStudenata.txt");
		oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(f)));
		try {
			oos.writeObject(BazaStudenata.getInstance());
		} finally {
			oos.close();
		}

	}
}
