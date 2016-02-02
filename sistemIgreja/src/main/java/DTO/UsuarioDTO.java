package DTO;

import java.util.List;

import DAO.UsuarioDAO;
import entidades.Igreja;
import entidades.Usuario;

public class UsuarioDTO {
	UsuarioDAO usuarioDao = new UsuarioDAO();
	
	public Usuario buscar(String usuario, String senha) {
		return usuarioDao.pesquisaUsuario(usuario,senha);
	}
	public void inserir(Usuario usuario){
		usuarioDao.inserir(usuario);
	}
	public List<Usuario> buscarUsuarios(Igreja igreja) {
		return usuarioDao.buscarUsuarios(igreja);
	}
	public void excluir(Usuario usuarioSelecionado) {
		usuarioDao.excluir(usuarioSelecionado);
	}

}
