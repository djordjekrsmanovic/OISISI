package view;

import javax.swing.table.AbstractTableModel;

import model.BazaPredmeta;
import model.BazaProfesora;
import model.Profesor;

public class AbstractTableProfPred extends AbstractTableModel {

	private static final long serialVersionUID = 931998646853318733L;

	public AbstractTableProfPred() {
	}

	@Override
	public int getColumnCount() {
		return BazaPredmeta.getInstance().getNumberOfColumns() - 1;
	}

	@Override
	public String getColumnName(int column) {
		if (column > 1)
			++column;
		return BazaPredmeta.getInstance().getColumnName(column);
	}

	@Override
	public int getRowCount() {

		int row = ProfessorJTable.getInstance().convertRowIndexToModel(ProfessorJTable.getInstance().getSelectedRow());
		Profesor p = new Profesor(BazaProfesora.getInstance().findProfessorByRow(row));
		return p.getPredajeNaPredmetima().size();

	}

	public Profesor getProfessor() {
		int row = ProfessorJTable.getInstance().convertRowIndexToModel(ProfessorJTable.getInstance().getSelectedRow());
		return BazaProfesora.getInstance().findProfessorByRow(row);
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		return BazaPredmeta.getInstance().getProfessorValueAt(rowIndex, columnIndex, getProfessor().getBrojLicneKarte());
	}

}