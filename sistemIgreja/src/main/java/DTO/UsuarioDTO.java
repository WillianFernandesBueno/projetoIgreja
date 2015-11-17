package DTO;

import java.util.List;

import DAO.UsuarioDAO;
import DAO.UsuarioDAOHibernate;
import bean.Usuario;

public class UsuarioDTO{
	UsuarioDAO usuarioDao = new UsuarioDAOHibernate();
	public Usuario pesquisarPorCodigo(String codigoString) {
		return this.usuarioDao.pesquisarPorCodigo(codigoString);
		
	}
	public void inserir(Usuario usuario) {
		usuarioDao.inserir(usuario);
	}
	
	public List<Usuario> obterTodos() {
		return usuarioDao.obterTodos();
	}

}
