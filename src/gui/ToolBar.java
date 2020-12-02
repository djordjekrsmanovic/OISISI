package gui;
import java.awt.Dimension;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JToolBar;

public class ToolBar extends JToolBar {

	private static final long serialVersionUID = 1L;
	
	public ToolBar () {
		ImageIcon imageIcon = new ImageIcon("images_project/add_icon.png");
		JButton createEntityButton = new JButton(imageIcon);
		createEntityButton.setToolTipText("Dijalog za kreiranje studenta, profesora ili predmeta.");
		this.add(createEntityButton);
		
		imageIcon = new ImageIcon("images_project/edit_icon.png");
		JButton editEntityButton = new JButton(imageIcon);
		editEntityButton.setToolTipText("Dijalog za izmenu studenta, profesora ili predmeta.");
		this.add(editEntityButton);
	
		imageIcon = new ImageIcon("images_project/delete_icon.png");
		JButton deleteEntityButton = new JButton(imageIcon);
		deleteEntityButton.setToolTipText("Dijalog za brisanje studenta, profesora ili predmeta.");
		this.add(deleteEntityButton);
		
		//add(Box.createRigidArea(new Dimension(1000,0))); //moglo se i ovako namestiti, zavisi sta preferiramo
		add(Box.createHorizontalGlue());
		
		JTextField searchTextField = new JTextField();
		searchTextField.setMaximumSize(new Dimension(10000, 50));
		this.add(searchTextField);
		
		imageIcon = new ImageIcon("images_project/search_icon.png");
		JButton searchButton = new JButton(imageIcon);
		this.add(searchButton);
	}
	
}
