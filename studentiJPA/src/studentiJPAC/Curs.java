package studentiJPAC;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

import static javax.persistence.GenerationType.AUTO;
import static javax.persistence.FetchType.LAZY;
import static javax.persistence.CascadeType.PERSIST;

@Entity
public class Curs {
	@Id
	@GeneratedValue(strategy = AUTO)
	private Integer id;
	
	private String denumire;
	
	private Integer credite;
	
	@OneToOne(cascade = PERSIST)
	@JoinColumn(name = "id_suport_curs")
	private SuportCurs suportCurs;
	
	@ManyToMany(fetch = LAZY, mappedBy = "cursuri")
	private List<Profesor> profesori = new ArrayList<Profesor>();
	
	@ManyToMany(fetch = LAZY, mappedBy = "cursuri")
	private List<StudentIF> studentiIF = new ArrayList<StudentIF>();
	
	@ManyToMany(fetch = LAZY, mappedBy = "cursuriID")
	private List<StudentID> studentiID = new ArrayList<StudentID>();

	public Curs() {
		super();
	}
	public Curs(String denumire, Integer credite) {
		super();
		this.denumire = denumire;
		this.credite = credite;
	}

	public Curs(Integer id, String denumire, Integer credite) {
		super();
		this.id = id;
		this.denumire = denumire;
		this.credite = credite;
	}

	public Curs(Integer id, String denumire, Integer credite, SuportCurs suportCurs) {
		super();
		this.id = id;
		this.denumire = denumire;
		this.credite = credite;
		this.suportCurs = suportCurs;
	}
	
	public void adaugaProfesor(Profesor profesor) {
		if(!profesori.contains(profesor))
			profesori.add(profesor);
	}
	
	public void adaugaStudentIF(StudentIF student) {
		if(!studentiIF.contains(student))
			studentiIF.add(student);
	}
	
	public void adaugaStudentID(StudentID student) {
		if(!studentiID.contains(student))
			studentiID.add(student);
	}
	
	public void stergeProfesor(Profesor profesor) {
		if(profesori.contains(profesor))
			profesori.remove(profesor);
	}
	
	//Gettes si Setters
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDenumire() {
		return denumire;
	}

	public void setDenumire(String denumire) {
		this.denumire = denumire;
	}

	public Integer getCredite() {
		return credite;
	}

	public void setCredite(Integer credite) {
		this.credite = credite;
	}

	public SuportCurs getSuportCurs() {
		return suportCurs;
	}

	public void setSuportCurs(SuportCurs suportCurs) {
		this.suportCurs = suportCurs;
	}

	public List<Profesor> getProfesori() {
		return profesori;
	}

	public void setProfesori(List<Profesor> profesori) {
		this.profesori = profesori;
	}

	public List<StudentIF> getStudentiIF() {
		return studentiIF;
	}

	public void setStudentiIF(List<StudentIF> studentiIF) {
		this.studentiIF = studentiIF;
	}

	public List<StudentID> getStudentiID() {
		return studentiID;
	}

	public void setStudentiID(List<StudentID> studentiID) {
		this.studentiID = studentiID;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Curs other = (Curs) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
	
	
}
