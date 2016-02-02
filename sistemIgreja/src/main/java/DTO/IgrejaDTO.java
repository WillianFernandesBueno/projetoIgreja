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
	
	public List<Igreja> buscarSede(String busca) {
		return igrejaDAO.buscarSede(busca);
	}
	
	public List<Igreja> buscarCongregacao(String busca) {
		return igrejaDAO.buscarCongregacao(busca);
	}
	
	public List<Igreja> listarIgrejas() {
		return igrejaDAO.listarIgrejas();
	}
	
	public List<Igreja> listarSedes() {
		return igrejaDAO.listarSedes();
	}
	
	public List<Igreja> listarCongregacao(Igreja igreja) {
		return igrejaDAO.listarCongregacao(igreja);
	}
	
	public void excluir(Igreja igrejaSelecionado) {
		igrejaDAO.excluir(igrejaSelecionado);
		
	}

	
}
