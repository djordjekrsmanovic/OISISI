package view;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.table.TableRowSorter;

import model.BazaStudenata;

public class PolozeniTab extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8466933127613604835L;
	private static JLabel prosjekLbl;
	private static JLabel espbLbl;

	public PolozeniTab() {

		// pravljenje grafickih komponenti
		Dimension buttonDim = new Dimension(125, 25);
		this.setLayout(new BorderLayout());
		OcenaJTable tabelaOcena = OcenaJTable.getInstance();
		JScrollPane scrollPane = new JScrollPane(tabelaOcena);
		scrollPane.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
		Button ponistiOcjenu = new Button("Poništi ocjenu");
		ponistiOcjenu.setPreferredSize(buttonDim);
		ponistiOcjenu.setBackground(Color.decode("#86b4e3"));
		JPanel top = new JPanel(new BorderLayout());
		top.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		top.add(ponistiOcjenu, BorderLayout.WEST);
		add(scrollPane, BorderLayout.CENTER);
		JPanel bottom = new JPanel();
		float prosjek = BazaStudenata.getInstance().getProsjek(OsnovneInformacijaTab.getStudent().getBrojIndeksa()); // racunanje
																														// prosjeka
																														// kako
																														// bi
																														// se
																														// ipisao
		String prosjekTxt = String.format("Prosečna ocena: %.2f", prosjek);
		prosjekLbl = new JLabel(prosjekTxt);
		int espb = BazaStudenata.getInstance().getESPB(OsnovneInformacijaTab.getStudent().getBrojIndeksa()); // racunanje
																												// broja
																												// espb
																												// bodova
		String espbTxt = String.format("Ukupno ESPB: %d", espb);
		espbLbl = new JLabel(espbTxt);
		JPanel informacije = new JPanel();
		informacije.setLayout(new BoxLayout(informacije, BoxLayout.Y_AXIS));
		informacije.add(prosjekLbl);
		informacije.add(Box.createRigidArea(new Dimension(0, 10)));
		informacije.add(espbLbl);
		bottom.setLayout(new BorderLayout());
		bottom.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		bottom.add(informacije, BorderLayout.EAST);
		this.add(bottom, BorderLayout.SOUTH);
		this.add(top, BorderLayout.NORTH);
		this.add(scrollPane, BorderLayout.CENTER);

		OcenaJTable.getInstance().setRowSorter(new TableRowSorter<AbstractTableOcena>(new AbstractTableOcena())); // pri
																													// otvaranju
																													// taba
																													// postavlja
																													// se
																													// sorter
																													// zbog
																													// toga
																													// sto
																													// tabela
																													// nema
																													// uvijek
																													// isti
																													// broj
																													// kolona
		ponistiOcjenu.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				if (OcenaJTable.getInstance().getSelectedRow() != -1) {
					PonistavanjeOcjeneDialog p = new PonistavanjeOcjeneDialog(EditStudentDialog.getInstance());
					p.setVisible(true);
				} else {
					JOptionPane.showMessageDialog(null, "Morate da selektujete predmet");
				}

			}

		});

	}

	public static JLabel getProsjekLbl() {
		return prosjekLbl;
	}

	public static void setProsjekLbl(JLabel prosjekLbl) {
		PolozeniTab.prosjekLbl = prosjekLbl;
	}

	public static JLabel getEspbLbl() {
		return espbLbl;
	}

	public static void setEspbLbl(JLabel espbLbl) {
		PolozeniTab.espbLbl = espbLbl;
	}
}
