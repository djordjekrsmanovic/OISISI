package view;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import model.BazaProfesora;

public class DodajPredmetProfesoruDialog extends JDialog {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3105927763345347744L;
	private static Button ok;
	private static Button cancel;

	DodajPredmetProfesoruDialog() {
		EditProfessorDialog parent = EditProfessorDialog.getInstance();
		this.setTitle("Dodaj predmet");
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocationRelativeTo(parent);
		this.setSize(d.width * 3 / 12, (d.height * 3 / 8) * 97 / 100);
		setLayout(new BorderLayout());
		Dimension buttonDim = new Dimension(70, 30);
		setResizable(false);
		setModal(true);
		setLocationRelativeTo(parent);
		
		JPanel central = new JPanel();
		central.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		central.setLayout(new BoxLayout(central, BoxLayout.Y_AXIS));
		
		DodajPredmetProfesoruJTable.getInstance().azuriraj();
		DodajPredmetProfesoruJTable tabela = DodajPredmetProfesoruJTable.getInstance();
		JScrollPane scrollPane = new JScrollPane(tabela);
		scrollPane.setBorder(BorderFactory.createEmptyBorder(20, 20, 10, 20));
		
		central.add(new JLabel("Predmeti:"));
		central.add(new JLabel(" "));
		central.add(tabela);

		add(central, BorderLayout.NORTH);

		ok = new Button("Potvrdi");
		ok.setPreferredSize(buttonDim);
		ok.setEnabled(true);
		ok.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				BazaProfesora.getInstance().dodajPredmet();
				ProfPredJTable.getInstance().azuriraj();
				dispose();
			}

		});

		cancel = new Button("Odustani");
		cancel.setPreferredSize(buttonDim);
		cancel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();

			}

		});

		JPanel bottom = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		bottom.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));
		bottom.setBackground(Color.decode("#cfcaca"));
		bottom.add(ok);
		bottom.add(Box.createRigidArea(new Dimension(30, 0)));
		bottom.add(cancel);

		add(bottom, BorderLayout.SOUTH);
	}
}
