package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JDialog;
import javax.swing.JFrame;

public class EditProfessorDialog extends JDialog {

	private static final long serialVersionUID = 2850653125960014731L;
	MenuBar menuBar;
	StatusBar statusBar;

	private static EditProfessorDialog instance = null;

	public EditProfessorDialog() {
		JFrame mainFrame = MainWindow.getInstance();
		this.setTitle("Izmena profesora");
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocationRelativeTo(mainFrame);
		this.setSize(d.width * 3 / 8, (d.height * 3 / 4) * 97 / 100);
		setLayout(new BorderLayout());
		setResizable(false);
		setModal(true);
		setLocationRelativeTo(mainFrame);

		this.add(EditProfessor.getInstance(), BorderLayout.CENTER);
		this.addWindowListener(new WindowListener() {

			@Override
			public void windowActivated(WindowEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void windowClosed(WindowEvent arg0) {

			}

			@Override
			public void windowClosing(WindowEvent arg0) {
				// TODO Auto-generated method stub
				EditProfessorDialog.resetInstance();
				EditProfessor.resetInstance();
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

	public static EditProfessorDialog getInstance() {
		if (instance == null) {
			instance = new EditProfessorDialog();
		}
		return instance;
	}

	public static void resetInstance() {
		instance = null;
	}

}
