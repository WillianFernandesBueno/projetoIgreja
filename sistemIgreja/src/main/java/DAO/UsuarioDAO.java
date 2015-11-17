package DAO;

import java.util.List;

import bean.Usuario;

public interface UsuarioDAO {
	Usuario pesquisarPorCodigo(String codigoString);
	void inserir(Usuario usuario);
	List<Usuario> obterTodos(); 

}
