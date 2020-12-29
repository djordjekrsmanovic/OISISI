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
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.PredmetController;
import controller.ValidationSubject;
import listeners.EditSubjectListener;
import model.BazaPredmeta;
import model.Predmet;

public class EditSubjectDialog extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4481555156394650793L;

	private static JTextField fieldSifra;
	private static JTextField fieldNaziv;
	private static JTextField fieldESPB;
	private static Button ok;
	private static EditSubjectDialog instance = null;
	private static Predmet predmet = null;
	private static JComboBox<String> godinaCombo;
	private static JComboBox<String> comboSemestar;

	public static EditSubjectDialog getInstance() {
		if (instance == null) {
			instance = new EditSubjectDialog();
		}
		return instance;
	}

	public EditSubjectDialog() {
		setModal(true);
		setTitle("Dodavanje predmeta");
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		setSize(d.width * 3 / 8, (d.height * 3 / 4) * 80 / 100);
		setLayout(new BorderLayout());
		Dimension preferredDim = new Dimension(200, 25);
		Dimension buttonDim = new Dimension(70, 30);
		setResizable(false);
		setLocationRelativeTo(MainWindow.getInstance());

		int row = PredmetJTable.getInstance().convertRowIndexToModel(PredmetJTable.getInstance().getSelectedRow());
		predmet = BazaPredmeta.getInstance().getRow(row);

		JPanel sifra = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JLabel lblSifra = new JLabel("Šifra*");
		lblSifra.setPreferredSize(preferredDim);
		fieldSifra = new JTextField();
		fieldSifra.setPreferredSize(preferredDim);
		fieldSifra.setText(predmet.getSifra());
		sifra.add(lblSifra);
		sifra.add(fieldSifra);

		JPanel naziv = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JLabel lblNaziv = new JLabel("Naziv predmeta*");
		lblNaziv.setPreferredSize(preferredDim);
		fieldNaziv = new JTextField();
		fieldNaziv.setPreferredSize(preferredDim);
		fieldNaziv.setText(predmet.getNaziv());
		naziv.add(lblNaziv);
		naziv.add(fieldNaziv);

		int indeksSemestra = 0;
		if (predmet.getSemestar() == Predmet.Semestar.ZIMSKI) {
			indeksSemestra = 1;
		}
		JPanel panSemestar = new JPanel(new FlowLayout(FlowLayout.CENTER));
		String semestar[] = { "Ljetnji", "Zimski" };
		comboSemestar = new JComboBox<String>(semestar);
		comboSemestar.setPreferredSize(preferredDim);
		comboSemestar.setSelectedIndex(indeksSemestra);
		JLabel lblSemestar = new JLabel("Semestar*");
		lblSemestar.setToolTipText("Semestar u kom se predmet izvodi");
		lblSemestar.setPreferredSize(preferredDim);
		panSemestar.add(lblSemestar);
		panSemestar.add(comboSemestar);

		String godina[] = { "I (prva)", "II (druga)", "III (treća)", "IV (četvrta)" };
		godinaCombo = new JComboBox<String>(godina);
		godinaCombo.setPreferredSize(preferredDim);
		godinaCombo.setSelectedIndex(predmet.getGodinaStudija() - 1);
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
		fieldESPB.setText(Integer.toString(predmet.getEspb()));
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

		fieldSifra.addFocusListener(new EditSubjectListener(fieldSifra, 0));
		fieldNaziv.addFocusListener(new EditSubjectListener(fieldNaziv, 1));
		fieldESPB.addFocusListener(new EditSubjectListener(fieldESPB, 2));

		ok = new Button("Potvrdi");
		ok.setPreferredSize(buttonDim);
		ok.setEnabled(true);
		ok.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				ok.setEnabled(true);
				ValidationSubject.getInstance().setLogickeVirjednost();
				ValidationSubject.getInstance().setLogickeVrijednostEdit();
				PredmetController.getInstance().editPredmet();
				dispose();

			}
		});
		Button cancel = new Button("Odustani");
		cancel.setPreferredSize(buttonDim);
		cancel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				ValidationSubject.getInstance().setLogickeVirjednost();
				ValidationSubject.getInstance().setLogickeVrijednostEdit();
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
		this.addWindowListener(new WindowListener() {

			@Override
			public void windowActivated(WindowEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void windowClosed(WindowEvent arg0) {

			}

			@Override
			public void windowClosing(WindowEvent arg0) { // ukoliko se zatvori prozor na X potrebno je postaviti
															// logicke vrijednosti
				// TODO Auto-generated method stub
				EditSubjectDialog.setInstance();

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

	private static void setInstance() {
		instance = null;

	}

	public static Button getOk() {
		return ok;
	}

	public static void setOk(Button ok) {
		EditSubjectDialog.ok = ok;
	}

	public static JTextField getFieldSifra() {
		return fieldSifra;
	}

	public static void setFieldSifra(JTextField fieldSifra) {
		EditSubjectDialog.fieldSifra = fieldSifra;
	}

	public static JTextField getFieldNaziv() {
		return fieldNaziv;
	}

	public static void setFieldNaziv(JTextField fieldNaziv) {
		EditSubjectDialog.fieldNaziv = fieldNaziv;
	}

	public static JTextField getFieldESPB() {
		return fieldESPB;
	}

	public static void setFieldESPB(JTextField fieldESPB) {
		EditSubjectDialog.fieldESPB = fieldESPB;
	}

	public static Predmet getPredmet() {
		return predmet;
	}

	public static void setPredmet(Predmet predmet) {
		EditSubjectDialog.predmet = predmet;
	}

	public static JComboBox<String> getGodinaCombo() {
		return godinaCombo;
	}

	public static void setGodinaCombo(JComboBox<String> godinaCombo) {
		EditSubjectDialog.godinaCombo = godinaCombo;
	}

	public static JComboBox<String> getComboSemestar() {
		return comboSemestar;
	}

	public static void setComboSemestar(JComboBox<String> comboSemestar) {
		EditSubjectDialog.comboSemestar = comboSemestar;
	}
	

}
