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
		
		String opis=new String(
				"Po otvaranju programa otvara se glavni prozor na kome se nalaze tabele sa studentima, \r\n"
				+ "profesorima i predmetima. Klikom na zaglavlja tabele moguće je odabrati kriterijum sortiranja entiteta.\r\n"
				+ " Iz programa se izlazi uobičajenim klikom na dugme X u gornjem desnom uglu pri čemu se stanje sistema pamti.\n"
				+ "Glavni prozor aplikacije se sastoji od:\n"
				+ "Menu Bar koga čine stavke:\n"
				+ " 1.File\n  a)New- dodavanje novog entiteta\n  b)Close- zatvaranje aplikacije\n"
				+ " 2.Edit\n"
				+ "  a)Edit- izmjena postojećeg entiteta\n  b)Delete- brisanje postojećeg entiteta\n"
				+ " 3.Help\n  a)Help-ova sekcija sadrži vodič za korišćenje aplikacije\n  b)About-prikazuje verziju aplikacije i kratak opis autora\n\n"
				+ "ToolBar\n"
				+ "  Na toolbar-u nalazi se dugme za dodavanje, dugme za izmenu i dugme za brisanje entiteta (student, profesor ili predmet), \r\n"
				+ "  pri čemu se ona odnose na trenutno aktivan tab. U slučaju izmene i brisanja, \r\n"
				+ "  potrebno je selektovati željeni entitet iz tabele."
				+ "  Prvo dugme služi za otvraranje dijaloga za stvaranje novog entiteta,\n"
				+ "  dok drugo dugme otvara dijalog za izmjenu označenog entiteta.\n"
				+ "  Treće dugme briše označeni entitet.\n"
				+ "  Dugme za pretragu služi za pretraživanje entiteta\n"
				+ "  U desnom kraju toolbar-a nalazi se polje za pretragu u koje se unosi, \r\n"
				+ "	 za studente broj indeksa, prezime, pa ime; za profesore prezime pa ime;\r\n"
				+ "  za predmete ime predmeta (ili deo tih naziva, pri čemu je pretraga neosetljiva na mala i velika slova). \r\n"
				+ "  Klikom na dugme sa lupom vrši se pretraga (filtriranje) u tabelama."
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
				+ "Uzavistnosti u kom se tab-u nalazite pritiskom na dugme new na meni bar-u ili tool-bar otvara se dijalog za dodavanje novog entiteta\n"
				+ "Dodavanje studenta: \n"
			    + "Potrebno je sve informacije validno popuniti inače dugme potvrdi će biti blokirano\n"
				+ "Ime može da sadrži razmake.\n"
				+ "Prezime može da sadrži znak -\n"
				+ "Format datuma se moze vidjeti prelaskom miša preko naziva polja\n"
				+ "Format indeksa i broja telefona se može vidjeti prelaskom miša preko naziva polja\n"
				+ "Takođe i za dodavanje predmeta i profesora potrebno je sve informacije validno "
				+ "popuniti da bi se omogućio pritisak na dugme potvrdi \n"
				+ "Klikom na dugme edit na meni bar-u ili tool-bar-u otvara se dijalog za izmjenu entiteta.\n"
				+ "Prije svake izmjene potrebno je selektovati entitet koji je potrebno izmijeniti\n"
				+ "Da bi se omogucio pritisak na dugme potvrdi sva polja moraju biti validno popunjena\n"
				+ "Pri izmjeni predmeta može se dodati profesor na predmet. Pritiskom na dugme +\n"
				+ "predmetu se dodaje profesor.Pritiskom na dugme - profesoru se uklanja predmet.\n"
				+ "Kada predmet nema profesora dugme - je blokirano. Kada predmet ima profesora dugme + je blokirano.\n"
				+ "Klikom na dugme delete u menu-baru ili tool-baru vriši se brisanje entiteta\n"
				+ "u zavisnosti od taba u kom se korisnik nalazi. Nakon pritiska dugmeta za brisanje\n"
				+ "otvara se dijalog na kome je potrebno potvrditi da želite da izbrišete entitet.\n"
				+ "Brisanjem predmeta biće izbrisan i predmet iz liste nepoloženih predmeta\n"
				+ "iz predmeta koje profesori predaju.\n"
				+ "Brisanjem studenta vrši se brisanje studenta iz liste studenata koji slušaju određeni predmet\n"
				+ "Ukoliko profesor predaje odredjeni predmet njegovim brisanjem biće izbrisan i iz predmeta koji predaje\n"
				+ "Otvaranjem dijaloga za izmjenu studenata moguće je kliknuti na tab položeni i nepoloženi predmeti.\n"
				+ "Otvaranjem tab-a nepoloženi otvara se prikaz svih nepoloženih ispita.\n"
				+ "Iznad tabele nalazi se dugme za brisanje predmeta,polaganje predmeta i dodavanje novog predmeta.\n"
				+ "Pritiskom dugmeta za brisanje briše se predmet iz liste nepoloženih predmeta.\n"
				+ "Pritiskom dugmeta za polaganje otvara se dijalog u kom je potrebno unijeti\n"
				+ "datum polaganja i ocjenu. Predmet se prebacuje u položene predmete.\n"
				+ "Pritiskom dugmeta dodaj dodaje se predmet u listu nepoloženih predmeta\n"
				+ "Otvaranjem taba položeni prikazuju se svi položeni predmeti.\n"
				+ "Pritiskom dugmeta poništi ocjena se poništava i predmet se prebacuje\n"
				+ "u nepoložene predmete.\n"
				+ "Otvaranjem dijaloga za izmjenu profesora moguće je kliknuti na tab predmeti.\n"
				+ "Tu su prikazani svi predmeti koje profesor predaje\n"
				+ "Klikom na dugme dodaj predmet dodaje se predmet profesoru\n"
				+ "Klikom na dugme ukloni predmet brise se predmet profesoru\n"
		    	);
		
		txt.setText(opis);
		txt.setCaretPosition(0);

		JScrollPane scroll = new JScrollPane(txt);
		scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		add(scroll, BorderLayout.CENTER);

	}
}
