package model;

import java.io.Serializable;
import java.util.Date;

public class Ocena implements Serializable {
	
	private static final long serialVersionUID = 4597445468355976403L;
	private Student s;
	private Predmet p;
	private Integer vrijednostOcjene;
	private Date datumPolaganja;

	public Ocena(Student s, Predmet p, int vrijednostOcjene, Date datumPolaganja) {
		super();
		this.s = s;
		this.p = p;
		this.vrijednostOcjene = vrijednostOcjene;
		this.datumPolaganja = datumPolaganja;
	}

	public Predmet getP() {
		return p;
	}

	public void setP(Predmet p) {
		this.p = p;
	}

	public Student getS() {
		return s;
	}

	public void setS(Student s) {
		this.s = s;
	}

	public Integer getVrijednostOcjene() {
		return vrijednostOcjene;
	}

	public void setVrijednostOcjene(Integer vrijednostOcjene) {
		this.vrijednostOcjene = vrijednostOcjene;
	}

	public Date getDatumPolaganja() {
		return datumPolaganja;
	}

	public void setDatumPolaganja(Date datumPolaganja) {
		this.datumPolaganja = datumPolaganja;
	}

}