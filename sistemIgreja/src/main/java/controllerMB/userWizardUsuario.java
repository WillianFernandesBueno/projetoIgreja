package controllerMB;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.model.SelectItem;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.event.FlowEvent;
import org.primefaces.model.UploadedFile;

import util.FacesUtil;
import util.UploadArquivo;
import DAO.IgrejaDAO;
import DAO.UsuarioDAO;
import DTO.UsuarioDTO;
import bean.Igreja;
import bean.Usuario;

@ManagedBean
@ViewScoped
public class userWizardUsuario implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final String DIRETORIO = "/resources/fotos/";
	private static final String DIRETORIOBACKUP = "C:/Users/Willian Bueno/Projetos/imagens/";
	private Usuario usuario;
	private boolean skip;
	private UploadArquivo arquivo;
	private UploadedFile file;
	List<SelectItem> igrejaSelect;
	List<Igreja> igrejas;

	public userWizardUsuario() {
		usuario = new Usuario();
	}
	
	//fileUpload irá fazer o carregamento do arquivo e prepara-lo para ser gravado.
	public void uploadAction (FileUploadEvent event){
		arquivo = new UploadArquivo();
		this.arquivo.fileUpload(event, ".jpg", DIRETORIO,DIRETORIOBACKUP);
		usuario.setFoto(this.arquivo.getNome());
		System.out.println(arquivo.getNome());
		System.out.println(usuario.getFoto());
		this.arquivo.gravar();
	}

	public void save() { 
		new UsuarioDTO().inserir(usuario);
		FacesUtil.addMsgInfo(usuario.getNome()+" cadastrado com sucesso");
	}

//	public boolean isSkip() {
//		return skip;
//	}
//
//	public void setSkip(boolean skip) {
//		this.skip = skip;
//	}

//	public String onFlowProcess(FlowEvent event) {
//		if(skip) {
//			skip = false;   //reset in case user goes back
//			return "confirm";
//		}
//		else {
//			return event.getNewStep();
//		}
//	}

	public String retornaFoto() {
		if (this.usuario != null) {
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

	public List<SelectItem> getIgrejaSelect() {
		if(igrejaSelect == null){
			IgrejaDAO igrejaDao = new IgrejaDAO();
			igrejas = new ArrayList<Igreja>();
			igrejaSelect = new ArrayList<SelectItem>();
			igrejas = (ArrayList<Igreja>) igrejaDao.obterTodos();
			if(igrejas != null && !igrejas.isEmpty()){
				SelectItem item;
				for (Igreja igreja : igrejas) {
					item = new SelectItem(igreja, igreja.getNome());
					igrejaSelect.add(item);
				}	
			}
		}
		return igrejaSelect;
	}

	public List<Igreja> getIgrejas() {
		return igrejas;
	}
	public void setIgrejas(List<Igreja> igrejas) {
		this.igrejas = igrejas;
	}
	
}