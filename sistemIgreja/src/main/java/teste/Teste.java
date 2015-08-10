package teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import bean.Usuario;

public class Teste {
	public static void teste(){
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("sistemIgreja");
		EntityManager manager = factory.createEntityManager();
		EntityTransaction trx = manager.getTransaction();
		trx.begin();
		Usuario usuario = new Usuario();
		usuario.setNome("willian testando");
		trx.commit();
	}
}
