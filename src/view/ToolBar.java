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
	
	private JTextField searchTextField;

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

		editEntityButton.addMouseListener(new MouseListener() {

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
				if (GlobalController.getInstance().isSelected()) {
					GlobalController.getInstance().editEntity();
				}
			}
		});

		imageIcon = new ImageIcon("images_project" + File.separator + "delete_icon.png");
		JButton deleteEntityButton = new JButton(imageIcon);
		deleteEntityButton.setToolTipText("Dijalog za brisanje studenta, profesora ili predmeta.");
		this.add(deleteEntityButton);

		deleteEntityButton.addMouseListener(new MouseListener() {

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
				if (GlobalController.getInstance().isSelected()) {
					GlobalController.getInstance().showDeleteDialog();
				}
			}
		});

		add(Box.createHorizontalGlue());

		searchTextField = new JTextField();
		searchTextField.setMaximumSize(new Dimension(10000, 50));
		this.add(searchTextField);
		
		//Pre bih stavio ovo umesto dugmeta za pretragu.
		/*
		searchTextField.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent arg0) {
				BazaProfesora.getInstance().filterProfesori();
				ProfessorJTable.getInstance().azuriraj();

				BazaPredmeta.getInstance().filterPredmeti();
				PredmetJTable.getInstance().azuriraj();
				
				//TODO za studente
			}
			
			@Override
			public void keyReleased(KeyEvent arg0) {
				BazaProfesora.getInstance().filterProfesori();
				ProfessorJTable.getInstance().azuriraj();
				
				BazaPredmeta.getInstance().filterPredmeti();
				PredmetJTable.getInstance().azuriraj();
				
				//TODO za studente
			}
			
			@Override
			public void keyPressed(KeyEvent arg0) {
				BazaProfesora.getInstance().filterProfesori();
				ProfessorJTable.getInstance().azuriraj();
				
				BazaPredmeta.getInstance().filterPredmeti();
				PredmetJTable.getInstance().azuriraj();
				
				//TODO za studente
			}
		});
		
		*/

		imageIcon = new ImageIcon("images_project" + File.separator + "search_icon.png");
		JButton searchButton = new JButton(imageIcon);
		this.add(searchButton);
		searchButton.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent arg0) {
				ProfessorJTable.getInstance().pretraga(searchTextField.getText());
				PredmetJTable.getInstance().pretraga(searchTextField.getText());
				StudentJTable.getInstance().pretraga(searchTextField.getText());
			}
		});
	}

	public static ToolBar getInstance() {
		if (instance == null) {
			instance = new ToolBar();
		}
		return instance;
	}

	public JTextField getSearchTextField() {
		return searchTextField;
	}
	
	

}
