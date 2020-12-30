package view;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableRowSorter;

public class ProfessorJTable extends JTable {

	private static final long serialVersionUID = -9084637287335579509L;
	private static ProfessorJTable instance = null;
	private TableRowSorter<AbstractTableProfessor> sorter;
	
	public static ProfessorJTable getInstance() {
		if (instance == null) {
			instance = new ProfessorJTable();
		}
		return instance;
	}

	private ProfessorJTable() {
		this.setRowSelectionAllowed(true);
		this.setColumnSelectionAllowed(true);
		this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.getTableHeader().setReorderingAllowed(false);
		AbstractTableProfessor model = new AbstractTableProfessor();
		this.setModel(model);
		sorter = new TableRowSorter<AbstractTableProfessor>(model);
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
		AbstractTableProfessor model = (AbstractTableProfessor) this.getModel();
		model.fireTableDataChanged();
	}
}
