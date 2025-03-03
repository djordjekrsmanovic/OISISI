package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import model.BazaOcena;
import model.BazaPredmeta;
import model.BazaProfesora;
import model.BazaStudenata;
import persistence.SerializationClass;
import persistence.Serijalizacija;

public class MainWindow extends JFrame {

	private static final long serialVersionUID = -4476208371993599163L;
	MenuBar menuBar;
	StatusBar statusBar;

	private static MainWindow instance = null;

	private MainWindow() {
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();
		int screenHeight = screenSize.height * 3 / 4;
		int screenWidth = screenSize.width * 3 / 4;
		setSize(screenWidth, screenHeight);
		setTitle("Studentska služba");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);

		menuBar = new MenuBar();
		statusBar = new StatusBar();

		this.setJMenuBar(menuBar);
		this.add(statusBar, BorderLayout.SOUTH);
		this.add(ToolBar.getInstance(), BorderLayout.NORTH);
		this.add(CentralPanel.getInstance(), BorderLayout.CENTER);

		addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				super.windowClosing(e);
				try {
					SerializationClass src=new SerializationClass(BazaStudenata.getInstance().getStudenti(), BazaPredmeta.getInstance().getPredmeti(), BazaOcena.getInstance().getOcjene(), BazaProfesora.getInstance().getProfesori());
					Serijalizacija.execute(src);
				} catch (FileNotFoundException e1) {
					JOptionPane.showMessageDialog(null, "Greška u upisu u fajl!");
				} catch (IOException e1) {
					JOptionPane.showMessageDialog(null, "Greška u toku podataka!");
				}

			}

		});
	}

	public static MainWindow getInstance() {
		if (instance == null) {
			instance = new MainWindow();
		}
		return instance;
	}

}
