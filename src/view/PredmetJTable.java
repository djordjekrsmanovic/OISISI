package view;

import java.awt.Color;
import java.awt.Component;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.RowFilter;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableRowSorter;

public class PredmetJTable extends JTable {

	private static final long serialVersionUID = -6307955004257041625L;
	private static PredmetJTable instance = null;
	private TableRowSorter<AbstractTablePredmet> sorter;

	public static PredmetJTable getInstance() {
		if (instance == null) {
			instance = new PredmetJTable();
		}
		return instance;
	}

	private PredmetJTable() {
		this.setRowSelectionAllowed(true);
		this.setColumnSelectionAllowed(true);
		this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.getTableHeader().setReorderingAllowed(false);
		AbstractTablePredmet model = new AbstractTablePredmet();
		this.setModel(model);
		sorter = new TableRowSorter<AbstractTablePredmet>(model);
		sorter.setComparator(2, new Comparator<String>() {

			@Override
			public int compare(String a, String b) {
				if (Integer.parseInt(a) > Integer.parseInt(b)) {
					return -1;
				} else if (Integer.parseInt(a) < Integer.parseInt(b)) {
					return 1;
				} else {
					return 0;
				}
			}

		});
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
		AbstractTablePredmet model = (AbstractTablePredmet) this.getModel();
		model.fireTableDataChanged();
	}

	public void pretraga(String filter) {

		RowFilter<AbstractTablePredmet, Integer> imeFilter = RowFilter.regexFilter(".*" + "(?i)" + filter + ".*");
		List<RowFilter<AbstractTablePredmet, Integer>> filteri = Arrays.asList(imeFilter);
		sorter.setRowFilter(RowFilter.andFilter(filteri));

	}
}
