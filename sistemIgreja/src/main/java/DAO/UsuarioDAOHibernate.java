package DAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import entidades.Pessoa;
import entidades.Usuario;

public class UsuarioDAOHibernate implements UsuarioDAO{
	private EntityManager em;

	public UsuarioDAOHibernate() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("sistemaIgreja");  
		em = factory.createEntityManager();
	}
	@Override
	public Usuario pesquisaUsuario(String usuario, String senha) {
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++");
		System.out.println(usuario+" | "+senha);
		//Query qry = em.createQuery("SELECT vo FROM Usuario vo WHERE vo.usuario = '" + usuario + "'");
		Query qry = em.createQuery("select u from Usuario u where u.usuario = :param1");
		qry.setParameter("param1", usuario);
		try{
		return (Usuario) qry.getSingleResult();
		}catch (NoResultException nre){
			return null;
		}
		
	}

}
