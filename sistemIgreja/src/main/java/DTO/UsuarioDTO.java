package DTO;

import DAO.UsuarioDAO;
import entidades.Usuario;

public class UsuarioDTO {
	UsuarioDAO usuarioDao = new UsuarioDAO();
	public Usuario buscar(String usuario, String senha) {
		return usuarioDao.pesquisaUsuario(usuario,senha);
	}

}
