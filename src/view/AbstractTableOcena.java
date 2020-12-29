package view;

import javax.swing.table.AbstractTableModel;

import model.BazaOcena;

public class AbstractTableOcena extends AbstractTableModel {


	/**
	 * 
	 */
	private static final long serialVersionUID = -5095130996872800008L;

	public AbstractTableOcena(){}
	@Override
	public int getColumnCount() {
		return BazaOcena.getInstance().getNumberOfColumns();
	}

	@Override
	public String getColumnName(int column) {
		return BazaOcena.getInstance().getColumnName(column);
	}
	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return BazaOcena.getInstance().getNumberOfRows();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return BazaOcena.getInstance().getValueAt(rowIndex,columnIndex);
	}

}
