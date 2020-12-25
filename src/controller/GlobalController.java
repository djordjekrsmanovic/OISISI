package controller;

import view.AddProfessorDialog;
import view.AddStudentDialog;
import view.CentralPanel;
import view.MainWindow;

public class GlobalController {

	private static GlobalController instance = null;

	public void addEntity() {

		switch (CentralPanel.getInstance().getSelectedIndex()) {
		case 0: // tab 0 - Studenti
			// TODO dodati dijalog za studente
			AddStudentDialog addStudentDialog=new AddStudentDialog(MainWindow.getInstance());
			addStudentDialog.setVisible(true);
			break;
		case 1: // tab 1 - Profesori
			AddProfessorDialog addProfessorDialog = new AddProfessorDialog();
			addProfessorDialog.setVisible(true);
			break;
		case 2: // tab 2 - Predmeti
			// TODO dodati dijalog za predmete
			break;
		}

	}

	public static GlobalController getInstance() {
		if (instance == null) {
			instance = new GlobalController();
		}
		return instance;
	}

}
