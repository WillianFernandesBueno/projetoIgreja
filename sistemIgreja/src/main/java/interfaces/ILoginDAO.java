package interfaces;



import java.util.List;

import entidades.Igreja;
import entidades.Usuario;

public interface ILoginDAO<T> {
	public List<T> buscarUsuarios(Igreja igreja);
	public Usuario pesquisaUsuario(String usuario, String senha);
	public void inserir(T t);
	public void excluir(T t) ;
}
