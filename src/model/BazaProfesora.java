package model;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.swing.JTextField;

import view.ProfessorJTable;
import view.ToolBar;

public class BazaProfesora {
	private static BazaProfesora instance = null;
	private List<Profesor> profesori;
	private List<String> kolone;
	private List<Profesor> filteredProfesori;

	public static BazaProfesora getInstance() {
		if (instance == null) {
			instance = new BazaProfesora();

		}
		return instance;
	}

	private BazaProfesora() {
		this.kolone = new ArrayList<String>();
		this.kolone.add("Ime");
		this.kolone.add("Prezime");
		this.kolone.add("Titula");
		this.kolone.add("Zvanje");
		profesori = new ArrayList<Profesor>();
		filteredProfesori = new ArrayList<Profesor>();
		initProfesori();
	}

	private void initProfesori() {
		DateFormat datum = new SimpleDateFormat("dd.MM.yyyy");
		try {
			profesori.add(new Profesor("Bajagić", "Momčilo", datum.parse("09.02.1960."), "Vase Stajića 16", "555-333",
					"jesimozdazaspala1@bajaga.com", "Šekspirova 17", "00792434", Profesor.Titula.DR,
					Profesor.Zvanje.DOCENT));
			profesori.add(new Profesor("Torbica", "Momčilo", datum.parse("09.03.1960."), "Vase Stajića 16", "555-333",
					"jesimozdazaspala2@bajaga.com", "Šekspirova 17", "10792434", Profesor.Titula.DR,
					Profesor.Zvanje.EMERITUS));
			profesori.add(new Profesor("Bajagić", "Galeb", datum.parse("09.04.1960."), "Vase Stajića 16", "555-333",
					"jesimozdazaspala3@bajaga.com", "Šekspirova 17", "20792434", Profesor.Titula.DR,
					Profesor.Zvanje.PROFESOR));
			profesori.add(new Profesor("Torbica", "Galeb", datum.parse("09.05.1960."), "Vase Stajića 16", "555-333",
					"jesimozdazaspala4@bajaga.com", "Šekspirova 17", "30792434", Profesor.Titula.DR,
					Profesor.Zvanje.DOCENT));
			profesori.add(new Profesor("Basara", "Momčilo", datum.parse("09.06.1960."), "Vase Stajića 16", "555-333",
					"jesimozdazaspala5@bajaga.com", "Šekspirova 17", "40792434", Profesor.Titula.DR,
					Profesor.Zvanje.DOCENT));
			profesori.add(new Profesor("Bajagić", "Mia", datum.parse("09.07.1960."), "Vase Stajića 16", "555-333",
					"jesimozdazaspala6@bajaga.com", "Šekspirova 17", "50792434", Profesor.Titula.DR,
					Profesor.Zvanje.DOCENT));
			profesori.add(new Profesor("Basara", "Mia", datum.parse("09.08.1960."), "Vase Stajića 16", "555-333",
					"jesimozdazaspala7@bajaga.com", "Šekspirova 17", "60792434", Profesor.Titula.DR,
					Profesor.Zvanje.DOCENT));

		} catch (ParseException e) {
			e.printStackTrace();
		}

	}

	public void dodajProfesora(Profesor profesor) {
		profesori.add(profesor);
	}

	public void filterProfesori() {
		filteredProfesori = new ArrayList<>(profesori);

		String[] searchArgs = ToolBar.getInstance().getSearchTextField().getText().split(" ");

		if (searchArgs.length == 1 || searchArgs.length == 2) {
			filteredProfesori = filteredProfesori.stream().filter(prof -> prof.getPrezime().toLowerCase().contains(searchArgs[0].toLowerCase()))
					.collect(Collectors.toList());
		}
		if (searchArgs.length == 2) {
			filteredProfesori = filteredProfesori.stream().filter(prof -> prof.getIme().toLowerCase().contains(searchArgs[1].toLowerCase()))
					.collect(Collectors.toList());
		}
	}

	public void izbrisiProfesora() {
		String brojLicneKarte = profesori.get(ProfessorJTable.getInstance().getSelectedRow()).brojLicneKarte;
		int index = 1;
		for (Profesor profesor : profesori) {

			if (profesor.getBrojLicneKarte().equalsIgnoreCase(brojLicneKarte)) {
				profesori.remove(index - 1);
				break;
			}
			index++;
		}

		ProfessorJTable.getInstance().azuriraj();
	}

	public int getNumberOfColumns() {
		filterProfesori();
		return kolone.size();
	}

	public int getNumberOfRows() {
		return filteredProfesori.size();
	}

	public String getColumnName(int indeks) {
		return kolone.get(indeks);
	}

	public Profesor getRow(int rowIndex) {
		return filteredProfesori.get(rowIndex);
	}

	public String getValueAt(int row, int column) {

		Profesor profesor = filteredProfesori.get(row);

		switch (column) {
		case 0:
			return profesor.getIme();
		case 1:
			return profesor.getPrezime();
		case 2:
			return profesor.getTitula().name();
		case 3:
			return profesor.getZvanje().name();
		default:
			return null;
		}
	}

	public List<Profesor> getProfesori() {
		return profesori;
	}

}
