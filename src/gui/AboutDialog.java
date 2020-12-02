package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;

public class AboutDialog extends JDialog {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4147155878851661385L;

	public AboutDialog() {
				setModal(true);
				setTitle("About");
				setSize(500,400);
				setLayout(new BorderLayout(10,10));
				setResizable(false);
				setLocationRelativeTo(MainWindow.getInstance());
				setBackground(Color.LIGHT_GRAY);

				JTextArea opis=new JTextArea("Studentska sluzba verzija 1 \nNamjena aplikacije je da omoguci"
						+ " operacije nad studentima,profesorima i predmetima.Koriste se tabele za unos studenata"
						+ "i operacije za unos,brisanje,sortiranje i prikazivanje pojedinosti o studentima");
				opis.setEditable(false);
				opis.setSize(100,100);
				opis.setLineWrap(true);
				opis.setFont(new Font("Arial", Font.PLAIN, 13));
				opis.setBackground(Color.LIGHT_GRAY);
				opis.setBorder(new LineBorder(Color.BLACK,3));
				add(opis,BorderLayout.NORTH);
				
				JLabel ucesnici=new JLabel("Učesnici u izradi projekta",JLabel.CENTER);
				ucesnici.setFont(new Font("SERIF",Font.BOLD,15));
				
				JPanel bottom=new JPanel(new BorderLayout(10,10));
				
				JTextArea opisDj=new JTextArea("Student 1: Djordje Krsmanović RA71/2018\n"
						+ "Rodjen u Foči. Zavrsio gimnaziju kao odličan učenik. Trenutno je student 3. godine"
						+ "Fakulteta tehnickih nauka. Stipendista kompanije EnergySavingGroup.");
				opisDj.setLineWrap(true);
				opisDj.setSize(240,160);
				opisDj.setEditable(false);
				opisDj.setBorder(new CompoundBorder(new LineBorder(Color.BLACK,1),new LineBorder(Color.GRAY,2)));
				JTextArea opisN=new JTextArea("Student 2: Nikola Jovisic RA74/2018\n"
						+ "Rodjen u Somboru. Završio srednju medicinsku školu kao odličan učenik. "
						+ "Student 3. godine Fakulteta tehničkih nauka u Novom Sadu. Stipendista kompanije Schneider Electric."
						+ "Veliki zaljubljenik u čitanje kapitalnih dijela svjetske književnosti.");
				
				opisN.setLineWrap(true);
				opisN.setSize(240,160);
				opisN.setEditable(false);
				opisN.setBorder(new CompoundBorder(new LineBorder(Color.BLACK,1),new LineBorder(Color.GRAY,2)));
				bottom.add(ucesnici,BorderLayout.NORTH);
				bottom.add(opisDj,BorderLayout.WEST);
				bottom.add(opisN,BorderLayout.EAST);
				
				add(bottom,BorderLayout.CENTER);
				validate();
		
		
	}
}
