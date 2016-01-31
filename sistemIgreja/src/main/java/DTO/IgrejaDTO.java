package DTO;

import java.util.List;

import entidades.Igreja;
import DAO.IgrejaDAO;

public class IgrejaDTO {
	IgrejaDAO igrejaDAO = new IgrejaDAO();
	public void inserir(Igreja igreja){
		igrejaDAO.inserir(igreja);
	}
	public List<Igreja> buscar(String busca) {
		return igrejaDAO.buscar(busca);
	}
	public List<Igreja> obterTodos() {
		return igrejaDAO.obterTodos();
	}
	
	public List<Igreja> obterTodasCongregacoes(Igreja igreja) {
		return igrejaDAO.obterTodasCongregacoes(igreja);
	}
	
	public void excluir(Igreja igrejaSelecionado) {
		igrejaDAO.excluir(igrejaSelecionado);
		
	}
	
}
