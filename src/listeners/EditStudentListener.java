package listeners;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JTextField;

import controller.ValidationStudent;

public class EditStudentListener implements FocusListener {

	private JTextField txtField;
	private int redniBrojKomponente;

	public EditStudentListener(JTextField txtField, int redniBrojKomponente) {
		this.txtField = txtField;// tekstualno polje se prosledjuje jer nakon gubljenja fokusa u njemu se nalazi
									// sadrzaj za validaciju
		this.redniBrojKomponente = redniBrojKomponente;
	}

	@Override
	public void focusGained(FocusEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void focusLost(FocusEvent arg0) {
		ValidationStudent.getInstance().validateEdit(txtField.getText().trim(), redniBrojKomponente);

	}

}
