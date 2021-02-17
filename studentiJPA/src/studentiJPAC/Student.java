package studentiJPAC;


import java.util.Date;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import static javax.persistence.TemporalType.DATE;



@MappedSuperclass
public abstract class Student {
	@Id
	private Integer numarMatricol;
	
	private String nume;
	
	@Temporal(DATE)
	private Date dataNasterii;
	
	private String profil;
	
	private Integer an;
	
	public Student() {
		
	}

	public Student(Integer numarMatricol, String nume, Date dataNasterii, String profil, Integer an) {
		super();
		this.numarMatricol = numarMatricol;
		this.nume = nume;
		this.dataNasterii = dataNasterii;
		this.profil = profil;
		this.an = an;
	}
	

	public abstract void adaugaCurs(Curs curs);
	
	public abstract void stergeCurs(Curs curs);


	//Getters si Setters
	public Integer getNumarMatricol() {
		return numarMatricol;
	}


	public void setNumarMatricol(Integer numarMatricol) {
		this.numarMatricol = numarMatricol;
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


	public String getProfil() {
		return profil;
	}


	public void setProfil(String profil) {
		this.profil = profil;
	}


	public Integer getAn() {
		return an;
	}


	public void setAn(Integer an) {
		this.an = an;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((an == null) ? 0 : an.hashCode());
		result = prime * result + ((dataNasterii == null) ? 0 : dataNasterii.hashCode());
		result = prime * result + ((numarMatricol == null) ? 0 : numarMatricol.hashCode());
		result = prime * result + ((nume == null) ? 0 : nume.hashCode());
		result = prime * result + ((profil == null) ? 0 : profil.hashCode());
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
		Student other = (Student) obj;
		if (numarMatricol == null) {
			if (other.numarMatricol != null)
				return false;
		} else if (!numarMatricol.equals(other.numarMatricol))
			return false;
		return true;
	}


	
	
	
	
	
	
}
