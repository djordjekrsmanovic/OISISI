package view;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.regex.Pattern;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.StudentControler;

public class UpisOceneDialog extends JDialog {

	private static final long serialVersionUID = -5546730580092345928L;

	private static JTextField fieldSifra;
	private static JTextField fieldNaziv;
	private static JComboBox<Integer> comboOcena;
	private static JTextField fieldDatum;
	private static Button ok;
	private static Button cancel;

	public UpisOceneDialog() {
		EditStudentDialog parent = EditStudentDialog.getInstance();
		this.setTitle("Unos ocene");
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocationRelativeTo(parent);
		this.setSize(d.width * 3 / 8, (d.height * 1 / 2) * 97 / 100);
		setLayout(new BorderLayout());
		Dimension preferredDim = new Dimension(200, 25);
		Dimension buttonDim = new Dimension(70, 30);
		setResizable(false);
		setModal(true);
		setLocationRelativeTo(parent);

		JPanel sifra = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JLabel labSifra = new JLabel("Sifra*");
		labSifra.setPreferredSize(preferredDim);
		fieldSifra = new JTextField();
		fieldSifra.setPreferredSize(preferredDim);
		fieldSifra.setText((String)(new AbstractTableNepolozeni().getValueAt(NepolozeniJTable.getInstance().convertRowIndexToModel(NepolozeniJTable.getInstance().getSelectedRow()), 0)));
		fieldSifra.setEnabled(false);
		sifra.add(labSifra);
		sifra.add(fieldSifra);

		JPanel naziv = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JLabel labNaziv = new JLabel("Naziv*");
		labNaziv.setPreferredSize(preferredDim);
		fieldNaziv = new JTextField();
		fieldNaziv.setPreferredSize(preferredDim);
		fieldNaziv.setText((String)(new AbstractTableNepolozeni().getValueAt(NepolozeniJTable.getInstance().convertRowIndexToModel(NepolozeniJTable.getInstance().getSelectedRow()), 1)));
		fieldNaziv.setEnabled(false);
		naziv.add(labNaziv);
		naziv.add(fieldNaziv);
		
		Integer ocene[] = { 6,7,8,9,10 };
		JPanel ocena = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JLabel labOcena = new JLabel("Ocena*");
		labOcena.setPreferredSize(preferredDim);
		comboOcena = new JComboBox<Integer>(ocene);
		comboOcena.setPreferredSize(preferredDim);
		comboOcena.setSelectedIndex(0);
		comboOcena.setName("Ocena");
		ocena.add(labOcena);
		ocena.add(comboOcena);
		
		JPanel datum = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JLabel labDatum = new JLabel("Datum*");
		labDatum.setPreferredSize(preferredDim);
		fieldDatum = new JTextField();
		fieldDatum.setPreferredSize(preferredDim);
		
		datum.add(labDatum);
		datum.add(fieldDatum);

		JPanel central = new JPanel();
		central.setBorder(BorderFactory.createEmptyBorder(30, 0, 0, 0));
		central.setLayout(new BoxLayout(central, BoxLayout.Y_AXIS));

		central.add(sifra);
		central.add(naziv);
		central.add(ocena);
		central.add(datum);

		add(central, BorderLayout.NORTH);

		ok = new Button("Potvrdi");
		ok.setPreferredSize(buttonDim);
		ok.setEnabled(false);
		ok.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				StudentControler.getInstance().upisOcene();
				PonistavanjeOcjeneDialog.izmjeniLabele();
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
		
		fieldDatum.addKeyListener(new KeyListener() {

			@Override
			public void keyPressed(KeyEvent arg0) {
				if (Pattern.matches("[0-9]{1,2}.[0-9]{1,2}.[0-9]{4}.", fieldDatum.getText())) {
					ok.setEnabled(true);
				}
			}

			@Override
			public void keyReleased(KeyEvent arg0) {
				if (Pattern.matches("[0-9]{1,2}.[0-9]{1,2}.[0-9]{4}.", fieldDatum.getText())) {
					ok.setEnabled(true);
				}
				
			}

			@Override
			public void keyTyped(KeyEvent arg0) {
				if (Pattern.matches("[0-9]{1,2}.[0-9]{1,2}.[0-9]{4}.", fieldDatum.getText())) {
					ok.setEnabled(true);
				}
				
			}
			
		});

		JPanel bottom = new JPanel(new FlowLayout());
		bottom.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));
		bottom.setBackground(Color.decode("#cfcaca"));
		bottom.add(ok);
		bottom.add(Box.createRigidArea(new Dimension(30, 0)));
		bottom.add(cancel);

		add(bottom, BorderLayout.SOUTH);
		
		

	}

	public static JTextField getFieldSifra() {
		return fieldSifra;
	}

	public static void setFieldSifra(JTextField fieldSifra) {
		UpisOceneDialog.fieldSifra = fieldSifra;
	}

	public static JTextField getFieldNaziv() {
		return fieldNaziv;
	}

	public static void setFieldNaziv(JTextField fieldNaziv) {
		UpisOceneDialog.fieldNaziv = fieldNaziv;
	}

	public static JComboBox<Integer> getComboOcena() {
		return comboOcena;
	}

	public static void setComboOcena(JComboBox<Integer> comboOcena) {
		UpisOceneDialog.comboOcena = comboOcena;
	}

	public static JTextField getFieldDatum() {
		return fieldDatum;
	}

	public static void setFieldDatum(JTextField fieldDatum) {
		UpisOceneDialog.fieldDatum = fieldDatum;
	}

	public static Button getOk() {
		return ok;
	}

	public static void setOk(Button ok) {
		UpisOceneDialog.ok = ok;
	}

	public static Button getCancel() {
		return cancel;
	}

	public static void setCancel(Button cancel) {
		UpisOceneDialog.cancel = cancel;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	

}
