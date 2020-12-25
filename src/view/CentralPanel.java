package view;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class CentralPanel extends JTabbedPane {

	private static final long serialVersionUID = 1L;
	
	private static CentralPanel instance = null;

	public static CentralPanel getInstance() {
		if(instance == null) {
			instance = new CentralPanel();
		}
		return instance;
	}
			
	public CentralPanel() {
		
		JPanel studenti = new JPanel();
		JPanel profesori = new JPanel();
		JPanel predmeti = new JPanel();
		
		this.addTab("Studenti", studenti);
		studenti.setLayout(new BorderLayout());
		//TODO Dodati tab studenti.
		
		this.addTab("Profesori", profesori);
		profesori.setLayout(new BorderLayout());
		profesori.add(ProfessorTab.getInstance());
		
		this.addTab("Predmeti", predmeti);
		predmeti.setLayout(new BorderLayout());
		//TODO Dodati tab predmeti.
	}

}
