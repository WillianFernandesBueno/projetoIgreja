package controller;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.event.FlowEvent;

import util.FacesUtil;
import DAO.UsuarioHIB;
import bean.Usuario;

@ManagedBean
@ViewScoped
public class UserWizard implements Serializable {
	private Usuario usuario;
    private boolean skip;
  
    public UserWizard() {
		usuario = new Usuario();
		/*
		 * aqui vou ter que popular a lista de igrejas
		 */
        System.out.println("lista de igrejas");
	}

	public Usuario getUser() {
		return usuario;
    }
 
    public void setUser(Usuario user) {
        this.usuario = user;
    }
     
    public void save() {     
    	UsuarioHIB uh = new UsuarioHIB();
    	uh.save(usuario);
    	FacesUtil.addMsgInfo(usuario.getNome()+" cadastrado com sucesso");
//        try {
//			FacesContext.getCurrentInstance().getExternalContext().redirect("pessoaPesquisa.xhtml");
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
    }
     
    public boolean isSkip() {
        return skip;
    }
 
    public void setSkip(boolean skip) {
        this.skip = skip;
    }
        
    public String onFlowProcess(FlowEvent event) {
        if(skip) {
            skip = false;   //reset in case user goes back
            return "confirm";
        }
        else {
            return event.getNewStep();
        }
    }
}