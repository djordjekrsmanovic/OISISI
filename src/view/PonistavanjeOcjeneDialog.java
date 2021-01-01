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
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.StudentControler;
import model.BazaStudenata;

public class PonistavanjeOcjeneDialog extends JDialog {
	private static final long serialVersionUID = -546312521578716394L;

	public PonistavanjeOcjeneDialog(EditStudentDialog parent) {
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension d = kit.getScreenSize();
		Dimension buttonDim = new Dimension(37, 25);
		setSize(d.width / 4, d.height / 6);
		setModal(true);
		this.setResizable(false);
		setTitle("Poništavanje ocene");
		setLocationRelativeTo(parent);
		setLayout(new BorderLayout());

		JPanel central = new JPanel();
		JLabel txt = new JLabel();
		txt.setText("Da li ste sigurni da želite da poništite ocenu?");
		central.add(txt);
		central.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));

		JPanel down = new JPanel();
		Button ok = new Button("Da");
		ok.setPreferredSize(buttonDim);
		ok.setBackground(Color.decode("#bfbcbb"));
		ok.setFocusable(false);
		ok.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				    StudentControler.getInstance().ponistiOcjenu(OsnovneInformacijaTab.getStudent().getBrojIndeksa());
					float prosjek=BazaStudenata.getInstance().getProsjek(OsnovneInformacijaTab.getStudent().getBrojIndeksa()); //racunanje prosjeka kako bi se ipisao
					String prosjekTxt=String.format("Prosečna ocena: %.2f",prosjek );
					
					PolozeniTab.getProsjekLbl().setText(prosjekTxt);
					int espb=BazaStudenata.getInstance().getESPB(OsnovneInformacijaTab.getStudent().getBrojIndeksa()); //racunanje broja espb bodova
					String espbTxt=String.format("Ukupno ESPB: %d", espb);
					PolozeniTab.getPonistiOcjenu().setBackground(Color.decode("#86b4e3"));
					
					PolozeniTab.getEspbLbl().setText(espbTxt);
					validate();
					dispose();

			}
		});

		Button cancel = new Button("Ne");
		cancel.setPreferredSize(buttonDim);
		cancel.setBackground(Color.decode("#bfbcbb"));
		cancel.setFocusable(false);
		cancel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				dispose();

			}

		});
		down.add(ok);
		down.add(Box.createRigidArea(new Dimension(30, 0)));
		down.add(cancel);
		down.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		this.add(central, BorderLayout.CENTER);
		this.add(down, BorderLayout.SOUTH);

	}

}