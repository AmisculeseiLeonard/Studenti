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
import studentiJPAC.Profesor;


public class FormCurs {
	private Curs curs;
	private List<Curs> cursuri = new ArrayList<Curs>();
	private EntityManager em;
	private DataModel<Profesor> profesoriDataModel;
	
	public FormCurs() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("studentiJPA");
		em = emf.createEntityManager();
		init();
	}
	
	@SuppressWarnings("unchecked")
	public void init() {
		this.cursuri = em.createQuery("select c from Curs c order by c.id asc").getResultList();
		this.curs = this.cursuri.get(0);
	}
	
	public void adaugaCurs(ActionEvent e) {
		this.curs = new Curs(40, "Proiectarea sistemelor informationale", 6);
		this.cursuri.add(curs);
	}
	
	public void stergeCurs(ActionEvent e) {
		this.cursuri.remove(this.curs);
		em.getTransaction().begin();
		em.remove(this.curs);
		em.getTransaction().commit();
		if(!this.cursuri.isEmpty()) 
			this.curs = this.cursuri.get(0);
	}
	
	public void abandon(ActionEvent e) {
		if (!em.getTransaction().isActive())
			em.getTransaction().begin();
		
		this.em.getTransaction().rollback();
		
		if (this.em.contains(this.curs))
			this.em.refresh(this.curs);
		else
			init();
		}
	
	
	public void salveazaCurs(ActionEvent e) {
		try {
			em.getTransaction().begin();
			em.merge(this.curs);
			em.getTransaction().commit();
		} catch (Exception e2) {
			System.out.println(e2.getMessage());
		}finally {
			init();
		}
		
	}
	
	public void prevCurs(ActionEvent e) {
		Integer poz=this.cursuri.indexOf(this.curs);
		if(poz-1>=0)
			this.curs=this.cursuri.get(poz-1);
	}
	public void nextCurs(ActionEvent e) {
		Integer poz=this.cursuri.indexOf(this.curs);
		if(poz+1<this.cursuri.size())
			this.curs=this.cursuri.get(poz+1);
	}
	
	public void adaugaProfesor(ActionEvent e) {
		@SuppressWarnings("deprecation")
		Profesor profesor = new Profesor(null, "Profesor 41", new Date("10/10/1997"));
		this.curs.adaugaProfesor(profesor);
	}
	
	public void stergeProfesor(ActionEvent e) {
		Profesor profesorSelectat = this.profesoriDataModel.getRowData();
		this.curs.stergeProfesor(profesorSelectat);
	}

	
	//Getters si Setters
	public Curs getCurs() {
		return curs;
	}

	public void setCurs(Curs curs) {
		this.curs = curs;
	}

	public List<Curs> getCursuri() {
		return cursuri;
	}

	public void setCursuri(List<Curs> cursuri) {
		this.cursuri = cursuri;
	}
	
	
	public Integer getIdProf() {
		return this.curs.getId();
	}
	
	public void setIdProf(Integer id) {
		Integer poz = this.cursuri.indexOf(new Curs(id, null, null));
		this.curs = this.cursuri.get(poz);
	}
	
	
	public DataModel<Profesor> getProfDataModel() {
		this.profesoriDataModel = new ListDataModel<Profesor>(this.curs.getProfesori());
		return profesoriDataModel;
	}

	public void setCursuriDataModel(DataModel<Profesor> pDataModel) {
		this.profesoriDataModel = pDataModel;
	}
}
