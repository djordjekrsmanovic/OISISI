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
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.PredmetController;
import controller.ValidationSubject;
import listeners.AddSubjectListener;

public class AddSubjectDialog extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5731607876309753006L;

	private static JTextField fieldSifra;
	private static JTextField fieldNaziv;
	private static JTextField fieldESPB;
	private static Button ok;
	private static JComboBox<String> godinaCombo;
	private static JComboBox<String> comboSemestar;

	public AddSubjectDialog(JFrame parent) {

		setModal(true);
		setTitle("Dodavanje predmeta");
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		setSize(d.width * 3 / 8, (d.height * 3 / 4) * 80 / 100);
		setLayout(new BorderLayout());
		Dimension preferredDim = new Dimension(200, 25);
		Dimension buttonDim = new Dimension(70, 30);
		setResizable(false);
		setLocationRelativeTo(parent);

		JPanel sifra = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JLabel lblSifra = new JLabel("Šifra*");
		lblSifra.setPreferredSize(preferredDim);
		fieldSifra = new JTextField();
		fieldSifra.setPreferredSize(preferredDim);
		sifra.add(lblSifra);
		sifra.add(fieldSifra);

		JPanel naziv = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JLabel lblNaziv = new JLabel("Naziv predmeta*");
		lblNaziv.setPreferredSize(preferredDim);
		fieldNaziv = new JTextField();
		fieldNaziv.setPreferredSize(preferredDim);
		naziv.add(lblNaziv);
		naziv.add(fieldNaziv);

		JPanel panSemestar = new JPanel(new FlowLayout(FlowLayout.CENTER));
		String semestar[] = { "Ljetnji", "Zimski" };
		comboSemestar = new JComboBox<String>(semestar);
		comboSemestar.setPreferredSize(preferredDim);
		comboSemestar.setSelectedIndex(0);
		JLabel lblSemestar = new JLabel("Semestar*");
		lblSemestar.setToolTipText("Semestar u kom se predmet izvodi");
		lblSemestar.setPreferredSize(preferredDim);
		panSemestar.add(lblSemestar);
		panSemestar.add(comboSemestar);

		// TODO dodavanje profesora
		String godina[] = { "I (prva)", "II (druga)", "III (treća)", "IV (četvrta)" };
		godinaCombo = new JComboBox<String>(godina);
		godinaCombo.setPreferredSize(preferredDim);
		godinaCombo.setSelectedIndex(0);
		JPanel godinaPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JLabel lblGodina = new JLabel("Godina studija*");
		lblGodina.setToolTipText("Godina studija u kojoj se predmet izvodi");
		lblGodina.setPreferredSize(preferredDim);
		godinaPanel.add(lblGodina);
		godinaPanel.add(godinaCombo);

		JPanel brojESPB = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JLabel lblESPB = new JLabel("Broj ESPB bodova*");
		lblESPB.setPreferredSize(preferredDim);
		fieldESPB = new JTextField();
		fieldESPB.setPreferredSize(preferredDim);
		brojESPB.add(lblESPB);
		brojESPB.add(fieldESPB);

		JPanel central = new JPanel();
		central.setLayout(new BoxLayout(central, BoxLayout.Y_AXIS));
		central.setBorder(BorderFactory.createEmptyBorder(30, 30, 0, 0));
		central.add(sifra);
		central.add(naziv);
		central.add(panSemestar);
		central.add(godinaPanel);
		central.add(brojESPB);

		add(central, BorderLayout.NORTH);

		fieldSifra.addFocusListener(new AddSubjectListener(fieldSifra, 0));
		fieldNaziv.addFocusListener(new AddSubjectListener(fieldNaziv, 1));
		fieldESPB.addFocusListener(new AddSubjectListener(fieldESPB, 2));

		ok = new Button("Potvrdi");
		ok.setPreferredSize(buttonDim);
		ok.setEnabled(false);
		ok.addActionListener(new ActionListener() {
			
		
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (ValidationSubject.getInstance().subjectValid()) {
					ok.setEnabled(true);
					ValidationSubject.getInstance().setLogickeVirjednost();
					PredmetController.getInstance().addSubject();
					
					dispose();
				}

			}
		});
		Button cancel = new Button("Odustani");
		cancel.setPreferredSize(buttonDim);
		cancel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				ValidationSubject.getInstance().setLogickeVirjednost();
				dispose();
			}

		});

		JPanel bottom = new JPanel(new FlowLayout(FlowLayout.CENTER));
		bottom.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));
		bottom.setBackground(Color.decode("#cfcaca"));

		bottom.add(ok);
		bottom.add(Box.createRigidArea(new Dimension(30, 0)));
		bottom.add(cancel);

		add(bottom, BorderLayout.SOUTH);

	}

	public static Button getOk() {
		return ok;
	}

	public static void setOk(Button ok) {
		AddSubjectDialog.ok = ok;
	}

	public static JTextField getFieldSifra() {
		return fieldSifra;
	}

	public static void setFieldSifra(JTextField fieldSifra) {
		AddSubjectDialog.fieldSifra = fieldSifra;
	}

	public static JTextField getFieldNaziv() {
		return fieldNaziv;
	}

	public static void setFieldNaziv(JTextField fieldNaziv) {
		AddSubjectDialog.fieldNaziv = fieldNaziv;
	}

	public static JTextField getFieldESPB() {
		return fieldESPB;
	}

	public static void setFieldESPB(JTextField fieldESPB) {
		AddSubjectDialog.fieldESPB = fieldESPB;
	}

	public static JComboBox<String> getGodinaCombo() {
		return godinaCombo;
	}

	public static void setGodinaCombo(JComboBox<String> godinaCombo) {
		AddSubjectDialog.godinaCombo = godinaCombo;
	}

	public static JComboBox<String> getComboSemestar() {
		return comboSemestar;
	}

	
	
}
