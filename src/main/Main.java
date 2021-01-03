package main;

import model.BazaOcena;
import model.BazaPredmeta;
import model.BazaProfesora;
import model.BazaStudenata;
import model.Profesor;
import view.MainWindow;

public class Main {

	public static void main(String[] args) {
		MainWindow glavniProzor = MainWindow.getInstance();
		glavniProzor.setVisible(true);
		BazaOcena.getInstance();
		//BazaStudenata.getInstance().dodajPredmet();
		/*
		Profesor p = BazaProfesora.getInstance().getProfesori().get(0);
		p.getPredajeNaPredmetima().add(BazaPredmeta.getInstance().getPredmeti().get(0));
		p.getPredajeNaPredmetima().add(BazaPredmeta.getInstance().getPredmeti().get(1));
		p.getPredajeNaPredmetima().add(BazaPredmeta.getInstance().getPredmeti().get(2));
		BazaPredmeta.getInstance().getPredmeti().get(0).setProfesor(p);
		BazaPredmeta.getInstance().getPredmeti().get(1).setProfesor(p);
		BazaPredmeta.getInstance().getPredmeti().get(2).setProfesor(p);
		*/
	}

}
