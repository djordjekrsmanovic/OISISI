package view;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class PredmetTab extends JPanel {

	private static final long serialVersionUID = 2430594711181304804L;
	private static PredmetTab instance = null;

	public static PredmetTab getInstance() {
		if (instance == null) {
			instance = new PredmetTab();
		}
		return instance;

	}

	private PredmetTab() {
		this.setLayout(new BorderLayout());
		JScrollPane scrollPane = new JScrollPane(PredmetJTable.getInstance());
		scrollPane.setPreferredSize(new Dimension(800, 400));
		scrollPane.setBorder(BorderFactory.createEmptyBorder(50, 50, 30, 80));
		add(scrollPane, BorderLayout.CENTER);
	}

}
