package view;

import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JToolBar;

import controller.GlobalController;

public class ToolBar extends JToolBar {

	private static final long serialVersionUID = 1L;

	private static ToolBar instance = null;

	public ToolBar() {
		ImageIcon imageIcon = new ImageIcon("images_project" + File.separator + "add_icon.png");
		JButton createEntityButton = new JButton(imageIcon);
		createEntityButton.setToolTipText("Dijalog za kreiranje studenta, profesora ili predmeta.");
		this.add(createEntityButton);

		createEntityButton.addMouseListener(new MouseListener() {

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
				GlobalController.getInstance().addEntity();
			}
		});

		imageIcon = new ImageIcon("images_project" + File.separator + "edit_icon.png");
		JButton editEntityButton = new JButton(imageIcon);
		editEntityButton.setToolTipText("Dijalog za izmenu studenta, profesora ili predmeta.");
		this.add(editEntityButton);

		imageIcon = new ImageIcon("images_project" + File.separator + "delete_icon.png");
		JButton deleteEntityButton = new JButton(imageIcon);
		deleteEntityButton.setToolTipText("Dijalog za brisanje studenta, profesora ili predmeta.");
		this.add(deleteEntityButton);

		add(Box.createHorizontalGlue());

		JTextField searchTextField = new JTextField();
		searchTextField.setMaximumSize(new Dimension(10000, 50));
		this.add(searchTextField);

		imageIcon = new ImageIcon("images_project" + File.separator + "search_icon.png");
		JButton searchButton = new JButton(imageIcon);
		this.add(searchButton);
	}

	public static ToolBar getInstance() {
		if (instance == null) {
			instance = new ToolBar();
		}
		return instance;
	}

}
