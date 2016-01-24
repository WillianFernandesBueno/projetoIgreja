package DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;



import javax.persistence.Query;

import org.hibernate.Session;

import entidades.Usuario;

public class UsuarioDAOHibernate implements UsuarioDAO{
	private EntityManager em;
	
	public UsuarioDAOHibernate() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("sistemaIgreja");  
		em = factory.createEntityManager();
	}
	public void close() {
		em.close();
	}
	
	public void inserir(Usuario usuario) {	
		em.getTransaction().begin(); // abre uma transação
		try {
			usuario = em.merge(usuario); // persiste o objeto e devolve-o sincronizado
			em.getTransaction().commit(); // encerra a transação
			em.refresh(usuario); // atualiza a referência do objeto
		} catch (Exception e) {
			em.getTransaction().rollback(); // desfaz a transação
		}
	}

	public void atualizar(Usuario usuario) {
		em.getTransaction().begin(); // abre uma transação
		try {
			usuario = em.merge(usuario); // persiste o objeto e devolve-o sincronizado
			em.getTransaction().commit(); // encerra a transação
			em.refresh(usuario); // atualiza a referência do objeto
		} catch (Exception e) {
			em.getTransaction().rollback(); // desfaz a transação

		}
	}

	public void excluir(Usuario usuario) {
		em.getTransaction().begin(); // abre uma transação
		try {
			// atualiza a referência do objeto antes de removê-lo
			Usuario ref = em.find(Usuario.class, usuario.getId());
			em.remove(ref); // remove o objeto
			em.getTransaction().commit(); // encerra a transação
		} catch (Exception e) {
			em.getTransaction().rollback(); // desfaz a transação
		}
	}



	public Usuario obterPorChave(String login) {
		Query qry = em.createQuery("select u from Usuario u where u.login = :param1");
		qry.setParameter("param1", login);
		return (Usuario) qry.getSingleResult();
	}

	public Usuario obterPorLoginSenha(String login, String senha) {
		Query qry = em.createQuery("select u from Usuario u where u.login = :param1 and u.senha = :param2");
		qry.setParameter("param1", login);
		qry.setParameter("param2", senha);
		return (Usuario) qry.getSingleResult();
	}
	@Override
	public Usuario pesquisarPorCodigo(String codigoString) {
		return null;
	}
	
	@Override
	public List<Usuario> obterTodos() {
//		Query qry = em.createQuery("from igreja");
//		return qry.getResultList();
		Query qry = em.createQuery("from Usuario");
		return qry.getResultList();
	}
	
	@Override
	public List<Usuario> buscar(String nome) {
		Query qry = em.createQuery("select u from Usuario u where u.nome like :param1");
		qry.setParameter("param1", "%"+nome+"%");
		return qry.getResultList();

	}
	@Override
	public Usuario buscar2(String id) {
		Query qry = em.createQuery("select u from Usuario u where u.nome like :param1");
		qry.setParameter("param1", "%"+id+"%");
		return (Usuario) qry.getSingleResult();
	}
}
