package interfaces;

import java.util.List;

import entidades.Igreja;
import entidades.Pessoa;

public interface DAO<T> {
	public void inserir(T pessoa);
	public List<T> obterTodos(); 
	List<Igreja> obterTodasCongregacoes(T t);
	public List<T> buscar(String nome);
	public void excluir(T pessoaSelecionado);
}
