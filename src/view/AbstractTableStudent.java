package view;

import javax.swing.table.AbstractTableModel;

import model.BazaStudenata;

//radjeno po uzoru na vjezbe vjezbe 7
public class AbstractTableStudent extends AbstractTableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4304503391987160767L;
	

	public AbstractTableStudent(){}
	@Override
	public int getColumnCount() {
		return BazaStudenata.getInstance().getNumberOfColumns();
	}

	@Override
	public String getColumnName(int column) {
		return BazaStudenata.getInstance().getColumnName(column);
	}
	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return BazaStudenata.getInstance().getNumberOfRows();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return BazaStudenata.getInstance().getValueAt(rowIndex,columnIndex);
	}

}
