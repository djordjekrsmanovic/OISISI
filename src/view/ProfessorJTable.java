package view;

import java.awt.Color;
import java.awt.Component;
import java.util.Arrays;
import java.util.List;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.RowFilter;
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

	public void pretraga(String filter) {
		
		String[] searchArgs = filter.split(" ");
		if (searchArgs.length == 1) {
			RowFilter<AbstractTableProfessor, Integer> imeFilter = RowFilter
					.regexFilter(".*" + "(?i)" + searchArgs[0] + ".*");
			List<RowFilter<AbstractTableProfessor, Integer>> filteri = Arrays.asList(imeFilter);
			sorter.setRowFilter(RowFilter.andFilter(filteri));
			return;
		}
		if (searchArgs.length == 2) {
			System.out.println("adgdsg");
			RowFilter<AbstractTableProfessor, Integer> prezimeFilter = RowFilter
					.regexFilter(".*" + "(?i)" + searchArgs[0] + ".*");
			RowFilter<AbstractTableProfessor, Integer> imeFilter = RowFilter
					.regexFilter(".*" + "(?i)" + searchArgs[1] + ".*");
			List<RowFilter<AbstractTableProfessor, Integer>> filteri = Arrays.asList(prezimeFilter, imeFilter);
			sorter.setRowFilter(RowFilter.andFilter(filteri));
			return;
		}
		
	}
}
