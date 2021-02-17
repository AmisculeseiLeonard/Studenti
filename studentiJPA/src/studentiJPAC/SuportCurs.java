package studentiJPAC;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import static javax.persistence.GenerationType.AUTO;

@Entity
public class SuportCurs {
	@Id
	@GeneratedValue(strategy = AUTO)
	private Integer id;
	
	private String titlu;
	
	private String autor;
	
	@OneToOne(mappedBy = "suportCurs")
	private Curs curs;

	
	public SuportCurs() {
		super();
	}
	
	


	public SuportCurs(String titlu, String autor) {
		super();
		this.titlu = titlu;
		this.autor = autor;
	}


	public SuportCurs(Integer id, String titlu, String autor) {
		super();
		this.id = id;
		this.titlu = titlu;
		this.autor = autor;
	}




	public SuportCurs(Integer id, String titlu, String autor, Curs curs) {
		super();
		this.id = id;
		this.titlu = titlu;
		this.autor = autor;
		this.curs = curs;
	}


	//Getters si Setters
	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	public String getTitlu() {
		return titlu;
	}



	public void setTitlu(String titlu) {
		this.titlu = titlu;
	}



	public String getAutor() {
		return autor;
	}



	public void setAutor(String autor) {
		this.autor = autor;
	}



	public Curs getCurs() {
		return curs;
	}



	public void setCurs(Curs curs) {
		this.curs = curs;
	}

	
	
	
	
	
}
