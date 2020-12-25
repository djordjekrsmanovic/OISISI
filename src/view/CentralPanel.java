package gui;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class CentralPanel extends JTabbedPane {

	private static final long serialVersionUID = 1L;
			
	public CentralPanel() {
		
		JPanel studenti = new JPanel();
		JPanel profesori = new JPanel();
		JPanel predmeti = new JPanel();
		
		this.addTab("Studenti", studenti);
		this.addTab("Profesori", profesori);
		this.addTab("Predmeti", predmeti);
		
	}

}
