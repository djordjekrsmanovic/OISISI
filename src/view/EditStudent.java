package view;

import java.awt.BorderLayout;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class EditStudent extends JTabbedPane {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7305705190643410136L;
	private static EditStudent instance = null;

	public static EditStudent getInstance() {
		if (instance == null) {
			instance = new EditStudent();
		}
		return instance;
	}

	private EditStudent() {
		JPanel osnovenInformacije = new JPanel();
		JPanel polozeni = new JPanel();
		JPanel nepolozeni = new JPanel();

		osnovenInformacije.setLayout(new BorderLayout());
		this.add(osnovenInformacije, "Informacije");
		osnovenInformacije.add(new OsnovneInformacijaTab());

		polozeni.setLayout(new BorderLayout());
		this.add(polozeni, "Položeni");

		nepolozeni.setLayout(new BorderLayout());
		this.add(nepolozeni, "Nepoloženi");
		this.setBorder(BorderFactory.createEmptyBorder(20, 0, 10, 0));
	}

	public static void setInstance() {
		instance = null;

	}

}
