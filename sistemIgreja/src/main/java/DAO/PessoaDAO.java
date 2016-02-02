package DAO;

import interfaces.IPessoaDAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;



import javax.persistence.Query;




import javax.persistence.TypedQuery;

import entidades.Igreja;
import entidades.Pessoa;

public class PessoaDAO implements IPessoaDAO<Pessoa>{
	private EntityManager em;

	public PessoaDAO() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("sistemaIgreja");  
		em = factory.createEntityManager();
	}
	public void close() {
		em.close();
	}

	public void inserir(Pessoa pessoa) {	
		em.getTransaction().begin(); // abre uma transação
		try {
			pessoa = em.merge(pessoa); // persiste o objeto e devolve-o sincronizado
			em.getTransaction().commit(); // encerra a transação
			em.refresh(pessoa); // atualiza a referência do objeto
		} catch (Exception e) {
			em.getTransaction().rollback(); // desfaz a transação
		}
	}

	public void atualizar(Pessoa pessoa) {
		em.getTransaction().begin(); // abre uma transação
		try {
			pessoa = em.merge(pessoa); // persiste o objeto e devolve-o sincronizado
			em.getTransaction().commit(); // encerra a transação
			em.refresh(pessoa); // atualiza a referência do objeto
		} catch (Exception e) {
			em.getTransaction().rollback(); // desfaz a transação

		}
	}

	public void excluir(Pessoa pessoa) {
		em.getTransaction().begin(); // abre uma transação
		try {
			// atualiza a referência do objeto antes de removê-lo
			Pessoa ref = em.find(Pessoa.class, pessoa.getId());
			em.remove(ref); // remove o objeto
			em.getTransaction().commit(); // encerra a transação
			em.close();
		} catch (Exception e) {
			em.getTransaction().rollback(); // desfaz a transação
		}
	}



	public Pessoa obterPorChave(String login) {
		Query qry = em.createQuery("select u from Pessoa u where u.login = :param1");
		qry.setParameter("param1", login);
		return (Pessoa) qry.getSingleResult();
	}

	public Pessoa obterPorLoginSenha(String login, String senha) {
		Query qry = em.createQuery("select u from Pessoa u where u.login = :param1 and u.senha = :param2");
		qry.setParameter("param1", login);
		qry.setParameter("param2", senha);
		return (Pessoa) qry.getSingleResult();
	}

	@Override
	public List<Pessoa> ListarPessoas(Igreja igreja) {
		TypedQuery<Pessoa> query = em.createNamedQuery("PESSOA.LISTARPESSOA", Pessoa.class); 
		query.setParameter("id", igreja.getId());
		List<Pessoa> resultado = query.getResultList();
		return query.getResultList();

		//		Query qry = em.createQuery("from igreja");
		//		return qry.getResultList();
		//		Query qry = em.createQuery("from Pessoa");
		//		return qry.getResultList();
	}

	@Override
	public List<Pessoa> buscar(String nome) {
		Query qry = em.createQuery("select u from Pessoa u where u.nome like :param1");
		qry.setParameter("param1", "%"+nome+"%");
		return qry.getResultList();

	}
	@Override
	public List<Pessoa> ListarPessoas() {
		Query qry = em.createQuery("from Pessoa");
		return qry.getResultList();
	}


}
