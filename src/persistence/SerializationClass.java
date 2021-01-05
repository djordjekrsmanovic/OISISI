package persistence;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import model.Ocena;
import model.Predmet;
import model.Profesor;
import model.Student;

//ideja je preuzeta sa https://stackoverflow.com/questions/10374604/serialization-of-related-objects-in-java
public class SerializationClass implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3601428925754731151L;
	private List<Student> studenti;
	private List<Predmet> predmeti;
	private List<Ocena> ocene;
	private List<Profesor> profesori;
	
	public SerializationClass(List<Student> studenti, List<Predmet> predmeti, List<Ocena> ocene,
			List<Profesor> profesori) {
		super();
		this.studenti = studenti;
		this.predmeti = predmeti;
		this.ocene = ocene;
		this.profesori = profesori;
	}

	
	public SerializationClass() {
		super();
		studenti=new ArrayList<Student>();
		predmeti=new ArrayList<Predmet>();
		ocene=new ArrayList<Ocena>();
		profesori=new ArrayList<Profesor>();
	}


	public List<Student> getStudenti() {
		return studenti;
	}

	public void setStudenti(List<Student> studenti) {
		this.studenti = studenti;
	}

	public List<Predmet> getPredmeti() {
		return predmeti;
	}

	public void setPredmeti(List<Predmet> predmeti) {
		this.predmeti = predmeti;
	}

	public List<Ocena> getOcene() {
		return ocene;
	}

	public void setOcene(List<Ocena> ocene) {
		this.ocene = ocene;
	}

	public List<Profesor> getProfesori() {
		return profesori;
	}

	public void setProfesori(List<Profesor> profesori) {
		this.profesori = profesori;
	}
	
	
	
	
	
}
