package view;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableRowSorter;

public class DodajPredmetProfesoruJTable extends JTable {
	private static final long serialVersionUID = 5827701628854622228L;
	
	private static DodajPredmetProfesoruJTable instance = null;
	private TableRowSorter<AbstractTableDodajPredmetProfesoru> sorter;

	public static DodajPredmetProfesoruJTable getInstance() {
		if (instance == null) {
			instance = new DodajPredmetProfesoruJTable();
		}
		return instance;
	}

	private DodajPredmetProfesoruJTable() {
		this.setRowSelectionAllowed(true);
		this.setColumnSelectionAllowed(true);
		this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.getTableHeader().setReorderingAllowed(false);
		AbstractTableDodajPredmetProfesoru model = new AbstractTableDodajPredmetProfesoru();
		this.setModel(model);
		sorter = new TableRowSorter<AbstractTableDodajPredmetProfesoru>(model);
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
		AbstractTableDodajPredmetProfesoru model = (AbstractTableDodajPredmetProfesoru) this.getModel();
		model.fireTableDataChanged();
	}
}
