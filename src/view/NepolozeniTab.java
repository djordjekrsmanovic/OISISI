package view;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class NepolozeniTab extends JPanel {

	private static final long serialVersionUID = -2816418824194939975L;
	private static Button obrisi;
	private static Button dodaj;

	NepolozeniTab() {
		NepolozeniJTable.getInstance().azuriraj();
		Dimension buttonDim = new Dimension(125, 25);
		this.setLayout(new BorderLayout());
		NepolozeniJTable tabelaOcena = NepolozeniJTable.getInstance();
		JScrollPane scrollPane = new JScrollPane(tabelaOcena);
		scrollPane.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));

		dodaj = new Button("Dodaj");
		dodaj.setPreferredSize(buttonDim);
		dodaj.setBackground(Color.decode("#86b4e3"));

		dodaj.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				dodaj.setBackground(Color.decode("#ed3241"));
				DodavanjePredmetaStudentu dps = new DodavanjePredmetaStudentu(
						OsnovneInformacijaTab.getStudent().getBrojIndeksa());
				dps.setVisible(true);
			}
		});

		obrisi = new Button("Obriši");
		obrisi.setPreferredSize(buttonDim);
		obrisi.setBackground(Color.decode("#86b4e3"));

		Button polaganje = new Button("Polaganje");
		polaganje.setPreferredSize(buttonDim);
		polaganje.setBackground(Color.decode("#86b4e3"));
		polaganje.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent arg0) {
			}

			@Override
			public void mousePressed(MouseEvent arg0) {
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
			}

			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (NepolozeniJTable.getInstance().getSelectedRow() == -1) {
					JOptionPane.showMessageDialog(null, "Nije selektovan ispit.");
					return;
				}
				UpisOceneDialog uod = new UpisOceneDialog();
				uod.setVisible(true);
			}
		});

		obrisi.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (NepolozeniJTable.getInstance().getSelectedRow() != -1) {
					obrisi.setBackground(Color.decode("#ed3241"));
					UklanjanjePredmetaDialog upd = new UklanjanjePredmetaDialog(EditStudentDialog.getInstance());
					upd.setVisible(true);
				} else {
					JOptionPane.showMessageDialog(null, "Potrebno je da označite predmet u tabeli");
				}
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

		});

		JPanel top = new JPanel(new FlowLayout(FlowLayout.LEFT));
		top.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		top.add(dodaj, BorderLayout.WEST);
		top.add(obrisi, BorderLayout.WEST);
		top.add(polaganje, BorderLayout.WEST);

		add(scrollPane, BorderLayout.CENTER);

		this.add(top, BorderLayout.NORTH);
		this.add(scrollPane, BorderLayout.CENTER);
	}

	public static Button getObrisi() {
		return obrisi;
	}

	public static void setObrisi(Button obrisi) {
		NepolozeniTab.obrisi = obrisi;
	}

	public static Button getDodaj() {
		return dodaj;
	}

	public static void setDodaj(Button dodaj) {
		NepolozeniTab.dodaj = dodaj;
	}

}
