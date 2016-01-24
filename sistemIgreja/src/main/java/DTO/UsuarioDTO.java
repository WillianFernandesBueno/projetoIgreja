package DTO;

import java.util.List;

import entidades.Usuario;
import DAO.UsuarioDAO;
import DAO.UsuarioDAOHibernate;

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
	
	public List<Usuario> buscar(String nome){
		return usuarioDao.buscar(nome);
	}
	
	public Usuario buscar2(String nome){
		return usuarioDao.buscar2(nome);
	}
	public void excluir(Usuario usuarioSelecionado) {
		usuarioDao.excluir(usuarioSelecionado);
		
	}
	
}
