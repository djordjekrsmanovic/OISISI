package view;

import javax.swing.table.AbstractTableModel;

import model.BazaProfesora;

public class AbstractTableProfessor extends AbstractTableModel {

	private static final long serialVersionUID = -4304503391987160767L;

	public AbstractTableProfessor() {
	}

	@Override
	public int getColumnCount() {
		return BazaProfesora.getInstance().getNumberOfColumns();
	}

	@Override
	public String getColumnName(int column) {
		return BazaProfesora.getInstance().getColumnName(column);
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return BazaProfesora.getInstance().getNumberOfRows();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return BazaProfesora.getInstance().getValueAt(rowIndex, columnIndex);
	}

}
