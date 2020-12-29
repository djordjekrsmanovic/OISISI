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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.GlobalController;

public class DeleteProfessorDialog extends JDialog {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8148405672169662426L;

	public DeleteProfessorDialog(JFrame parent) {
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension d = kit.getScreenSize();
		Dimension buttonDim = new Dimension(37, 25);
		setSize(d.width / 4, d.height / 6);
		setModal(true);
		this.setResizable(false);
		setTitle("Brisanje Studenta");
		setLocationRelativeTo(parent);
		setLayout(new BorderLayout());

		JPanel central = new JPanel();
		JLabel txt = new JLabel();
		txt.setText("Da li ste sigurni da želite da obrišete profesora?");
		central.add(txt);
		central.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));

		JPanel down = new JPanel();
		Button ok = new Button("DA");
		ok.setPreferredSize(buttonDim);
		ok.setBackground(Color.decode("#bfbcbb"));
		ok.setFocusable(false);
		ok.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				GlobalController.getInstance().deleteEntity();
				dispose();

			}
		});

		Button cancel = new Button("NE");
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
