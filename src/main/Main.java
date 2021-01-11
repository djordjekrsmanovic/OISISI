package main;

import model.BazaOcena;
import model.BazaPredmeta;
import model.BazaProfesora;
import model.BazaStudenata;
import persistence.Deserijalizacija;
import view.MainWindow;

public class Main {

	public static void main(String[] args) {
		
		BazaOcena.getInstance();
		BazaPredmeta.getInstance();
		BazaProfesora.getInstance();
		BazaStudenata.getInstance();
		Deserijalizacija.getInstance().deserijalizuj();
		MainWindow glavniProzor = MainWindow.getInstance();
		glavniProzor.setVisible(true);
	
	}

}
