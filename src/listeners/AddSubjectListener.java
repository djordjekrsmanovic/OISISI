package listeners;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JTextField;

import controller.ValidationSubject;

public class AddSubjectListener implements FocusListener {

	private JTextField txtField;
	private int redniBrojKomponente;

	public AddSubjectListener(JTextField txtField, int redniBrojKomponente) {
		super();
		this.txtField = txtField;
		this.redniBrojKomponente = redniBrojKomponente;
	}

	@Override
	public void focusGained(FocusEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void focusLost(FocusEvent arg0) {
		// TODO Auto-generated method stub
		ValidationSubject.getInstance().validate(txtField.getText().trim(), redniBrojKomponente);
	}

}
