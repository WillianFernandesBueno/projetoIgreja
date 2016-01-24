package DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import entidades.Igreja;

public class IgrejaDAO {
	private EntityManager em;
	public IgrejaDAO() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("sistemaIgreja");  
		em = factory.createEntityManager();
	}
	public void close() {
		em.close();
	}
	public boolean save(Igreja t) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("sistemaIgreja");  
		EntityManager em = factory.createEntityManager();  
		em.getTransaction().begin();  
		em.persist(t);  
		em.getTransaction().commit();
		return false;
	}
	public List<Igreja> obterTodos() {
		Query qry = em.createQuery("from Igreja");
		return qry.getResultList();
	}
}
