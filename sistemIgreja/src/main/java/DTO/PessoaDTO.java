package DTO;

import java.util.List;

import entidades.Pessoa;
import DAO.PessoaDAO;

public class PessoaDTO{
	PessoaDAO pessoaDao = new PessoaDAO();

public void inserir(Pessoa pessoa) {
		pessoaDao.inserir(pessoa);
	}
	
	public List<Pessoa> obterTodos() {
		return pessoaDao.obterTodos();
	}
	
	public List<Pessoa> buscar(String nome){
		return pessoaDao.buscar(nome);
	}

	public void excluir(Pessoa pessoaSelecionado) {
		pessoaDao.excluir(pessoaSelecionado);
		
	}
	
}
