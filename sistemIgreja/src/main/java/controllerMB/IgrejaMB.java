package controllerMB;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.event.FlowEvent;
import org.primefaces.model.UploadedFile;

import util.FacesUtil;
import util.UploadArquivo;
import util.Util;
import DAO.UsuarioHIB;
import bean.Usuario;

@ManagedBean
@ViewScoped
public class IgrejaMB implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final String DIRETORIO = "/resources/fotos/";
	private static final String DIRETORIOBACKUP = "C:/Users/Willian Bueno/Projetos/imagens/";
	private Usuario usuario;
	private boolean skip;
	private UploadArquivo arquivo;
	private UploadedFile file;



	public IgrejaMB() {
		usuario = new Usuario();
		/*
		 * aqui vou ter que popular a lista de igrejas
		 */
		System.out.println("lista de igrejas");
	}
	public UploadedFile getFile() {
		return file;
	}

	public void setFile(UploadedFile file) {
		this.file = file;
	}
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public UploadArquivo getArquivo() {
		return arquivo;
	}

	public void setArquivo(UploadArquivo arquivo) {
		this.arquivo = arquivo;
	}

	//fileUpload irá fazer o carregamento do arquivo e prepara-lo para ser gravado.
	public void uploadAction (FileUploadEvent event){
		arquivo = new UploadArquivo();
		this.arquivo.fileUpload(event, ".jpg", DIRETORIO,DIRETORIOBACKUP);
		usuario.setFoto(this.arquivo.getNome());
		System.out.println(arquivo.getNome());
		System.out.println(usuario.getFoto());
		this.arquivo.gravar();
		System.out.println("---------------------------");
	}

	public void save() { 
		new UsuarioHIB().save(usuario);
		FacesUtil.addMsgInfo(usuario.getNome()+" cadastrado com sucesso");
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

	public String retornaFoto() {
		if (this.usuario != null) {
			System.out.println("teste willian");
			if (this.usuario.getFoto() != null) {
				System.out.println("/resources/fotos/" + this.usuario.getFoto());
				return "/resources/fotos/" + this.usuario.getFoto();
			} else {
				return "/resources/fotos/foto.gif";
			}
		}
		System.out.println("teste3");
		return "/resources/fotos/foto.gif";
	}

}