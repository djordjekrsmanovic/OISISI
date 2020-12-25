package view;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class ProfessorTab extends JPanel {

	private static final long serialVersionUID = -3961695640286811252L;
	private static ProfessorTab instance = null;

	public static ProfessorTab getInstance() {
		if (instance == null) {
			instance = new ProfessorTab();
		}
		return instance;

	}

	private ProfessorTab() {
		this.setLayout(new BorderLayout());
		JScrollPane scrollPane = new JScrollPane(ProfessorJTable.getInstance());
		scrollPane.setPreferredSize(new Dimension(800, 400));
		scrollPane.setBorder(BorderFactory.createEmptyBorder(50, 50, 30, 80));
		add(scrollPane, BorderLayout.CENTER);
	}

}
