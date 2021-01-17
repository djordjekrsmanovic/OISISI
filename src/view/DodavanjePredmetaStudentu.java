package view;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.DefaultListModel;
import javax.swing.JDialog;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

import model.BazaOcena;
import model.BazaPredmeta;
import model.BazaStudenata;
import model.Ocena;
import model.Predmet;
import model.Student;

public class DodavanjePredmetaStudentu extends JDialog {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2827182974170584436L;
	List<Predmet> predmetiZaDodavanje;
	private static Student s;
	public DodavanjePredmetaStudentu(String brojIndeksa) {
		setModal(true);
		setTitle("Dodavanje predmeta");
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		setSize(d.width * 3 / 8*80/100, (d.height * 3 / 4) * 60 / 100);
		Dimension buttonDim=new Dimension(50,20);
		DefaultListModel<String> listaIspis = new DefaultListModel<>(); 
		setLocationRelativeTo(EditStudentDialog.getInstance());
		s = BazaStudenata.getInstance().findStudentByIndeks(brojIndeksa);
		List<Predmet> polozeniPredmeti; // predmeti koje je student polozio
		predmetiZaDodavanje =new ArrayList<Predmet>(BazaPredmeta.getInstance().getPredmeti()); // stavljanje svih predmeta iz baze i posle cemo
																		// ukloniti nepotrebne
		izbacivanjePredmetaNeodgovarajuceGodine();
//		System.out.println("\n\nPredmeti za dodavanje\n");
//		for (Predmet pre:predmetiZaDodavanje) {
//			System.out.println(pre);
//		}
//		System.out.println("\n");
//		
//		System.out.println("\n\nNepolozeni predmeti stuednta\n");
//		for (Predmet pre:s.getNepolozeniIspiti()) {
//			System.out.println(pre);
//		}
//		System.out.println("\n");
		izbacivanjeNepolozenih(predmetiZaDodavanje, s.getNepolozeniIspiti());
		polozeniPredmeti = dobijanjePredmetaNaOsnovuOcjena(s, BazaOcena.getInstance().getOcjene()); // uzimanje predmeta
																									// koje je student
																									// polozio
		
		izbacivanjePolozenih(predmetiZaDodavanje,polozeniPredmeti);
		
		for (Predmet p:predmetiZaDodavanje) {
			String naziv=p.getSifra()+"-"+p.getNaziv();
			listaIspis.addElement(naziv);
		}
		JList<String> list=new JList<>(listaIspis);
		list.setFixedCellWidth(this.getWidth()*3/4);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.setBorder(BorderFactory.createLineBorder(Color.black));
		JScrollPane scroll=new JScrollPane(list);
		JPanel centar=new JPanel();
		centar.setLayout(new BorderLayout());
		centar.add(scroll,BorderLayout.CENTER);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		centar.setBorder(BorderFactory.createEmptyBorder(20, 30, 20, 30));
		
		JPanel bottom=new JPanel();
		bottom.setBorder(BorderFactory.createEmptyBorder(0, 30, 20, 30));
		Button dodaj=new Button("Dodaj");
		if (predmetiZaDodavanje.isEmpty()) {
			dodaj.setEnabled(false);
		}
		dodaj.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Predmet p=predmetiZaDodavanje.get(list.getSelectedIndex());
				predmetiZaDodavanje.remove(list.getSelectedIndex());
				s.getNepolozeniIspiti().add(p);
				NepolozeniTab.getDodaj().setBackground(Color.decode("#86b4e3"));
				NepolozeniJTable.getInstance().azuriraj();
				validate();
				dispose();
			}
		});
		Button odustani=new Button("Odustani");
		odustani.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				NepolozeniTab.getDodaj().setBackground(Color.decode("#86b4e3"));
				dispose();
				
			}
			
		});
		dodaj.setSize(buttonDim);
		odustani.setSize(buttonDim);
		bottom.add(dodaj);
		bottom.add(Box.createRigidArea(new Dimension(30,0)));
		bottom.add(odustani);
		this.add(centar,BorderLayout.CENTER);
		this.add(bottom,BorderLayout.SOUTH);
		this.addWindowListener(new WindowListener() {
			
			@Override
			public void windowOpened(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowIconified(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowDeiconified(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowDeactivated(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowClosing(WindowEvent arg0) {
				NepolozeniTab.getDodaj().setBackground(Color.decode("#86b4e3"));
			}
			
			@Override
			public void windowClosed(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowActivated(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
	}

	private void izbacivanjePredmetaNeodgovarajuceGodine() {
		int index=0;
		Student s=OsnovneInformacijaTab.getStudent();
		ArrayList<Predmet> kopijaListe=new ArrayList<Predmet>(predmetiZaDodavanje);
		for (Predmet p:kopijaListe) {
			if (s.getTrenutnaGodinaStudija()<p.getGodinaStudija()) {
				predmetiZaDodavanje.remove(index);
				index--;
			}
			index++;
		}
		
	}

	private void izbacivanjePolozenih(List<Predmet> predmetiZaDodavanje2, List<Predmet> polozeniPredmeti) {
		for (int i=0;i<polozeniPredmeti.size();i++) {
			for (int j=0;j<predmetiZaDodavanje2.size();j++) {
				if (polozeniPredmeti.get(i).getSifra().equalsIgnoreCase(predmetiZaDodavanje2.get(j).getSifra())) {
					predmetiZaDodavanje2.remove(j);
				}
			}
		}
		
	}

	private List<Predmet> dobijanjePredmetaNaOsnovuOcjena(Student s, List<Ocena> ocjene) {
		List<Predmet> predmeti = new ArrayList<Predmet>(); // polozeni predmeti
		for (Ocena o : ocjene) {
			if (o.getS().getBrojIndeksa().equalsIgnoreCase(s.getBrojIndeksa())) {
				predmeti.add(o.getP());
			}
		}
		return predmeti;
	}

	private void izbacivanjeNepolozenih(List<Predmet> predmetiZaDodavanje2, ArrayList<Predmet> nepolozeniIspiti) {
		for (int i = 0; i < nepolozeniIspiti.size(); i++) {
			for (int j = 0; j < predmetiZaDodavanje2.size(); j++) {
				if (predmetiZaDodavanje2.get(j).getSifra().equalsIgnoreCase(nepolozeniIspiti.get(i).getSifra())) {
					predmetiZaDodavanje2.remove(j);
				}
			}
		}

	}

}
