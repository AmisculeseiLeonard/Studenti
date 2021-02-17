package studentiJPAC;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Temporal;
import static javax.persistence.TemporalType.DATE;
import static javax.persistence.GenerationType.AUTO;
import static javax.persistence.CascadeType.ALL;


@Entity
public class Profesor {
	@Id
	@GeneratedValue(strategy = AUTO)
	private Integer id;
	
	private String nume;
	
	@Temporal(value = DATE)
	private Date dataNasterii;
	
	@ManyToMany(cascade = ALL)
	@JoinTable(
			name = "profesori_cursuri",
			joinColumns = @JoinColumn(name = "id_profesor"),
			inverseJoinColumns = @JoinColumn(name = "id_curs")
			)
	private List<Curs> cursuri = new ArrayList<Curs>();
	
	
	public Profesor() {
		super();
	}

	
	public Profesor(String nume, Date dataNasterii) {
		super();
		this.nume = nume;
		this.dataNasterii = dataNasterii;
	}


	public Profesor(Integer id, String nume, Date dataNasterii) {
		super();
		this.id = id;
		this.nume = nume;
		this.dataNasterii = dataNasterii;
	}


	public void adaugaCurs(Curs curs) {
		if(!cursuri.contains(curs))
			cursuri.add(curs);
	}

	//Gettes si Setters
	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getNume() {
		return nume;
	}


	public void setNume(String nume) {
		this.nume = nume;
	}


	public Date getDataNasterii() {
		return dataNasterii;
	}


	public void setDataNasterii(Date dataNasterii) {
		this.dataNasterii = dataNasterii;
	}


	public List<Curs> getCursuri() {
		return cursuri;
	}


	public void setCursuri(List<Curs> cursuri) {
		this.cursuri = cursuri;
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
		Profesor other = (Profesor) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
}
