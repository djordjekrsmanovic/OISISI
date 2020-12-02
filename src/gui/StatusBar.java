package gui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

public class StatusBar extends JPanel {

	private static final long serialVersionUID = -7960319300551657388L;

	public StatusBar() {
	super();
	setLayout(new BorderLayout());


	
    JLabel labelTitle = new JLabel("Studentska služba");
    labelTitle.setBorder(BorderFactory.createEmptyBorder(0,5,0,0));
    Date initialDate = new Date();
    
    SimpleDateFormat formatter = new SimpleDateFormat("HH:mm  dd.MM.yyyy");
    JLabel time = new JLabel(formatter.format(initialDate));
    time.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 20));
    
    /** REFERENCA:https://www.youtube.com/watch?v=9gxeDtbeX0c&ab_channel=JobMETechSolutions*/
    Timer timer = new Timer(1000,new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			Date date=new Date();                          //DOLAZI DO MIJENJANJA DATUMA SVAKE SEKUNDE I TO SE ISPISUJE U LABELU
			time.setText(formatter.format(date));
		}
    	
    });
    
    timer.start();
    
    
	
	this.add(labelTitle, BorderLayout.WEST);
	this.add(time, BorderLayout.EAST);
	

	
	}
}
