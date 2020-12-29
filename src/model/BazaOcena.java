package model;

import java.util.ArrayList;
import java.util.List;

public class BazaOcena {
	
	private static BazaOcena instance=null;
	private List<Ocena> ocjene;
	private List<String> kolone;
	
	public static BazaOcena getInstance() {
		if (instance==null) {
			instance=new BazaOcena();
		}
		return instance;
	}
	private BazaOcena()  {
		
		ocjene=new ArrayList<Ocena>();
		kolone=new ArrayList<String>();
		kolone.add("Šifra predmeta");
		kolone.add("Naziv predmeta");
		kolone.add("ESPB");
		kolone.add("Ocena");
		kolone.add("Datum");
		
		
	}
	
	
	public int getNumberOfColumns() {
		return kolone.size();
	}

	public int getNumberOfRows() {
		return ocjene.size();
	}

	public String getColumnName(int indeks) {
		return kolone.get(indeks);
	}

	public Ocena getRow(int rowIndex) {
		return ocjene.get(rowIndex);
	}
    
	public String getValueAt(int row, int column) {
		Ocena ocjena = ocjene.get(row);
		switch (column) {
		case 0:
			return ocjena.getP().getSifra();
		case 1:
			return ocjena.getP().getNaziv();
		case 2:
			return ocjena.getP().getEspb().toString();
		case 3:
			return Integer.toString(ocjena.getVrijednostOcjene());
		case 4:
			return ocjena.getDatumPolaganja().toString();
		default:
			return null;
		}
	}
}
