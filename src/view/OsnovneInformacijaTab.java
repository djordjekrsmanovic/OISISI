package view;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JComboBox;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.StudentControler;
import listeners.EditStudentListener;
import model.BazaStudenata;
import model.Student;
import controller.ValidationStudent;

public class OsnovneInformacijaTab extends JPanel{
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
	private static Student student;
	

	public static void setStudent(Student student) {
		OsnovneInformacijaTab.student = student;
	}

	public OsnovneInformacijaTab(){		
		Dimension d=Toolkit.getDefaultToolkit().getScreenSize();
		
		this.setSize(d.width*3/8,(d.height*3/4)*97/100);
		setLayout(new BorderLayout());
		Dimension preferredDim=new Dimension(200,20);
		Dimension buttonDim=new Dimension(70,20);
		int row=StudentJTable.getInstance().convertRowIndexToModel(StudentJTable.getInstance().getSelectedRow());
		System.out.println("KOnvertovana"+row);
		
		student=BazaStudenata.getInstance().getRow(row);
		
		JPanel ime=new JPanel(new FlowLayout(FlowLayout.CENTER));
		JLabel labIme=new JLabel("Ime*");
		labIme.setPreferredSize(preferredDim);
		fieldIme=new JTextField();
		fieldIme.setPreferredSize(preferredDim);
		fieldIme.setName("fieldIme");
		
		ime.add(labIme);
		ime.add(fieldIme);
		
		JPanel prezime=new JPanel(new FlowLayout(FlowLayout.CENTER));
		JLabel labPrezime=new JLabel("Prezime*");
		labPrezime.setPreferredSize(preferredDim);
		fieldPrezime=new JTextField();
		fieldPrezime.setPreferredSize(preferredDim);
		fieldPrezime.setName("fieldPrezime");
		
		prezime.add(labPrezime);
		prezime.add(fieldPrezime);
		
		JPanel datum=new JPanel(new FlowLayout(FlowLayout.CENTER));
		JLabel labDatum=new JLabel("Datum rođenja*");
		labDatum.setPreferredSize(preferredDim);
		labDatum.setToolTipText("Format datuma dd.mm.yyyy. ili d.m.yyyy.");
		fieldDatum=new JTextField();
		fieldDatum.setPreferredSize(preferredDim);
		fieldDatum.setName("fieldDatum");
		datum.add(labDatum);
		datum.add(fieldDatum);
		
		JPanel adresa=new JPanel(new FlowLayout(FlowLayout.CENTER));
		JLabel labAdresa=new JLabel("Adresa stanovanja*");
		labAdresa.setPreferredSize(preferredDim);
		fieldAdresa=new JTextField();
		fieldAdresa.setPreferredSize(preferredDim);
		fieldAdresa.setName("fieldAdresa");
		fieldAdresa.setText(student.getAdresaStanovanja());
		adresa.add(labAdresa);
		adresa.add(fieldAdresa);
		
		JPanel brTel=new JPanel(new FlowLayout(FlowLayout.CENTER));
		JLabel labBrTel=new JLabel("Broj telefona*");
		labBrTel.setPreferredSize(preferredDim);
		fieldBrTel=new JTextField();
		fieldBrTel.setPreferredSize(preferredDim);
		fieldBrTel.setName("fieldBrTel");
		fieldBrTel.setText(student.getTelefon());
		brTel.add(labBrTel);
		brTel.add(fieldBrTel);
		
		JPanel mail=new JPanel(new FlowLayout(FlowLayout.CENTER));
		JLabel labMail=new JLabel("E-mail adresa*");
		labMail.setPreferredSize(preferredDim);
		fieldMail=new JTextField();
		fieldMail.setPreferredSize(preferredDim);
		fieldMail.setName("fieldMail");
		fieldMail.setText(student.getMail());
		mail.add(labMail);
		mail.add(fieldMail);
		

		
		JPanel brIndeks=new JPanel(new FlowLayout(FlowLayout.CENTER));
		JLabel labBrIndeks=new JLabel("Broj indeksa*");
		labBrIndeks.setToolTipText("Format indeksa smjer-broj-godina upisa");
		labBrIndeks.setPreferredSize(preferredDim);
		fieldBrIndeks=new JTextField();
		fieldBrIndeks.setPreferredSize(preferredDim);
		fieldBrIndeks.setName("fieldBrIndeks");
		fieldBrIndeks.setText(student.getBrojIndeksa());
		brIndeks.add(labBrIndeks);
		brIndeks.add(fieldBrIndeks);
		
		JPanel godUpis=new JPanel(new FlowLayout(FlowLayout.CENTER));
		JLabel labGodUpis=new JLabel("Godina upisa*");
		labGodUpis.setPreferredSize(preferredDim);
		fieldGodUpis=new JTextField();
		fieldGodUpis.setPreferredSize(preferredDim);
		fieldGodUpis.setName("fieldGodUpis");
		fieldGodUpis.setText(Integer.toString(student.getGodinaUpisa()));
		godUpis.add(labGodUpis);
		godUpis.add(fieldGodUpis);
		
		String godina[]= {"I (prva)","II (druga)","III (treća)","IV (četvrta)"};
		JPanel godinaStudija=new JPanel(new FlowLayout(FlowLayout.CENTER));
		JLabel labGodinaStudija=new JLabel("Godina studija*");
		labGodinaStudija.setPreferredSize(preferredDim);
		comboGodinaStudija=new JComboBox<String>(godina);
		comboGodinaStudija.setPreferredSize(preferredDim);
		comboGodinaStudija.setSelectedIndex(student.getTrenutnaGodinaStudija()-1);
		comboGodinaStudija.setName("GodinaStudija");
		godinaStudija.add(labGodinaStudija);
		godinaStudija.add(comboGodinaStudija);
		
		int indeks=1;
		if (student.getStatus()==Student.Status.B) {
			indeks=0;
		}
		String status[]= {"Budžet","Samofinansiranje"};
		JPanel statusStudenta=new JPanel(new FlowLayout(FlowLayout.CENTER));
		JLabel labStatusStudenta=new JLabel("Način finansiranja*");
		labStatusStudenta.setPreferredSize(preferredDim);
		comboStatus=new JComboBox<String>(status);
		comboStatus.setSelectedIndex(indeks);
		comboStatus.setPreferredSize(preferredDim);
		comboStatus.setName("Status");
		statusStudenta.add(labStatusStudenta);
		statusStudenta.add(comboStatus);
		
		izmjeniSadrzajPolja();
		JPanel central=new JPanel();
		central.setBorder(BorderFactory.createEmptyBorder(30, 0, 0, 0));
		central.setLayout(new BoxLayout(central,BoxLayout.Y_AXIS));
		
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
		
		add(central,BorderLayout.NORTH);
		
		fieldIme.addFocusListener(new EditStudentListener(fieldIme,0));
		fieldPrezime.addFocusListener(new EditStudentListener(fieldPrezime,1));
		fieldDatum.addFocusListener(new EditStudentListener(fieldDatum,2));
		fieldAdresa.addFocusListener(new EditStudentListener(fieldAdresa,3));
		fieldBrTel.addFocusListener(new EditStudentListener(fieldBrTel,4));
		fieldMail.addFocusListener(new EditStudentListener(fieldMail,5));
		fieldBrIndeks.addFocusListener(new EditStudentListener(fieldBrIndeks,6));
		fieldGodUpis.addFocusListener(new EditStudentListener(fieldGodUpis,7));
	

		ok=new Button("Potvrdi");
		ok.setPreferredSize(buttonDim);
		ok.setEnabled(true);

		cancel=new Button("Odustani");
		cancel.setPreferredSize(buttonDim);
		cancel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				ValidationStudent.getInstance().setEditLogickeVirjednost();
				EditStudentDialog.getInstance().dispose();
				EditStudentDialog.setInstance();
				EditStudent.setInstance();
				StudentJTable.getInstance().azuriraj();
			}
			
		});
		
		ok.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				ValidationStudent.getInstance().setEditLogickeVirjednost(); // kada je jednom dugme stavljeno na enable to 
					StudentControler.getInstance().editStudent();
					EditStudentDialog.getInstance().dispose();
					EditStudentDialog.setInstance();
					EditStudent.setInstance();
					StudentJTable.getInstance().azuriraj();
			}
			
		});
		JPanel bottom=new JPanel(new FlowLayout());
		bottom.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		bottom.setBackground(Color.decode("#cfcaca"));
		bottom.add(ok);
		bottom.add(Box.createRigidArea(new Dimension(30,0)));
		bottom.add(cancel);
		
		add(bottom,BorderLayout.SOUTH);
		
		
	}

	public static void izmjeniSadrzajPolja() {
		fieldIme.setText(student.getIme());
		fieldPrezime.setText(student.getPrezime());
		DateFormat dateFormat=new SimpleDateFormat("dd.MM.yyyy.");
		fieldDatum.setText(dateFormat.format(student.getDatumRodjenja()));
		fieldAdresa.setText(student.getAdresaStanovanja());
		fieldBrTel.setText(student.getTelefon());
		fieldMail.setText(student.getMail());
		fieldGodUpis.setText(Integer.toString(student.getGodinaUpisa()));
		comboGodinaStudija.setSelectedIndex(student.getTrenutnaGodinaStudija()-1);
		int indeks=1;
		if (student.getStatus()==Student.Status.B) {
			indeks=0;
		}
		comboStatus.setSelectedIndex(indeks);
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
	public static Student getStudent() {
		return student;
	}
	public  static  void setStudent() {
		student=BazaStudenata.getInstance().getRow(StudentJTable.getInstance().getSelectedRow());
	}
}

