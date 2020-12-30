package view;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableRowSorter;

public class NepolozeniJTable extends JTable {
	
	private static final long serialVersionUID = 7940872328116124822L;
	
	private AbstractTableNepolozeni model;
	private TableRowSorter<AbstractTableNepolozeni> sorter;
	private static NepolozeniJTable instance = null;

	public static NepolozeniJTable getInstance() {
		if (instance == null) {
			instance = new NepolozeniJTable();
		}
		return instance;
	}

	private NepolozeniJTable() {
		model = new AbstractTableNepolozeni();
		this.setRowSelectionAllowed(true);
		this.setColumnSelectionAllowed(true);
		this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.getTableHeader().setReorderingAllowed(false);
		this.setModel(model);
		sorter = new TableRowSorter<AbstractTableNepolozeni>(model);
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
		AbstractTableNepolozeni model = (AbstractTableNepolozeni) this.getModel();
		model.fireTableDataChanged();
	}
}
