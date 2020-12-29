package view;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class PolozeniTab extends JPanel{
	
	
	PolozeniTab(){
//		Dimension d=Toolkit.getDefaultToolkit().getScreenSize();
//		this.setSize(d.width*3/8,(d.height*3/4)*97/100);;
//		Dimension preferredDim=new Dimension(200,20);
		Dimension buttonDim=new Dimension(125,25);
		this.setLayout(new BorderLayout());
		OcenaJTable tabelaOcena=OcenaJTable.getInstance();
		JScrollPane scrollPane=new JScrollPane(tabelaOcena);
		scrollPane.setBorder(BorderFactory.createEmptyBorder(10,20,10,20));
		Button ponistiOcjenu=new Button("Poništi ocjenu");
		ponistiOcjenu.setPreferredSize(buttonDim);
		ponistiOcjenu.setBackground(Color.decode("#86b4e3"));
		JPanel top=new JPanel(new BorderLayout());
		top.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		top.add(ponistiOcjenu,BorderLayout.WEST);
		add(scrollPane,BorderLayout.CENTER);
		JPanel bottom=new JPanel();
		JLabel prosjek=new JLabel("Prosečna ocena: 10");
		JLabel espb=new JLabel("Ukupno ESPB: 60");
		JPanel informacije=new JPanel();
		informacije.setLayout(new BoxLayout(informacije, BoxLayout.Y_AXIS));
		informacije.add(prosjek);
		informacije.add(Box.createRigidArea(new Dimension(0,10)));
		informacije.add(espb);
		bottom.setLayout(new BorderLayout());
		bottom.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
		bottom.add(informacije,BorderLayout.EAST);
		this.add(bottom,BorderLayout.SOUTH);
		this.add(top,BorderLayout.NORTH);
		this.add(scrollPane,BorderLayout.CENTER);
	}
}
