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

import controller.StudentControler;
import listeners.AddStudentListener;
import controller.ValidationStudent;

public class AddStudentDialog extends JDialog {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3629017807555286854L;

	private static JTextField fieldIme;
	private static JTextField fieldPrezime;
	private static JTextField fieldDatum;
	private static JTextField fieldAdresa;
	private static JTextField fieldBrTel;
	private static JTextField fieldMail;
	private static JTextField fieldBrIndeks;
	private static JTextField fieldGodUpis;
	private static JComboBox<String> comboGodinaStudija;
	private static JComboBox<String> comboStatus;
	private static Button ok;
	private static Button cancel;

	public AddStudentDialog(JFrame parent) {
		String naslov = "Dodavanje studenta";
		this.setTitle(naslov);
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocationRelativeTo(parent);
		this.setSize(d.width * 3 / 8, (d.height * 3 / 4) * 97 / 100);
		setLayout(new BorderLayout());
		Dimension preferredDim = new Dimension(200, 25);
		Dimension buttonDim = new Dimension(70, 30);
		setResizable(false);
		setModal(true);
		setLocationRelativeTo(parent);

		JPanel ime = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JLabel labIme = new JLabel("Ime*");
		labIme.setPreferredSize(preferredDim);
		fieldIme = new JTextField();
		fieldIme.setPreferredSize(preferredDim);
		fieldIme.setName("fieldIme");
		ime.add(labIme);
		ime.add(fieldIme);

		JPanel prezime = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JLabel labPrezime = new JLabel("Prezime*");
		labPrezime.setPreferredSize(preferredDim);
		fieldPrezime = new JTextField();
		fieldPrezime.setPreferredSize(preferredDim);
		fieldPrezime.setName("fieldPrezime");
		prezime.add(labPrezime);
		prezime.add(fieldPrezime);

		JPanel datum = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JLabel labDatum = new JLabel("Datum rođenja*");
		labDatum.setPreferredSize(preferredDim);
		labDatum.setToolTipText("Format datuma dd.mm.yyyy. ili d.m.yyyy.");
		fieldDatum = new JTextField();
		fieldDatum.setPreferredSize(preferredDim);
		fieldDatum.setName("fieldDatum");
		datum.add(labDatum);
		datum.add(fieldDatum);

		JPanel adresa = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JLabel labAdresa = new JLabel("Adresa stanovanja*");
		labAdresa.setPreferredSize(preferredDim);
		fieldAdresa = new JTextField();
		fieldAdresa.setPreferredSize(preferredDim);
		fieldAdresa.setName("fieldAdresa");
		adresa.add(labAdresa);
		adresa.add(fieldAdresa);

		JPanel brTel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JLabel labBrTel = new JLabel("Broj telefona*");
		labBrTel.setPreferredSize(preferredDim);
		fieldBrTel = new JTextField();
		fieldBrTel.setPreferredSize(preferredDim);
		fieldBrTel.setName("fieldBrTel");
		brTel.add(labBrTel);
		brTel.add(fieldBrTel);

		JPanel mail = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JLabel labMail = new JLabel("E-mail adresa*");
		labMail.setPreferredSize(preferredDim);
		fieldMail = new JTextField();
		fieldMail.setPreferredSize(preferredDim);
		fieldMail.setName("fieldMail");
		mail.add(labMail);
		mail.add(fieldMail);

		JPanel brIndeks = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JLabel labBrIndeks = new JLabel("Broj indeksa*");
		labBrIndeks.setToolTipText("Format indeksa smjer-broj-godina upisa");
		labBrIndeks.setPreferredSize(preferredDim);
		fieldBrIndeks = new JTextField();
		fieldBrIndeks.setPreferredSize(preferredDim);
		fieldBrIndeks.setName("fieldBrIndeks");
		brIndeks.add(labBrIndeks);
		brIndeks.add(fieldBrIndeks);

		JPanel godUpis = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JLabel labGodUpis = new JLabel("Godina upisa*");
		labGodUpis.setPreferredSize(preferredDim);
		fieldGodUpis = new JTextField();
		fieldGodUpis.setPreferredSize(preferredDim);
		fieldGodUpis.setName("fieldGodUpis");
		godUpis.add(labGodUpis);
		godUpis.add(fieldGodUpis);

		String godina[] = { "I (prva)", "II (druga)", "III (treća)", "IV (četvrta)" };
		JPanel godinaStudija = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JLabel labGodinaStudija = new JLabel("Godina studija*");
		labGodinaStudija.setPreferredSize(preferredDim);
		comboGodinaStudija = new JComboBox<String>(godina);
		comboGodinaStudija.setPreferredSize(preferredDim);
		comboGodinaStudija.setSelectedIndex(0);
		comboGodinaStudija.setName("GodinaStudija");
		godinaStudija.add(labGodinaStudija);
		godinaStudija.add(comboGodinaStudija);

		String status[] = { "Budžet", "Samofinansiranje" };
		JPanel statusStudenta = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JLabel labStatusStudenta = new JLabel("Način finansiranja*");
		labStatusStudenta.setPreferredSize(preferredDim);
		comboStatus = new JComboBox<String>(status);
		comboStatus.setSelectedIndex(0);
		comboStatus.setPreferredSize(preferredDim);
		comboStatus.setName("Status");
		statusStudenta.add(labStatusStudenta);
		statusStudenta.add(comboStatus);

		JPanel central = new JPanel();
		central.setBorder(BorderFactory.createEmptyBorder(30, 0, 0, 0));
		central.setLayout(new BoxLayout(central, BoxLayout.Y_AXIS));

		central.add(ime);
		central.add(prezime);
		central.add(datum);
		central.add(adresa);
		central.add(brTel);
		central.add(mail);
		central.add(brIndeks);
		central.add(godUpis);
		central.add(godinaStudija);
		central.add(statusStudenta);

		add(central, BorderLayout.NORTH);

		fieldIme.addFocusListener(new AddStudentListener(fieldIme, 0));
		fieldPrezime.addFocusListener(new AddStudentListener(fieldPrezime, 1));
		fieldDatum.addFocusListener(new AddStudentListener(fieldDatum, 2));
		fieldAdresa.addFocusListener(new AddStudentListener(fieldAdresa, 3));
		fieldBrTel.addFocusListener(new AddStudentListener(fieldBrTel, 4));
		fieldMail.addFocusListener(new AddStudentListener(fieldMail, 5));
		fieldBrIndeks.addFocusListener(new AddStudentListener(fieldBrIndeks, 6));
		fieldGodUpis.addFocusListener(new AddStudentListener(fieldGodUpis, 7));
		// comboGodinaStudija.addFocusListener(new
		// AddStudentListener(comboGodinaStudija,8));
		// comboStatus.addFocusListener(new AddStudentListener(comboStatus,9));

		ok = new Button("Potvrdi");
		ok.setPreferredSize(buttonDim);
		ok.setEnabled(false);

		cancel = new Button("Odustani");
		cancel.setPreferredSize(buttonDim);
		cancel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				ValidationStudent.getInstance().setLogickeVirjednost();
				dispose();
			}

		});

		ok.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				ValidationStudent.getInstance().setLogickeVirjednost(); // kada je jednom dugme stavljeno na enable to
				StudentControler.getInstance().addStudent();
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
				ValidationStudent.getInstance().setLogickeVirjednost();
				
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

	public static JTextField getFieldBrIndeks() {
		return fieldBrIndeks;
	}

	public static JTextField getFieldGodUpis() {
		return fieldGodUpis;
	}

	public static JComboBox<String> getComboGodinaStudija() {
		return comboGodinaStudija;
	}

	public static JComboBox<String> getComboStatus() {
		return comboStatus;
	}

	public static Button getOK() {
		return ok;
	}

	public static Button getCancel() {
		return cancel;
	}
}
