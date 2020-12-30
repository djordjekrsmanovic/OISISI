package view;

import javax.swing.table.AbstractTableModel;

import model.BazaPredmeta;
import model.BazaStudenata;
import model.Student;

public class AbstractTableNepolozeni extends AbstractTableModel {

	private static final long serialVersionUID = 7619618694821389081L;

	public AbstractTableNepolozeni() {
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
		int row = StudentJTable.getInstance().convertRowIndexToModel(StudentJTable.getInstance().getSelectedRow());
		Student s = new Student(BazaStudenata.getInstance().findStudentByRow(row));
		return BazaPredmeta.getInstance().getNepolozeniNumberOfRows(s.getBrojIndeksa());
	}

	public Student getStudentAtRow(int rowIndex) {
		int row = StudentJTable.getInstance().convertRowIndexToModel(StudentJTable.getInstance().getSelectedRow());
		return BazaStudenata.getInstance().findStudentByRow(row);
	}
	
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return BazaPredmeta.getInstance().getNepolozeniValueAt(rowIndex, columnIndex, getStudentAtRow(rowIndex).getBrojIndeksa());
	}
	
	

}