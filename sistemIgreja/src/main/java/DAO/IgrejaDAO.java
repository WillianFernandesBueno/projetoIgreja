package DAO;

import interfaces.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import entidades.Igreja;

public class IgrejaDAO implements DAO<Igreja> {
	private EntityManager em;
	public IgrejaDAO() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("sistemaIgreja");  
		em = factory.createEntityManager();
	}
	public void close() {
		em.close();
	}

	@Override
	public void inserir(Igreja igreja) {
		em.getTransaction().begin(); // abre uma transação
		try {
			igreja = em.merge(igreja); // persiste o objeto e devolve-o sincronizado
			em.getTransaction().commit(); // encerra a transação
			em.refresh(igreja); // atualiza a referência do objeto
		} catch (Exception e) {
			em.getTransaction().rollback(); // desfaz a transação
		}

	}

	public List<Igreja> obterTodos() {
		Query qry = em.createQuery("from Igreja");
		return qry.getResultList();
	}

	@Override
	public List<Igreja> buscar(String nome) {
		Query qry = em.createQuery("select u from Igreja u where u.nome like :param1");
		qry.setParameter("param1", "%"+nome+"%");
		return qry.getResultList();
	}
	@Override
	public void excluir(Igreja igreja) {
		em.getTransaction().begin(); // abre uma transação
		try {
			// atualiza a referência do objeto antes de removê-lo
			Igreja ref = em.find(Igreja.class, igreja.getId());
			em.remove(ref); // remove o objeto
			em.getTransaction().commit(); // encerra a transação
			em.close();
		} catch (Exception e) {
			em.getTransaction().rollback(); // desfaz a transação
		}

	}
	@Override
	public List<Igreja> obterTodasCongregacoes(Igreja igreja) {
		Query query = em.createQuery("select i from Igreja i where i.id = :id",Igreja.class);
		query.setParameter("id", "1");
		return query.getResultList();
	}
}
