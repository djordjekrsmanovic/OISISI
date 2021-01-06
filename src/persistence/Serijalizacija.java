package persistence;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Serijalizacija {
		public static void execute(SerializationClass src) throws FileNotFoundException, IOException {

			File f;
			ObjectOutputStream oos;

			f = new File("Baza.txt");
			oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(f)));
			try {
				oos.writeObject(src);
			} finally {
				oos.close();
			}

		}
}
