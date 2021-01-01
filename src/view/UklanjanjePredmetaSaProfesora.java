package view;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.ProfessorController;

public class UklanjanjePredmetaSaProfesora extends JDialog {
	private static final long serialVersionUID = -546312521578716394L;

	public UklanjanjePredmetaSaProfesora(EditProfessorDialog parent) {
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension d = kit.getScreenSize();
		Dimension buttonDim = new Dimension(70, 30);
		setSize(d.width / 4, d.height / 6);
		setModal(true);
		this.setResizable(false);
		setTitle("Ukloni predmet");
		setLocationRelativeTo(parent);
		setLayout(new BorderLayout());

		JPanel central = new JPanel();
		JLabel txt = new JLabel();
		txt.setText("Da li ste sigurni?");
		central.add(txt);
		central.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));

		JPanel down = new JPanel();
		Button ok = new Button("Potvrdi");
		ok.setPreferredSize(buttonDim);
		ok.setBackground(Color.decode("#bfbcbb"));
		ok.setFocusable(false);
		ok.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				ProfessorController.getInstance()
						.ukloniPredmet(EditProfessorDialogInformacije.getFieldBrLK().getText().trim());

				EditProfessorDialogPredmeti.getUkloni().setBackground(Color.decode("#86b4e3"));
				validate();
				dispose();

			}
		});

		Button cancel = new Button("Odustani");
		cancel.setPreferredSize(buttonDim);
		cancel.setBackground(Color.decode("#bfbcbb"));
		cancel.setFocusable(false);
		cancel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				EditProfessorDialogPredmeti.getUkloni().setBackground(Color.decode("#86b4e3"));
				dispose();

			}

		});
		down.add(ok);
		down.add(Box.createRigidArea(new Dimension(30, 0)));
		down.add(cancel);
		down.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		this.add(central, BorderLayout.CENTER);
		this.add(down, BorderLayout.SOUTH);
		this.addWindowListener(new WindowListener() {

			@Override
			public void windowOpened(WindowEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void windowIconified(WindowEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void windowDeiconified(WindowEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void windowDeactivated(WindowEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void windowClosing(WindowEvent arg0) {
				// TODO Auto-generated method stub
				EditProfessorDialogPredmeti.getUkloni().setBackground(Color.decode("#86b4e3"));

			}

			@Override
			public void windowClosed(WindowEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void windowActivated(WindowEvent arg0) {
				// TODO Auto-generated method stub

			}
		});

	}

}