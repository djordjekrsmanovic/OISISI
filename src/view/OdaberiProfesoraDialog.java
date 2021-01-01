package view;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.DefaultListModel;
import javax.swing.JDialog;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

import model.BazaProfesora;
import model.Profesor;

public class OdaberiProfesoraDialog extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6967161049751906600L;

	private static JList<String> list;

	OdaberiProfesoraDialog() {
		setModal(true);
		setTitle("Odaberi profesora");
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		setSize(d.width * 3 / 8 * 80 / 100, (d.height * 3 / 4) * 60 / 100);
		Dimension buttonDim = new Dimension(50, 20);
		DefaultListModel<String> listaIspis = new DefaultListModel<>();
		setLocationRelativeTo(EditSubjectDialog.getInstance());

		for (Profesor p : BazaProfesora.getInstance().getProfesori()) {
			String naziv = p.getIme() + "  " + p.getPrezime();
			listaIspis.addElement(naziv);
		}
		list = new JList<>(listaIspis);
		list.setFixedCellWidth(this.getWidth() * 3 / 4);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.setBorder(BorderFactory.createLineBorder(Color.black));
		JScrollPane scroll = new JScrollPane(list);
		JPanel centar = new JPanel();
		centar.setLayout(new BorderLayout());
		centar.add(scroll, BorderLayout.CENTER);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		centar.setBorder(BorderFactory.createEmptyBorder(20, 30, 20, 30));

		JPanel bottom = new JPanel();
		bottom.setBorder(BorderFactory.createEmptyBorder(0, 30, 20, 30));
		Button potvrdi = new Button("Potvrdi");
		if (BazaProfesora.getInstance().getProfesori().isEmpty()) {
			potvrdi.setEnabled(false);
		}
		potvrdi.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				Profesor p = BazaProfesora.getInstance().getProfesori()
						.get(OdaberiProfesoraDialog.getList().getSelectedIndex());
				EditSubjectDialog.getPredmet().setProfesor(p);
				String imePrezime = p.getIme() + "  " + p.getPrezime();
				EditSubjectDialog.getFieldProfesor().setText(imePrezime);
				EditSubjectDialog.getPlus().setEnabled(false);
				EditSubjectDialog.setFlag(false);
				dispose();
			}
		});
		Button odustani = new Button("Odustani");
		odustani.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub

				dispose();

			}

		});
		potvrdi.setSize(buttonDim);
		odustani.setSize(buttonDim);
		bottom.add(potvrdi);
		bottom.add(Box.createRigidArea(new Dimension(30, 0)));
		bottom.add(odustani);
		this.add(centar, BorderLayout.CENTER);
		this.add(bottom, BorderLayout.SOUTH);

	}

	public static JList<String> getList() {
		return list;
	}

	public static void setList(JList<String> list) {
		OdaberiProfesoraDialog.list = list;
	}

}
