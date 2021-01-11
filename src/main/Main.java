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
