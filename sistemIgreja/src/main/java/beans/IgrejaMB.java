package beans;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.event.FlowEvent;

import entidades.Igreja;
import util.FacesUtil;
import DAO.IgrejaDAO;

@ManagedBean
@ViewScoped
public class IgrejaMB implements Serializable {
	private static final long serialVersionUID = 1L;
	private Igreja igreja;
	
	public IgrejaMB() {
		igreja = new Igreja();	
		/*
		 * aqui vou ter que popular a lista de igrejas
		 */
	}	
	public Igreja getIgreja() {
		return igreja;
	}
	public void setIgreja(Igreja igreja) {
		this.igreja = igreja;
	}
	
	public void save() { 
		new IgrejaDAO().save(igreja);
		FacesUtil.addMsgInfo(igreja.getNome()+" cadastrado com sucesso TESTE");
	}
}