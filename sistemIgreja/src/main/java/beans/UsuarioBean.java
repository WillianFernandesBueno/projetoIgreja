package beans;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import util.Util;
import DAO.IgrejaDAO;
import entidades.Igreja;
import entidades.Usuario;

@ManagedBean
@ViewScoped
public class UsuarioBean {
	private Usuario usuario;
	private List<Igreja> igrejas;
	private boolean ver;
	@PostConstruct
	public void init(){
	}
	
	public void cadastrar(){
		listar();

		if(getIgrejas().isEmpty() && getIgrejas().size()<1){
			setVer(false);
			Util.criarAvisoErro("Não existe igreja para vincular o usuario! por favor cadastre uma igreja");
		}else{
			setVer(true);
			this.usuario = new Usuario();			
		}
	}
	
	private void listar() {
		this.igrejas = new ArrayList<Igreja>(new IgrejaDAO().obterTodos());
	}

	public void salvar(){
	}
	
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<Igreja> getIgrejas() {
		return igrejas;
	}

	public void setIgrejas(List<Igreja> igrejas) {
		this.igrejas = igrejas;
	}

	public boolean isVer() {
		return ver;
	}

	public void setVer(boolean ver) {
		this.ver = ver;
	}
	
	
	
	
}
