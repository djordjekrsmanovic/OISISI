package main;

import model.BazaOcena;
import model.BazaStudenata;
import view.MainWindow;

public class Main {

	public static void main(String[] args) {
		MainWindow glavniProzor = MainWindow.getInstance();
		glavniProzor.setVisible(true);
		BazaOcena.getInstance().initOcjene();
		BazaStudenata.getInstance().dodajPredmet();
	}

}
