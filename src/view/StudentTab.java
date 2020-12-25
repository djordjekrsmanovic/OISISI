package view;

import java.awt.BorderLayout;
import java.awt.Dimension;


import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;


public class StudentTab extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3961695640286811252L;
	private static StudentTab instance=null;
	public static StudentTab getInstance() {
		if (instance==null) {
			instance=new StudentTab();
		}
		return instance;
		
	}
	
	private StudentTab(){
		this.setLayout(new BorderLayout());
		StudentJTable tabelaStudenata=StudentJTable.getInstance();
		JScrollPane scrollPane=new JScrollPane(tabelaStudenata);
		scrollPane.setPreferredSize(new Dimension(800,400));
		scrollPane.setBorder(BorderFactory.createEmptyBorder(50, 50, 30, 80));
		add(scrollPane,BorderLayout.CENTER);
	}
}
