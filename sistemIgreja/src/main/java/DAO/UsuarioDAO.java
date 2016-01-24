package DAO;

import java.util.List;

import entidades.Usuario;

public interface UsuarioDAO {
	Usuario pesquisarPorCodigo(String codigoString);
	void inserir(Usuario usuario);
	List<Usuario> obterTodos(); 
	List<Usuario> buscar(String nome);
	Usuario buscar2(String nome);
	void excluir(Usuario usuarioSelecionado);

}
