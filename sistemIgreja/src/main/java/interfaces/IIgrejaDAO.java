package interfaces;

import java.util.List;

import entidades.Igreja;

public interface IIgrejaDAO<T> {
	public void inserir(T pessoa);
	public List<T> buscar(String nome);
	public List<T> buscarSede(String nome);
	public List<T> buscarCongregacao(String nome);
	public void excluir(T pessoaSelecionado);
	public List<T> listarIgrejas(); 
	public List<Igreja> listarSedes();
	public List<Igreja> listarCongregacao(T t);
}
