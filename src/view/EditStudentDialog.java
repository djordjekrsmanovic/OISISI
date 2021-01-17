package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JDialog;

public class EditStudentDialog extends JDialog {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8813674525188404242L;

	private static EditStudentDialog instance = null;

	public static EditStudentDialog getInstance() {
		if (instance == null) {
			instance = new EditStudentDialog();
		}
		return instance;
	}

	public EditStudentDialog() {
		String naslov = "Izmjena studenta";
		this.setTitle(naslov);
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		this.setSize(d.width * 3 / 8, (d.height * 3 / 4) * 97 / 100);
		setLayout(new BorderLayout());
		setResizable(false);
		setModal(true);
		setLocationRelativeTo(null);
		this.add(EditStudent.getInstance(), BorderLayout.CENTER);
		this.addWindowListener(new WindowListener() {

			@Override
			public void windowActivated(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowClosed(WindowEvent arg0) {
				
				
			}

			@Override
			public void windowClosing(WindowEvent arg0) { //ukoliko se zatvori prozor na X potrebno je postaviti logicke vrijednosti
				// TODO Auto-generated method stub
				EditStudentDialog.setInstance();
				EditStudent.setInstance();
				StudentJTable.getInstance().azuriraj();
			}

			@Override
			public void windowDeactivated(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowDeiconified(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowIconified(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowOpened(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
		});
	}

	public static void setInstance() {
		instance = null;
	}
}
