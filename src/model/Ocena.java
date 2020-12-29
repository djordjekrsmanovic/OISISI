package model;

import java.util.Date;

public class Ocena {
	private Student s;
	private Predmet p;
	private Integer vrijednostOcjene;
	private Date datumPolaganja;
	public Ocena(Student s, int vrijednostOcjene, Date datumPolaganja) {
		super();
		this.s = s;
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