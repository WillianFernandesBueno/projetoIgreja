package DAO;

import entidades.Usuario;

public interface UsuarioDAO {

	Usuario pesquisaUsuario(String usuario, String senha);

}
