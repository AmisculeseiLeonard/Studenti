package studentiJPAC;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import static javax.persistence.CascadeType.ALL;

@Entity
public class StudentID extends Student {
	
	@ManyToMany(cascade = ALL)
	@JoinTable(
			name = "studentiID_cursuri",
			joinColumns = @JoinColumn(name = "id_student"),
			inverseJoinColumns = @JoinColumn(name = "id_curs")
			)
	private List<Curs> cursuriID = new ArrayList<Curs>();
	
	public StudentID() {
		super();
	}
	
	public StudentID(Integer numarMatricol, String nume, Date dataNasterii, String profil, Integer an) {
		super(numarMatricol, nume, dataNasterii, profil, an);
	}


	@Override
	public void adaugaCurs(Curs curs) {
		if(!cursuriID.contains(curs))
			cursuriID.add(curs);
	}
	
	
	@Override
	public void stergeCurs(Curs curs) {
		if(cursuriID.contains(curs))
			cursuriID.remove(curs);
		else
			System.out.println("Cursul nu exista!");
		
	}
	

	public List<Curs> getCursuri() {
		return cursuriID;
	}

	public void setCursuri(List<Curs> cursuri) {
		this.cursuriID = cursuri;
	}

	
	@Override
	public String toString() {
		return "StudentID: " + getNume() + ", numar matricol: " + getNumarMatricol() + ", profil: " + getProfil() + ", an " + getAn() + ", data nasterii: " + getDataNasterii().toString();
	}

	
	
	
}
