package DTO;

import java.util.List;

import entidades.Pessoa;
import DAO.PessoaDAO;
import DAO.PessoaDAOHibernate;

public class PessoaDTO{
	PessoaDAO pessoaDao = new PessoaDAOHibernate();
	
	public Pessoa pesquisarPorCodigo(String codigoString) {
		return this.pessoaDao.pesquisarPorCodigo(codigoString);
		
	}
	public void inserir(Pessoa pessoa) {
		pessoaDao.inserir(pessoa);
	}
	
	public List<Pessoa> obterTodos() {
		return pessoaDao.obterTodos();
	}
	
	public List<Pessoa> buscar(String nome){
		return pessoaDao.buscar(nome);
	}
	
	public Pessoa buscar2(String nome){
		return pessoaDao.buscar2(nome);
	}
	public void excluir(Pessoa pessoaSelecionado) {
		pessoaDao.excluir(pessoaSelecionado);
		
	}
	
}
