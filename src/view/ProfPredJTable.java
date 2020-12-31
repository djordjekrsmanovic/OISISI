package view;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableRowSorter;

public class ProfPredJTable extends JTable{
	
	private static final long serialVersionUID = 7777690246583576484L;
	private AbstractTableProfPred model;
	private TableRowSorter<AbstractTableProfPred> sorter;
	private static ProfPredJTable instance = null;

	public static ProfPredJTable getInstance() {
		if (instance == null) {
			instance = new ProfPredJTable();
		}
		return instance;
	}

	private ProfPredJTable() {
		model = new AbstractTableProfPred();
		this.setRowSelectionAllowed(true);
		this.setColumnSelectionAllowed(true);
		this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.getTableHeader().setReorderingAllowed(false);
		this.setModel(model);
		sorter = new TableRowSorter<AbstractTableProfPred>(model);
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
		AbstractTableProfPred model = (AbstractTableProfPred) this.getModel();
		model.fireTableDataChanged();
	}
}
