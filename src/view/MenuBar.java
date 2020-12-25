package view;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

import controller.GlobalController;

public class MenuBar extends JMenuBar {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2095136277753179215L;
	
	public MenuBar() {
		JMenu file=new JMenu("File");
		file.setMnemonic(KeyEvent.VK_F);
		JMenuItem newI=new JMenuItem("New");
		newI.setIcon(new ImageIcon("images_project/add_icon.png"));
		newI.setMnemonic(KeyEvent.VK_N);
		newI.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
		newI.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				GlobalController.getInstance().addEntity();
				
			}
		});
		
		
		JMenuItem close=new JMenuItem("Close");
		close.setIcon(new ImageIcon("images_project/close_icon.png"));
		close.setMnemonic(KeyEvent.VK_C);
		close.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C,ActionEvent.CTRL_MASK));
		
		file.add(newI);
		file.addSeparator();
		file.add(close);
		
		
		JMenu edit=new JMenu("Edit");
		edit.setMnemonic(KeyEvent.VK_E);
		
		JMenuItem editI=new JMenuItem("Edit");
		editI.setIcon(new ImageIcon("images_project/edit_icon.png"));
		editI.setMnemonic(KeyEvent.VK_E);
		editI.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, ActionEvent.CTRL_MASK));
		
		JMenuItem deleteI=new JMenuItem("Delete");
		deleteI.setIcon(new ImageIcon("images_project/delete_icon.png"));
		deleteI.setMnemonic(KeyEvent.VK_D);
		deleteI.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, ActionEvent.CTRL_MASK));
		
		edit.add(editI);
		edit.addSeparator();
		edit.add(deleteI);
		
		JMenu help=new JMenu("Help");
		help.setMnemonic(KeyEvent.VK_H);
		
		JMenuItem helpI=new JMenuItem("Help");
		helpI.setIcon(new ImageIcon("images_project/help_icon.png"));
		helpI.setMnemonic(KeyEvent.VK_H);
		helpI.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_H, ActionEvent.CTRL_MASK));
		helpI.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				HelpDialog hd=new HelpDialog();
				hd.setVisible(true);
			}
			
		});
		
		JMenuItem aboutI=new JMenuItem("About");
		aboutI.setIcon(new ImageIcon("images_project/about_icon.png"));
		aboutI.setMnemonic(KeyEvent.VK_A);
		aboutI.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, ActionEvent.CTRL_MASK));
		aboutI.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				AboutDialog ab=new AboutDialog();
				ab.setVisible(true);
			}
		});
		help.add(helpI);
		help.addSeparator();
		help.add(aboutI);
		
		add(file);
		add(edit);
		add(help);
		
		
	}
}
