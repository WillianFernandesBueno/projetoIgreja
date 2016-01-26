package DTO;

import DAO.UsuarioDAO;
import DAO.UsuarioDAOHibernate;
import entidades.Usuario;

public class UsuarioDTO {
	UsuarioDAO usuarioDao = new UsuarioDAOHibernate();
	public Usuario buscar(String usuario, String senha) {
		return usuarioDao.pesquisaUsuario(usuario,senha);
	}

}
