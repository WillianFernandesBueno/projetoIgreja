package beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.event.FlowEvent;

import entidades.Igreja;
import entidades.Pessoa;
import entidades.Usuario;
import enums.TipoIgreja;
import util.FacesUtil;
import util.UploadArquivo;
import util.Util;
import DAO.IgrejaDAO;
import DTO.IgrejaDTO;
import DTO.PessoaDTO;

@ManagedBean
@ViewScoped
public class IgrejaBean implements Serializable {
	private static final long serialVersionUID = 1L;
	private Igreja igreja;
	private List<Igreja> igrejas;
	private Igreja igrejaSelecionado;
	private String textoBusca;
	private Usuario usuario;
	
	@PostConstruct
	public void init() {
		listar();
	}	
	private void listar() {
		this.igrejaSelecionado = new Igreja();
		//setIgrejas(new IgrejaDTO().obterTodos());
		setIgrejas(new IgrejaDTO().obterTodasCongregacoes(usuario.getIgreja()));
		
	}
	public void inserir() {
		this.usuario = (Usuario) Util.pegarObjetoDaSessao("usuarioLogado");
		this.igreja = new Igreja();
		this.igreja = new Igreja();
		this.igrejas = new ArrayList<Igreja>(new IgrejaDAO().obterTodos());
	}
	
	public void alterar() {
		this.igreja = getIgrejaSelecionado();
	}

	public void excluir() {
		new IgrejaDTO().excluir(getIgrejaSelecionado());
		listar();
	}
	
	public void buscar() {
		igrejas = new IgrejaDTO().buscar(getTextoBusca());
	}
	public void salvar() {
		this.igreja.setIgreja(usuario.getIgreja());
		new IgrejaDTO().inserir(getIgreja());
		listar();
		Util.atualizarForm("igreja");
		Util.executarJavaScript("PF('dlgcadastrar').hide();");
		resetarFormulario();
	}
	public void resetarFormulario() {
		Util.resetarFormulario("cadastrar");
	}	
	
	public Igreja getIgreja() {
		return igreja;
	}
	public void setIgreja(Igreja igreja) {
		this.igreja = igreja;
	}

	public String getTextoBusca() {
		return textoBusca;
	}
	public void setTextoBusca(String textoBusca) {
		this.textoBusca = textoBusca;
	}
	public List<Igreja> getIgrejas() {
		return igrejas;
	}

	public void setIgrejas(List<Igreja> igrejas) {
		this.igrejas = igrejas;
	}
	

	public Igreja getIgrejaSelecionado() {
		return igrejaSelecionado;
	}
	public void setIgrejaSelecionado(Igreja igrejaSelecionado) {
		this.igrejaSelecionado = igrejaSelecionado;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	

}