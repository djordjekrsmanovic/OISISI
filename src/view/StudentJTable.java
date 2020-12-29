package view;

import java.awt.Color;
import java.awt.Component;


import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableRowSorter;

public class StudentJTable extends JTable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4123201341266614575L;

	private AbstractTableStudent model;
	private TableRowSorter<AbstractTableStudent> sorter;
	private static StudentJTable instance=null;
	
	public static StudentJTable getInstance() {
		if (instance==null) {
			instance=new StudentJTable();
		}
		return instance;
	}
	private StudentJTable(){
		model=new AbstractTableStudent();
		this.setRowSelectionAllowed(true);
		this.setColumnSelectionAllowed(true);
		this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.getTableHeader().setReorderingAllowed(false);
		this.setModel(model);
		sorter=new TableRowSorter<AbstractTableStudent>(model);
		this.setRowSorter(sorter);
	}
	public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
		Component c = super.prepareRenderer(renderer, row, column);
		if (isRowSelected(row)) {
			c.setBackground(Color.LIGHT_GRAY);
		} else {
			c.setBackground(Color.WHITE);
		}
		return c;
	}
	
	public void azuriraj() {
		AbstractTableStudent model = (AbstractTableStudent) this.getModel();
		model.fireTableDataChanged();
	}
}
