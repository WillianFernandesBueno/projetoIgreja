package DAO;


import interfaces.IIgrejaDAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import entidades.Igreja;

public class IgrejaDAO implements IIgrejaDAO<Igreja> {
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
	@Override
	public List<Igreja> buscar(String nome) {
		Query qry = em.createQuery("select u from Igreja u where u.nome like :param1");
		qry.setParameter("param1", "%"+nome+"%");
		return qry.getResultList();
	}
	
	@Override
	public List<Igreja> buscarSede(String nome) {
		Query qry = em.createQuery("select u from Igreja u where u.nome like :param1  and u.sede = true");
		qry.setParameter("param1", "%"+nome+"%");
		return qry.getResultList();
	}
	@Override
	public List<Igreja> buscarCongregacao(String nome) {
		Query qry = em.createQuery("select u from Igreja u where u.nome like :param1  and u.sede = false");
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
	public List<Igreja> listarCongregacao(Igreja igreja) {
		//Query query = em.createNativeQuery("select i from Igreja i where i.igreja_id = "+igreja.getId());
		TypedQuery<Igreja> query = em.createNamedQuery("IGREJA.LISTARCOONGREGACAO", Igreja.class); 
		query.setParameter("id", igreja.getId());
		List<Igreja> resultado = query.getResultList();
		return query.getResultList();
	}
	@Override
	public List<Igreja> listarSedes() {
		Query qry = em.createQuery("select i from Igreja i where i.sede = true");
		return qry.getResultList();
	}
	@Override
	public List<Igreja> listarIgrejas() {
		Query qry = em.createQuery("from Igreja");
		return qry.getResultList();
	}

}
