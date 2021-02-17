package studentiJPAC;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import factories.Cursuri;
import factories.ProfesorFactory;
import factories.StudentIDFactory;
import factories.StudentIFFactory;


public class Test1_Persistence {
	
	public static String PROJECT_NAME = "studentiJPA";
	public static Random random = new Random();

	
	public static void main(String[] args) throws ParseException {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(PROJECT_NAME);
		EntityManager em = emf.createEntityManager();
		
		//creare cursuri si populare tabela curs
		em.getTransaction().begin();
		ArrayList<Curs> cursuri = Cursuri.getCursuri();
		int x = 1;
		for(Curs curs: cursuri) {
			curs.setSuportCurs(new SuportCurs(curs.getDenumire(), "Autor "  + x++));
			em.persist(curs);
		}
		em.getTransaction().commit();
		
		//creare burse
		List<Bursa> burse = new ArrayList<Bursa>();
		burse.add(new Bursa(TipBursa.S1, 650));
		burse.add(new Bursa(TipBursa.S2, 580));
		burse.add(new Bursa(TipBursa.FARA_BURSA, 0));
		
		
		//creare profesori si populare tabela profesor
		em.getTransaction().begin();
		for (int i = 0; i < 15; i++) {
			Profesor profesor = ProfesorFactory.createProfesor();
			while(profesor.getCursuri().size() < 3) {
				int index = random.nextInt(cursuri.size());
				if(!profesor.getCursuri().contains(cursuri.get(index)))
					profesor.adaugaCurs(cursuri.get(index));
			}
			em.persist(profesor);
		}
		em.getTransaction().commit();
		
		 
		
		//creare studentiIF si populare tabela studentiif
		em.getTransaction().begin();
		
		for (int i = 0; i < 25; i++) {
			StudentIF student = StudentIFFactory.createStudent();
			student.adaugaCurs(cursuri.get(cursuri.size()-1));
			student.setBursa(burse.get(random.nextInt(burse.size())));
			
			while(student.getCursuri().size() < 6) {
				int index = random.nextInt(cursuri.size());
				if(!student.getCursuri().contains(cursuri.get(index)))
					student.adaugaCurs(cursuri.get(index));
			}
			em.persist(student);
		}
		em.getTransaction().commit();
		
		
		//creare studentiID si populare tabela studentiid
		em.getTransaction().begin();

		for (int i = 0; i < 10; i++) {
			StudentID student = StudentIDFactory.createStudent();
			student.adaugaCurs(cursuri.get(cursuri.size()-1));

			while(student.getCursuri().size() < 6) {
				int index = random.nextInt(cursuri.size());
				if(!student.getCursuri().contains(cursuri.get(index)))
					student.adaugaCurs(cursuri.get(index));
			}
			em.persist(student);
		}
		em.getTransaction().commit();
		
		// find si remove 
		em.getTransaction().begin();
		@SuppressWarnings("unchecked")
		StudentIF s1 = (StudentIF) em.createQuery("Select s from StudentIF s where s.numarMatricol = 1001").getSingleResult();
		@SuppressWarnings("unchecked")
		Stream<StudentIF> studenti = em.createQuery("Select s from StudentIF s", StudentIF.class).getResultStream();
		StudentIF s2 = studenti.filter(st -> st.getNumarMatricol() == 1002).collect(toSingleton());
		StudentIF s3 = em.find(StudentIF.class, 1003);
		StudentID s4 = em.find(StudentID.class, 2001);
		System.out.println(s1 + "\n" + s2 + "\n" + s3 + "\n" + s4);
		em.remove(s1);
		em.remove(s2);
		em.getTransaction().commit();
		
		//find si update
		em.getTransaction().begin();
		StudentIF s5 = (StudentIF) em.createQuery("Select s from StudentIF s where s.numarMatricol = 1005").getSingleResult();
		s5.setNume("student 5 -modificat");
		em.getTransaction().commit();
	}
	
	
	public static <T> Collector<T, ?, T> toSingleton() {
	    return Collectors.collectingAndThen(
	            Collectors.toList(),
	            list -> {
	                if (list.size() != 1) {
	                    throw new IllegalStateException();
	                }
	                return list.get(0);
	            }
	    );
	}

}
