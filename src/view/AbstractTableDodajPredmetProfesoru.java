package view;

import javax.swing.table.AbstractTableModel;

import model.BazaPredmeta;
import model.BazaProfesora;
import model.Predmet;
import model.Profesor;

public class AbstractTableDodajPredmetProfesoru extends AbstractTableModel {

	private static final long serialVersionUID = 1340776641626121205L;

	@Override
	public int getColumnCount() {
		return 1;
	}

	
	@Override
	public int getRowCount() {
		return BazaProfesora.getInstance().getPredmetiKojeProfesorNePredaje().size();
	}

	@Override
	public Object getValueAt(int row, int column) {
		Predmet p = BazaProfesora.getInstance().getPredmetiKojeProfesorNePredaje().get(row);
		return p.getSifra() + " - " + p.getNaziv();
	}
	
	public Profesor getProfessor() {
		int row = ProfessorJTable.getInstance().convertRowIndexToModel(ProfessorJTable.getInstance().getSelectedRow());
		return BazaProfesora.getInstance().findProfessorByRow(row);
	}


}
