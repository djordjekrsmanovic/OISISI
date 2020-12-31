package view;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableRowSorter;

public class OcenaJTable extends JTable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2974594625085927787L;

	private AbstractTableOcena model;
	private TableRowSorter<AbstractTableOcena> sorter;
	private static OcenaJTable instance = null;

	public static OcenaJTable getInstance() {
		if (instance == null) {
			instance = new OcenaJTable();
		}
		return instance;
	}

	private OcenaJTable() {
		model = new AbstractTableOcena();
		this.setRowSelectionAllowed(true);
		this.setColumnSelectionAllowed(true);
		this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.getTableHeader().setReorderingAllowed(false);
		this.setModel(model);
		sorter = new TableRowSorter<AbstractTableOcena>(model);
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
		model.fireTableDataChanged();
	}
}
