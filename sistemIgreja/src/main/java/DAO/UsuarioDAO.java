package DAO;


import interfaces.LoginDAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import entidades.Usuario;

public class UsuarioDAO implements LoginDAO<Usuario>{
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

}
