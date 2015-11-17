package controllerMB;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.event.FlowEvent;

import util.FacesUtil;
import util.UploadArquivo;
import DAO.IgrejaDAO;
import DTO.UsuarioDTO;
import bean.Igreja;
import bean.Usuario;

@ManagedBean
@ViewScoped
public class UsuarioMB {
	private static final String DIRETORIO = "/resources/fotos/";
	private static final String DIRETORIOBACKUP = "C:/Users/Willian Bueno/Projetos/imagens/";
	private UploadArquivo arquivo;
	private Usuario usuario;
	private List<Igreja> igrejas;
	private Igreja igreja;
	private IgrejaDAO igrejaDao;
	private boolean skip;
	

	@PostConstruct
	public void init(){
		System.out.println("====================================================");
		System.out.println("init");
		if(usuario == null){
			System.out.println("==================================================== 2 ");
			System.out.println("init 2");
			arquivo = new UploadArquivo();
			igrejaDao = new IgrejaDAO();
			usuario = new Usuario();
			igreja = new Igreja();
			igrejas = new ArrayList<Igreja>();
			igrejas = (ArrayList<Igreja>) igrejaDao.obterTodos();
		}
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

	public IgrejaDAO getIgrejaDao() {
		return igrejaDao;
	}

	public void setIgrejaDao(IgrejaDAO igrejaDao) {
		this.igrejaDao = igrejaDao;
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
	public boolean isSkip() {
		return skip;
	}

	public void setSkip(boolean skip) {
		this.skip = skip;
	}
	
	/* responsavel por chamar os metodos encarregados de salvar 
	os dados cadastrados do usuario no banco de dados*/
	public void save() throws IOException { 
		this.arquivo.back();
		new UsuarioDTO().inserir(usuario);
		FacesUtil.addMsgInfo(usuario.getNome()+" cadastrado com sucesso TESTE");
		FacesContext.getCurrentInstance().getExternalContext().redirect("pessoaPesquisa.xhtml"); 
	}

	//fileUpload irá fazer o carregamento do arquivo e prepara-lo para ser gravado.
	public void uploadAction (FileUploadEvent event){
		this.arquivo.fileUpload(event, ".jpg", DIRETORIO,DIRETORIOBACKUP);
		usuario.setFoto(this.arquivo.getNome());
		this.arquivo.gravar();
	}
	
	// metodo responsavel por apresentar foto na confirmação do cadastro do usuario
	public String retornaFoto() {
		if (this.usuario != null) {
			if (this.usuario.getFoto() != null) {
				System.out.println("/resources/fotos/" + this.usuario.getFoto());
				return "/resources/fotos/" + this.usuario.getFoto();
			} else {
				return "/resources/fotos/foto.gif";
			}
		}
		return "/resources/fotos/foto.gif";
	}
	
	//metodo especifico do componente wizard do primefaces
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
