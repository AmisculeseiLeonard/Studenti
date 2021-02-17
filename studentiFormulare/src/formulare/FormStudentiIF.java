package formulare;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.event.ActionEvent;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import studentiJPAC.Curs;
import studentiJPAC.StudentIF;



public class FormStudentiIF {
	private StudentIF student;
	private List<StudentIF> studenti = new ArrayList<StudentIF>();
	private EntityManager em;
	private DataModel<Curs> cursuriDataModel;
	

	public FormStudentiIF() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("studentiJPA");
		em = emf.createEntityManager();
		init();
	}
	 
	@SuppressWarnings("unchecked")
	public void init() {
		this.studenti = em.createQuery("select s from StudentIF s order by s.numarMatricol asc").getResultList();
		this.student = this.studenti.get(0);
	}
	
	@SuppressWarnings("deprecation")
	public void adaugaStudent(ActionEvent e) {
		this.student = new StudentIF();
		this.student.setNumarMatricol(1040);
		this.student.setNume("Student 40");
		this.student.setProfil("Informatica Economica");
		this.student.setDataNasterii(new Date("10/10/1997"));
		this.student.setAn(3);
		this.studenti.add(this.student);
		
	}
	
	public void stergeStudent(ActionEvent e) {
		this.studenti.remove(this.student);
		em.getTransaction().begin();
		em.remove(this.student);
		em.getTransaction().commit();
		if(!this.studenti.isEmpty()) 
			this.student = this.studenti.get(0);
	}
	
	public void abandon(ActionEvent e) {
		if (!em.getTransaction().isActive())
			em.getTransaction().begin();
		
		this.em.getTransaction().rollback();
		
		if (this.em.contains(this.student))
			this.em.refresh(this.student);
		else
			init();
		}
	
	
	public void salveazaStudent(ActionEvent e) {
		try {
		em.getTransaction().begin();
		em.merge(this.student);
		em.getTransaction().commit();
		}catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}
	
	public void prevStudent(ActionEvent e) {
		Integer poz=this.studenti.indexOf(this.student);
		if(poz-1>=0)
			this.student=this.studenti.get(poz-1);
	}
	public void nextStudent(ActionEvent e) {
		Integer poz=this.studenti.indexOf(this.student);
		if(poz+1<this.studenti.size())
			this.student=this.studenti.get(poz+1);
	}
	
	public void adaugaCurs(ActionEvent e) {
		Curs curs = new Curs(null, "denumire", 0);
		this.student.adaugaCurs(curs);
	}
	
	public void stergeCurs(ActionEvent e) {
		Curs cursSelectat = this.cursuriDataModel.getRowData();
		this.student.stergeCurs(cursSelectat);
	}
	
	
	//getters si setters
	public StudentIF getStudent() {
		return student;
	}

	public void setStudent(StudentIF student) {
		this.student = student;
	}

	public List<StudentIF> getStudenti() {
		return studenti;
	}

	public void setStudenti(List<StudentIF> studenti) {
		this.studenti = studenti;
	}
	
	

	
	
	public Integer getMatricolStudent() {
		return this.student.getNumarMatricol();
	}
	
	public void setMatricolStudent(Integer matricol) {
		Integer poz = this.studenti.indexOf(new StudentIF(matricol,null, null, null, null));
		this.student = this.studenti.get(poz);
	}

	public DataModel<Curs> getCursuriDataModel() {
		this.cursuriDataModel = new ListDataModel<Curs>(this.student.getCursuri());
		return cursuriDataModel;
	}

	public void setCursuriDataModel(DataModel<Curs> cursuriDataModel) {
		this.cursuriDataModel = cursuriDataModel;
	}
	
	
}
