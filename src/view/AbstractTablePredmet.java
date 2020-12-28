package view;

import javax.swing.table.AbstractTableModel;

import model.BazaPredmeta;

public class AbstractTablePredmet extends AbstractTableModel {

	private static final long serialVersionUID = -624302125562455268L;

	public AbstractTablePredmet() {
	}

	@Override
	public int getColumnCount() {
		return BazaPredmeta.getInstance().getNumberOfColumns();
	}

	@Override
	public String getColumnName(int column) {
		return BazaPredmeta.getInstance().getColumnName(column);
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return BazaPredmeta.getInstance().getNumberOfRows();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return BazaPredmeta.getInstance().getValueAt(rowIndex, columnIndex);
	}
}
