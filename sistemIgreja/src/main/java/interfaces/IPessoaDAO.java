package interfaces;

import java.util.List;

import entidades.Igreja;


public interface IPessoaDAO<T> {
	public void inserir(T pessoa);
	public void excluir(T pessoaSelecionado);
	public List<T> buscar(String nome);
	public List<T> ListarPessoas(Igreja igreja); ;
	public List<T> ListarPessoas(); 
}
