package interfaces;


import entidades.Usuario;

public interface LoginDAO<T> {
	public Usuario pesquisaUsuario(String usuario, String senha);
}
