package listeners;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JTextField;

import controller.ValidationProfessor;

public class AddProfessorListener implements FocusListener{
	private JTextField textField;
	private int fieldNum;

	public AddProfessorListener(JTextField textField, int fieldNum) {
		this.textField = textField;
		this.fieldNum = fieldNum;
	}

	@Override
	public void focusGained(FocusEvent arg0) {

	}

	@Override
	public void focusLost(FocusEvent arg0) {

		ValidationProfessor.getInstance().validate(textField.getText().trim(), fieldNum);

	}
}
