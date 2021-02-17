package studentiJPAC;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class Bursa {
	@Id
	@Enumerated(EnumType.STRING)
	private TipBursa tipBursa;
	
	private Integer valoare;
	
	@OneToMany(mappedBy = "bursa")
	private List<StudentIF> studenti = new ArrayList<StudentIF>();

	
	public Bursa() {
		super();
	}

	public Bursa(TipBursa tipBursa, Integer valoare) {
		super();
		this.tipBursa = tipBursa;
		this.valoare = valoare;
	}
	
	public void adaugaStudent(StudentIF student) {
		if(studenti.contains(student))
			studenti.add(student);
	}

	
	//Getters si Setters
	public TipBursa getTipBursa() {
		return tipBursa;
	}

	public void setTipBursa(TipBursa tipBursa) {
		this.tipBursa = tipBursa;
	}

	public Integer getValoare() {
		return valoare;
	}

	public void setValoare(Integer valoare) {
		this.valoare = valoare;
	}

	public List<StudentIF> getStudenti() {
		return studenti;
	}

	public void setStudenti(List<StudentIF> studenti) {
		this.studenti = studenti;
	}

	@Override
	public String toString() {
		return "Bursa [tipBursa=" + tipBursa + ", valoare=" + valoare + "]";
	}
	
	
	
	
	
	
	
	
}
