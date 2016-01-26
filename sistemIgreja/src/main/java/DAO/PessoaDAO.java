package DAO;

import java.util.List;

import entidades.Pessoa;

public interface PessoaDAO {
	Pessoa pesquisarPorCodigo(String codigoString);
	void inserir(Pessoa pessoa);
	List<Pessoa> obterTodos(); 
	List<Pessoa> buscar(String nome);
	Pessoa buscar2(String nome);
	void excluir(Pessoa pessoaSelecionado);

}
