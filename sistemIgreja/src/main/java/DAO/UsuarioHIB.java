package DAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


import bean.Usuario;

public class UsuarioHIB {
	public boolean save(Usuario t) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("sistemaIgreja");  
		EntityManager em = factory.createEntityManager();  
		em.getTransaction().begin();  
		em.persist(t);  
		em.getTransaction().commit();
		return false;
	}
}
