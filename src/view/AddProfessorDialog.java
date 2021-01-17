package view;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.ProfessorController;
import controller.ValidationProfessor;
import controller.ValidationStudent;
import listeners.AddProfessorListener;

public class AddProfessorDialog extends JDialog {
	

	private static final long serialVersionUID = 7107186219503582633L;
	private static JTextField fieldIme;
	private static JTextField fieldPrezime;
	private static JTextField fieldDatum;
	private static JTextField fieldAdresa;
	private static JTextField fieldBrTel;
	private static JTextField fieldMail;
	private static JTextField fieldAdrKanc;
	private static JTextField fieldBrLK;
	private static JComboBox<String> comboTitula;
	private static JComboBox<String> comboZvanje;
	private static Button ok;
	private static Button cancel;

	public AddProfessorDialog() {
		JFrame mainFrame = MainWindow.getInstance();
		this.setTitle("Dodavanje profesora");
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocationRelativeTo(mainFrame);
		this.setSize(d.width * 3 / 8, (d.height * 3 / 4) * 97 / 100);
		setLayout(new BorderLayout());
		Dimension preferredDim = new Dimension(200, 25);
		Dimension buttonDim = new Dimension(70, 30);
		setResizable(false);
		setModal(true);
		setLocationRelativeTo(mainFrame);

		JPanel ime = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JLabel labIme = new JLabel("Ime*");
		labIme.setPreferredSize(preferredDim);
		fieldIme = new JTextField();
		fieldIme.setPreferredSize(preferredDim);
		ime.add(labIme);
		ime.add(fieldIme);

		JPanel prezime = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JLabel labPrezime = new JLabel("Prezime*");
		labPrezime.setPreferredSize(preferredDim);
		fieldPrezime = new JTextField();
		fieldPrezime.setPreferredSize(preferredDim);
		prezime.add(labPrezime);
		prezime.add(fieldPrezime);

		JPanel datum = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JLabel labDatum = new JLabel("Datum rođenja*");
		labDatum.setPreferredSize(preferredDim);
		fieldDatum = new JTextField();
		fieldDatum.setPreferredSize(preferredDim);
		datum.add(labDatum);
		datum.add(fieldDatum);

		JPanel adresa = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JLabel labAdresa = new JLabel("Adresa stanovanja*");
		labAdresa.setPreferredSize(preferredDim);
		fieldAdresa = new JTextField();
		fieldAdresa.setPreferredSize(preferredDim);
		adresa.add(labAdresa);
		adresa.add(fieldAdresa);

		JPanel brTel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JLabel labBrTel = new JLabel("Broj telefona*");
		labBrTel.setPreferredSize(preferredDim);
		fieldBrTel = new JTextField();
		fieldBrTel.setPreferredSize(preferredDim);
		brTel.add(labBrTel);
		brTel.add(fieldBrTel);

		JPanel mail = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JLabel labMail = new JLabel("E-mail adresa*");
		labMail.setPreferredSize(preferredDim);
		fieldMail = new JTextField();
		fieldMail.setPreferredSize(preferredDim);
		mail.add(labMail);
		mail.add(fieldMail);

		JPanel adrKanc = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JLabel labAdrKanc = new JLabel("Adresa kancelarije*");
		labAdrKanc.setPreferredSize(preferredDim);
		fieldAdrKanc = new JTextField();
		fieldAdrKanc.setPreferredSize(preferredDim);
		adrKanc.add(labAdrKanc);
		adrKanc.add(fieldAdrKanc);

		JPanel brLK = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JLabel labBrLK = new JLabel("Broj lične karte*");
		labBrLK.setPreferredSize(preferredDim);
		fieldBrLK = new JTextField();
		fieldBrLK.setPreferredSize(preferredDim);
		brLK.add(labBrLK);
		brLK.add(fieldBrLK);

		String titule[] = { "BSC", "MSC", "MR", "DR", "PROF" };
		JPanel titula = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JLabel labTitula = new JLabel("Titula*");
		labTitula.setPreferredSize(preferredDim);
		comboTitula = new JComboBox<String>(titule);
		comboTitula.setPreferredSize(preferredDim);
		comboTitula.setSelectedIndex(0);
		comboTitula.setName("Titula");
		titula.add(labTitula);
		titula.add(comboTitula);

		String zvanja[] = { "ASISTENT", "DOCENT", "PROFESOR", "EMERITUS" };
		JPanel zvanje = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JLabel labZvanje = new JLabel("Zvanje*");
		labZvanje.setPreferredSize(preferredDim);
		comboZvanje = new JComboBox<String>(zvanja);
		comboZvanje.setSelectedIndex(0);
		comboZvanje.setPreferredSize(preferredDim);
		comboZvanje.setName("Zvanje");
		zvanje.add(labZvanje);
		zvanje.add(comboZvanje);

		JPanel central = new JPanel();
		central.setBorder(BorderFactory.createEmptyBorder(30, 0, 0, 0));
		central.setLayout(new BoxLayout(central, BoxLayout.Y_AXIS));

		central.add(ime);
		central.add(prezime);
		central.add(datum);
		central.add(adresa);
		central.add(brTel);
		central.add(mail);
		central.add(adrKanc);
		central.add(brLK);
		central.add(titula);
		central.add(zvanje);

		add(central, BorderLayout.NORTH);

		fieldIme.addFocusListener(new AddProfessorListener(fieldIme, 0));
		fieldPrezime.addFocusListener(new AddProfessorListener(fieldPrezime, 1));
		fieldDatum.addFocusListener(new AddProfessorListener(fieldDatum, 2));
		fieldAdresa.addFocusListener(new AddProfessorListener(fieldAdresa, 3));
		fieldBrTel.addFocusListener(new AddProfessorListener(fieldBrTel, 4));
		fieldMail.addFocusListener(new AddProfessorListener(fieldMail, 5));
		fieldAdrKanc.addFocusListener(new AddProfessorListener(fieldAdrKanc, 6));
		fieldBrLK.addFocusListener(new AddProfessorListener(fieldBrLK, 7));

		ok = new Button("Potvrdi");
		ok.setPreferredSize(buttonDim);
		ok.setEnabled(false);
		ok.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (ValidationProfessor.getInstance().professorValidAdd()) {
					ValidationProfessor.getInstance().reset();
					ProfessorController.getInstance().addProfessor();
					dispose();
				}

			}

		});

		cancel = new Button("Odustani");
		cancel.setPreferredSize(buttonDim);
		cancel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				ValidationProfessor.getInstance().reset();
				dispose();

			}

		});

		JPanel bottom = new JPanel(new FlowLayout());
		bottom.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));
		bottom.setBackground(Color.decode("#cfcaca"));
		bottom.add(ok);
		bottom.add(Box.createRigidArea(new Dimension(30, 0)));
		bottom.add(cancel);

		add(bottom, BorderLayout.SOUTH);
		
		this.addWindowListener(new WindowListener() {

			@Override
			public void windowActivated(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowClosed(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowClosing(WindowEvent arg0) {
				ValidationProfessor.getInstance().reset();
				
			}

			@Override
			public void windowDeactivated(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowDeiconified(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowIconified(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowOpened(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
		});

	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public static JTextField getFieldIme() {
		return fieldIme;
	}

	public static JTextField getFieldPrezime() {
		return fieldPrezime;
	}

	public static JTextField getFieldDatum() {
		return fieldDatum;
	}

	public static JTextField getFieldAdresa() {
		return fieldAdresa;
	}

	public static JTextField getFieldBrTel() {
		return fieldBrTel;
	}

	public static JTextField getFieldMail() {
		return fieldMail;
	}

	public static JTextField getFieldAdrKanc() {
		return fieldAdrKanc;
	}

	public static JTextField getFieldBrLK() {
		return fieldBrLK;
	}

	public static JComboBox<String> getComboTitula() {
		return comboTitula;
	}

	public static JComboBox<String> getComboZvanje() {
		return comboZvanje;
	}

	public static Button getOk() {
		return ok;
	}

	public static void setOk(Button ok) {
		AddProfessorDialog.ok = ok;
	}

	public static Button getCancel() {
		return cancel;
	}

	public static void setCancel(Button cancel) {
		AddProfessorDialog.cancel = cancel;
	}

}
