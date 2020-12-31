package view;

import java.awt.BorderLayout;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class EditProfessor extends JTabbedPane {

	private static final long serialVersionUID = -5777241015354709431L;
	private static EditProfessor instance = null;

	public static EditProfessor getInstance() {
		if (instance == null) {
			instance = new EditProfessor();
		}
		return instance;
	}

	private EditProfessor() {
		JPanel informacije = new JPanel();
		JPanel predmeti = new JPanel();

		informacije.setLayout(new BorderLayout());
		this.add(informacije, "Informacije");
		informacije.add(new EditProfessorDialogInformacije());

		predmeti.setLayout(new BorderLayout());
		this.add(predmeti, "Predmeti");
		predmeti.add(new EditProfessorDialogPredmeti());

		this.setBorder(BorderFactory.createEmptyBorder(20, 0, 10, 0));
	}

	public static void resetInstance() {
		instance = null;
	}

}
