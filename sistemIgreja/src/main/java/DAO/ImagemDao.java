package DAO;

import bean.Imagem;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ImagemDao {
	public void salvar(Imagem produto){
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("sistemaIgreja");  
		EntityManager em = factory.createEntityManager();  
		em.getTransaction().begin();  
		em.persist(produto);  
		em.getTransaction().commit();
		System.out.println("Salvo com sucesso");
	}
}
