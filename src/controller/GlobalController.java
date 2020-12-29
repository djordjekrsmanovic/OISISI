package controller;

import javax.swing.JOptionPane;

import model.BazaPredmeta;
import model.BazaStudenata;
import view.AddProfessorDialog;
import view.AddStudentDialog;
import view.AddSubjectDialog;
import view.CentralPanel;
import view.DeletePredmetDialog;
import view.DeleteStudentDialog;
import view.EditProfessorDialog;
import view.MainWindow;
import view.PredmetJTable;
import view.ProfessorJTable;
import view.StudentJTable;

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
			AddSubjectDialog  addSubjectDialog=new AddSubjectDialog(MainWindow.getInstance());
			addSubjectDialog.setVisible(true);
			break;
		}

	}

	public void editEntity() {

		switch (CentralPanel.getInstance().getSelectedIndex()) {
		case 0: // tab 0 - Studenti
			// TODO Dodati izmenu studenta.
			break;
		case 1: // tab 1 - Profesori
			EditProfessorDialog editProfessorDialog = EditProfessorDialog.getInstance();
			editProfessorDialog.setVisible(true);
			break;
		case 2: // tab 2 - Predmeti
			// TODO Dodati izmenu predmeta.
			break;
		}

	}

	public boolean isSelected() {
		switch (CentralPanel.getInstance().getSelectedIndex()) {
		case 0:
			if (StudentJTable.getInstance().getSelectedRow() == -1) {
				JOptionPane.showMessageDialog(null, "Potrebno je prvo da selektujete red iz tabele");
				return false;
			} else {
				return true;
			}

		case 1:
			if (ProfessorJTable.getInstance().getSelectedRow() == -1) {
				JOptionPane.showMessageDialog(null, "Potrebno je prvo da selektujete red iz tabele");
				return false;
			} else {
				return true;
			}
		case 2:
			if (PredmetJTable.getInstance().getSelectedRow() == -1) {
				JOptionPane.showMessageDialog(null, "Potrebno je prvo da selektujete red iz tabele");
				return false;
			} else {
				return true;
			}
		}
		return true;
	}

	public void deleteEntity() {
		switch (CentralPanel.getInstance().getSelectedIndex()) {
		case 0:
			BazaStudenata.getInstance().brisiStudenta();
			StudentJTable.getInstance().azuriraj();
			break;
		case 1:
			// TODO BazaProfesora.getInstance().izbrisiProfesora();
			break;
		case 2:
			BazaPredmeta.getInstance().izbrisiPredmet();
			PredmetJTable.getInstance().azuriraj();
		}
	}

	public void showDeleteDialog() {
		switch (CentralPanel.getInstance().getSelectedIndex()) {
		case 0:
			DeleteStudentDialog deleteStudentDialog=new DeleteStudentDialog(MainWindow.getInstance());
			deleteStudentDialog.setVisible(true);
			break;
		case 1:
			// TODO implementirati pokazivanje dijaloga za profesora
			// DeleteProfessorDialog deleteProfessorDialog = new
			// DeleteProfessorDialog(MainWindow.getInstance());
			// deleteProfessorDialog.setVisible(true);
			break;
		case 2:
			DeletePredmetDialog deletePredmetDialog = new DeletePredmetDialog(MainWindow.getInstance());
			deletePredmetDialog.setVisible(true);
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
