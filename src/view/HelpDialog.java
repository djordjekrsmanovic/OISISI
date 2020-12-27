package view;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class HelpDialog extends JDialog {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6243786012852231728L;

	public HelpDialog() {
		setTitle("Help");
		setSize(500,400);
		setLocationRelativeTo(MainWindow.getInstance());
		setLayout(new BorderLayout(10,10));
		
		JLabel topLabel=new JLabel("Ovaj prozor treba da Vam pruzi sve informacije neophodne za korišćenje aplikacije",JLabel.CENTER);
		topLabel.setBounds(15, 15, 0, 0);
		add(topLabel,BorderLayout.NORTH);
		
		JTextArea txt=new JTextArea();
		txt.setEditable(false);
		
		txt.setSize(460,380);
		
		txt.setBorder(BorderFactory.createLineBorder(Color.black, 1));
		
		String opis=new String("Glavni prozor aplikacije se sastoji od:\n"
				+ "Menu Bar koga čine stavke:\n"
				+ " 1.File\n  a)New- dodavanje novog entiteta\n  b)Close- zatvaranje aplikacije\n"
				+ " 2.Edit\n"
				+ "  a)Edit- izmjena postojećeg entiteta\n  b)Delete- brisanje postojećeg entiteta\n"
				+ " 3.Help\n  a)Help-ova sekcija sadrži vodič za korišćenje aplikacije\n  b)About-prikazuje verziju aplikacije i kratak opis autora\n\n"
				+ "ToolBar\n"
				+ "  Prvo dugme služi za otvraranje dijaloga za stvaranje novog entiteta,\n"
				+ "  dok drugo dugme otvara dijalog za izmjenu označenog entiteta.\n"
				+ "  Treće dugme briše označeni entitet.\n"
				+ "  Dugme za pretragu služi za pretraživanje entiteta\n"
				+ "Centralni dio panela\n "
				+ "  Služi za prikaz tabele entiteta\n"
				+ "Status bar\n"
				+ "  Prikazuje naziv aplikacije,vrijeme i datum\n"
				+ "Prečice:\n"
				+ " CTRL-N dodavanje novog entiteta\n"
				+ " CTRL-C zatvaranje prozora\n"
				+ " CTRL-E izmjena entiteta\n"
				+ " CTRL-D brisanje entiteta\n"
				+ " CTRL-H otvaranje help dijaloga\n"
				+ " CTRL-A otvaranje about dijaloga\n"
				+ "Mnemonici:\n"
				+ " ALT-F otvara karticu File u meni baru\n"
				+ " ALT-E otvara karticu Edit u meni baru\n"
				+ " ALT-H otvara karticu Help u meni baru\n\n"
				+ "OPIS OSTALIH FUNKCIONALNOSTI ĆE BITI NAKNADNO DODAT!!!");
		
		txt.setText(opis);
		txt.setCaretPosition(0);
		
		JScrollPane scroll=new JScrollPane(txt);
		scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		add(scroll,BorderLayout.CENTER);
		
	}
}
