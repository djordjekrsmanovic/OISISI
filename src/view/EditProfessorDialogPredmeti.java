package view;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class EditProfessorDialogPredmeti extends JPanel{

	private static final long serialVersionUID = -1185428626558966587L;
	
	EditProfessorDialogPredmeti() {
		
		ProfPredJTable.getInstance().azuriraj();
		Dimension buttonDim = new Dimension(125, 25);
		this.setLayout(new BorderLayout());
		ProfPredJTable tabelaPredmeta = ProfPredJTable.getInstance();
		JScrollPane scrollPane = new JScrollPane(tabelaPredmeta);
		scrollPane.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
		
		Button dodaj = new Button("Dodaj predmet");
		dodaj.setPreferredSize(buttonDim);
		dodaj.setBackground(Color.decode("#86b4e3"));
		dodaj.addMouseListener(new MouseListener() {
			
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
				DodajPredmetProfesoruDialog dppd = new DodajPredmetProfesoruDialog();
				dppd.setVisible(true);
				
			}
		});
		
		Button ukloni = new Button("Ukloni predmet");
		ukloni.setPreferredSize(buttonDim);
		ukloni.setBackground(Color.decode("#86b4e3"));
		
		
		JPanel top = new JPanel(new FlowLayout(FlowLayout.LEFT));
		top.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		top.add(dodaj, BorderLayout.WEST);
		top.add(ukloni, BorderLayout.WEST);
		
		add(scrollPane, BorderLayout.CENTER);
		
		this.add(top, BorderLayout.NORTH);
		this.add(scrollPane, BorderLayout.CENTER);
	}
}
