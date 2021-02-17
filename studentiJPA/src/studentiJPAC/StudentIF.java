package studentiJPAC;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import static javax.persistence.FetchType.LAZY;
import static javax.persistence.CascadeType.PERSIST;
import static javax.persistence.FetchType.EAGER;
import static javax.persistence.CascadeType.MERGE;
import static javax.persistence.CascadeType.REMOVE;
import static javax.persistence.CascadeType.ALL;

@Entity
public class StudentIF extends Student {
	
	@ManyToOne(fetch = LAZY, cascade = PERSIST)
	private Bursa bursa;
	
	@ManyToMany(cascade = ALL)
	@JoinTable(
			name = "studentiIF_cursuri",
			joinColumns = @JoinColumn(name = "id_student"),
			inverseJoinColumns = @JoinColumn(name = "id_curs")
			)
	private List<Curs> cursuri = new ArrayList<Curs>();
	
	public StudentIF() {
		super();
	}
	
	public StudentIF(Integer numarMatricol, String nume, Date dataNasterii, String profil, Integer an) {
		super(numarMatricol, nume, dataNasterii, profil, an);
	}


	@Override
	public void adaugaCurs(Curs curs) {
		if(!cursuri.contains(curs))
			cursuri.add(curs);
	}
	
	@Override
	public void stergeCurs(Curs curs) {
		if(cursuri.contains(curs))
			cursuri.remove(curs);
		else
			System.out.println("Cursul nu exista!");
		
	}

	
	//Getters si Setters
	public List<Curs> getCursuri() {
		return cursuri;
	}

	public void setCursuri(List<Curs> cursuri) {
		this.cursuri = cursuri;
	}
	
	public Bursa getBursa() {
		return bursa;
	}

	public void setBursa(Bursa bursa) {
		this.bursa = bursa;
	}

	@Override
	public String toString() {
		return "StudentIF: " + getNume() + ", numar matricol: " + getNumarMatricol() + ", profil: " + getProfil() + ", an " + getAn() + ", data nasterii: " + getDataNasterii().toString();
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		StudentIF other = (StudentIF) obj;
		if (getNumarMatricol() == null) {
			if (other.getNumarMatricol() != null)
				return false;
		} else if (!getNumarMatricol().equals(other.getNumarMatricol()))
			return false;
		return true;
	}

	

	
	
	
	
	
}
