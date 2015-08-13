package controllerMB;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.event.FlowEvent;

import util.FacesUtil;
import util.UploadArquivo;
import DAO.UsuarioHIB;
import bean.Usuario;

@ManagedBean
@ViewScoped
public class userWizardUsuario implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final String DIRETORIO = "/image/";
	private static final String DIRETORIOBACKUP = "C:/Users/Willian Bueno/Projetos/imagens/";
	private Usuario usuario;
	private boolean skip;
	private UploadArquivo arquivo;
	
	public userWizardUsuario() {
		usuario = new Usuario();
		/*
		 * aqui vou ter que popular a lista de igrejas
		 */
		System.out.println("lista de igrejas");
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
		System.out.println(arquivo.getRealPath());
		System.out.println("*******************************************************");
	}
	
	public void save() { 
		new UsuarioHIB().save(usuario);
		this.arquivo.gravar();
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