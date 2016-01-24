/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import DAO.IgrejaDAO;
import DTO.UsuarioDTO;
import entidades.Igreja;
import entidades.Usuario;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.context.RequestContext;
import org.primefaces.event.FlowEvent;

import util.Util;

/**
 *
 * @author Willian Bueno
 */
@ManagedBean
@ViewScoped
public class UsuarioBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private Usuario usuario;
    private Usuario usuarioSelecionado;
    private List<Usuario> usuarios;
    private boolean ver;
    private String texto;
    private boolean skip;
    private List<Igreja> igrejas;
	private Igreja igreja;
	
    @PostConstruct
    public void init() {
        listar();
    }


	public void buscar() {
		usuarios = new UsuarioDTO().buscar(getTexto());
	}
	
    private void listar() {
        this.usuarioSelecionado = new Usuario();
        setUsuarios(new UsuarioDTO().obterTodos());
    }

    public void salvar() {
    		new UsuarioDTO().inserir(getUsuario());
            listar();
            Util.atualizarForm("usuario");
            Util.executarJavaScript("PF('dlgcadastrar').hide();");
            resetarFormulario();
    }

    public void inserir() {
    	this.usuario = new Usuario();
    	System.out.println(usuario.getNome());
    	this.igreja = new Igreja();
		this.igrejas = new ArrayList<Igreja>(new IgrejaDAO().obterTodos());
    }

    public void resetarFormulario() {
        Util.resetarFormulario("cadastrar");
    }

	public String onFlowProcess(FlowEvent event) {
		if (skip) {
			skip = false; // reset in case user goes back
			return "confirm";
		} else {
			return event.getNewStep();
		}
	}
    
    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public Usuario getUsuarioSelecionado() {
        return usuarioSelecionado;
    }

    public void setUsuarioSelecionado(Usuario usuarioSelecionado) {
        this.usuarioSelecionado = usuarioSelecionado;
    }

    public boolean isVer() {
        return ver;
    }

    public void setVer(boolean ver) {
        this.ver = ver;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

	public boolean isSkip() {
		return skip;
	}

	public void setSkip(boolean skip) {
		this.skip = skip;
	}


	public List<Igreja> getIgrejas() {
		return igrejas;
	}


	public void setIgrejas(List<Igreja> igrejas) {
		this.igrejas = igrejas;
	}


	public Igreja getIgreja() {
		return igreja;
	}


	public void setIgreja(Igreja igreja) {
		this.igreja = igreja;
	}
    
	

}
