package beans;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.event.FlowEvent;

import entidades.Igreja;
import entidades.Usuario;
import util.FacesUtil;
import util.UploadArquivo;
import DAO.IgrejaDAO;
import DTO.UsuarioDTO;

@ManagedBean
@ViewScoped
public class UserMB {
	/*
	 * ==========================================================================
	 * ==
	 * ========================================================================
	 * ==== variaveis da maneged bean
	 * ============================================
	 * ==============================
	 * ============================================
	 * ==================================
	 */
	private static final String DIRETORIO = "/resources/fotos/";
	private static final String DIRETORIOBACKUP = "C:/Users/Willian Bueno/Projetos/imagens/";
	private Usuario usuario;
	private Usuario usuarioSelecionado;
	private List<Usuario> usuarios;
	private List<Igreja> igrejas;
	private Igreja igreja;
	private IgrejaDAO igrejaDao;
	private UploadArquivo arquivo;
	private String texto;
	private boolean skip;

	@PostConstruct
	public void init() {
		System.out
				.println("==========================================INIT=================================================");
		listar();
		arquivo = new UploadArquivo();
		usuario = new Usuario();
		igreja = new Igreja();
		igrejas = new ArrayList<Igreja>(new IgrejaDAO().obterTodos());
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

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	/*
	 * responsavel por chamar os metodos encarregados de salvar os dados
	 * cadastrados do usuario no banco de dados
	 */
	public void save() throws IOException {
		this.arquivo.back();
		new UsuarioDTO().inserir(usuario);
		FacesUtil.addMsgInfo(usuario.getNome()
				+ " cadastrado com sucesso TESTE");
		FacesContext.getCurrentInstance().getExternalContext()
				.redirect("pessoa.xhtml");
	}

	// fileUpload irá fazer o carregamento do arquivo e prepara-lo para ser
	// gravado.
	public void uploadAction(FileUploadEvent event) {
		this.arquivo.fileUpload(event, ".jpg", DIRETORIO, DIRETORIOBACKUP);
		usuario.setFoto(this.arquivo.getNome());
		this.arquivo.gravar();
	}

	// metodo responsavel por apresentar foto na confirmação do cadastro do
	// usuario
	public String retornaFoto() {
		if (this.usuario != null) {
			if (this.usuario.getFoto() != null) {
				System.out
						.println("/resources/fotos/" + this.usuario.getFoto());
				return "/resources/fotos/" + this.usuario.getFoto();
			} else {
				return "/resources/fotos/foto.gif";
			}
		}
		return "/resources/fotos/foto.gif";
	}

	// metodo especifico do componente wizard do primefaces
	public String onFlowProcess(FlowEvent event) {
		if (skip) {
			skip = false; // reset in case user goes back
			return "confirm";
		} else {
			return event.getNewStep();
		}
	}

	/*
	 * ====================================== metodos chamadas DAO
	 * ======================================
	 */
	private void listar() {
		setUsuarios(new UsuarioDTO().obterTodos());
	}

	public void buscar() {
		usuarios = new UsuarioDTO().buscar(getTexto());
	}

	public void visualizar() {
	}

	public void excluir() {
		new UsuarioDTO().excluir(this.usuarioSelecionado);
		listar();
	}

	public void alterar() throws IOException {
		setUsuario(getUsuarioSelecionado());
		System.out.println("00000000000000000000000000000000:"
				+ getUsuario().getNome());
		FacesContext.getCurrentInstance().getExternalContext()
				.redirect("pessoaAltera.xhtml");
		
	}

}
