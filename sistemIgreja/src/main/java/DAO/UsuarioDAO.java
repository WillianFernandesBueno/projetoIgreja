package DAO;




import java.util.List;

import interfaces.ILoginDAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import entidades.Igreja;
import entidades.Pessoa;
import entidades.Usuario;

public class UsuarioDAO implements ILoginDAO<Usuario>{
	private EntityManager em;

	public UsuarioDAO() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("sistemaIgreja");  
		em = factory.createEntityManager();
	}
	@Override
	public Usuario pesquisaUsuario(String usuario, String senha) {
		Query qry = em.createQuery("select u from Usuario u where u.usuario = :param1");
		qry.setParameter("param1", usuario);
		try{
			return (Usuario) qry.getSingleResult();
		}catch (NoResultException nre){
			return null;
		}

	}
	@Override
	public void inserir(Usuario t) {
		em.getTransaction().begin();
		try {
			t = em.merge(t);
			em.getTransaction().commit(); 
			em.refresh(t);
		} catch (Exception e) {
			em.getTransaction().rollback();
		}

	}
	@Override
	public List<Usuario> buscarUsuarios(Igreja t) {
		System.out.println(t.getId());
		TypedQuery<Usuario> query = em.createNamedQuery("USUARIO.LISTARUSUARIOS", Usuario.class); 
		query.setParameter("id", t.getId());
		return query.getResultList();
	}
	@Override
	public void excluir(Usuario t) {
		em.getTransaction().begin(); // abre uma transação
		try {
			// atualiza a referência do objeto antes de removê-lo
			Usuario ref = em.find(Usuario.class, t.getId());
			em.remove(ref); // remove o objeto
			em.getTransaction().commit(); // encerra a transação
			em.close();
		} catch (Exception e) {
			em.getTransaction().rollback(); // desfaz a transação
		}
	}
}
