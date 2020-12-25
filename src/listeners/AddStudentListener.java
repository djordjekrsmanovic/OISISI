package listeners;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JTextField;

import controller.ValidationStudent;

public class AddStudentListener implements FocusListener {

	private JTextField txtField;
	private int redniBrojKomponente;

	public AddStudentListener(JTextField txtField, int redniBrojKomponente) {
		this.txtField = txtField;// tekstualno polje se prosledjuje jer nakon gubljenja fokusa u njemu se nalazi
									// sadrzaj za validaciju
		this.redniBrojKomponente = redniBrojKomponente;
	}

	@Override
	public void focusGained(FocusEvent arg0) {

	}

	@Override
	public void focusLost(FocusEvent arg0) {

		ValidationStudent.getInstance().validate(txtField.getText().trim(), redniBrojKomponente);

	}

}
