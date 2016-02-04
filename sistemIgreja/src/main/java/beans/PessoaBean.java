/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import DAO.IgrejaDAO;
import DTO.PessoaDTO;
import entidades.Igreja;
import entidades.Pessoa;
import entidades.Usuario;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.event.FileUploadEvent;

import util.UploadArquivo;
import util.Util;

/**
 *
 * @author Willian Bueno
 */
@ManagedBean
@ViewScoped
public class PessoaBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private static final String DIRETORIO = "/resources/fotos/";
	private static final String DIRETORIOBACKUP = "C:/Users/Willian Bueno/Projetos/imagens/";
	private UploadArquivo arquivo;
	private Usuario usuario;
	private Pessoa pessoa;
	private Pessoa pessoaSelecionado;
	private List<Pessoa> pessoas;
	private boolean ver;
	private String texto;
	private List<Igreja> igrejas;
	private Igreja igreja;
	private String foto;

	@PostConstruct
	public void init() {
		listar();
	}

	/*=======================================================
	 *=============BUSCA PESSOAS PELO NOME=================== 
	 * =====================================================*/
	public void buscar() {
		pessoas = new PessoaDTO().buscar(getTexto());
	}

	/*=======================================================
	 *=============LISTA PESSOAS QUE ESTAO RELACIONADAS====== 
	 *===============A IGREJA DO USUARIO LOGADO============== 
	 *======================================================*/
	private void listar() {
		this.usuario = (Usuario) Util.pegarObjetoDaSessao("usuarioLogado");
		this.pessoaSelecionado = new Pessoa();
		if(usuario.getIgreja()!=null){
			this.pessoas = new PessoaDTO().ListarPessoas(usuario.getIgreja());
		}else{
			this.pessoas = new PessoaDTO().ListarPessoas();
		}
	}
	/*=======================================================
	 *===========METODO RESPONSAVEL POR SALVAR PESSOA======== 
	 *==========RELACIONANDO ID PESSOA COM FK IGREJA_ID====== 
	 *======================================================*/
	public void salvar() {
		this.arquivo.back();
		this.pessoa.setIgreja(usuario.getIgreja());
		new PessoaDTO().inserir(getPessoa());
		listar();
		Util.atualizarForm("usuario");
		Util.executarJavaScript("PF('dlgcadastrar').hide();");
		resetarFormulario();
	}

	/*=======================================================
	 *===========METODO RESPONSAVEL POR INSTANCIAR ========== 
	 *===========OS OBJETOS DO CADASTRO DE PESSOAS=========== 
	 *======================================================*/
	public void inserir() {
		this.pessoa = new Pessoa();
		this.arquivo = new UploadArquivo();
		this.igreja = new Igreja();
		this.foto = retornaFoto();
	}
	
	/*=======================================================
	 *=============ALTERA DADOS DO OBJETO PESSOA============= 
	 *======================================================*/
	public void alterar() {
		this.pessoa = getPessoaSelecionado();
//		this.arquivo = new UploadArquivo();
//		this.igreja = new Igreja();
//		this.igrejas = new ArrayList<Igreja>(new IgrejaDAO().listarIgrejas());
	}

	public void excluir() {
		new PessoaDTO().excluir(this.pessoaSelecionado);
		listar();
	}

	public void resetarFormulario() {
		Util.resetarFormulario("cadastrar");
	}


	// fileUpload irá fazer o carregamento do arquivo e prepara-lo para ser
	// gravado.
	public void uploadAction(FileUploadEvent event) {
		this.arquivo.fileUpload(event, ".jpg", DIRETORIO, DIRETORIOBACKUP);
		pessoa.setFoto(this.arquivo.getNome());
		this.arquivo.gravar();
		Util.criarAviso("Foto processada!");
		Util.executarJavaScript("PF('dlgfoto').hide();");
		Util.atualizarForm("cadastrar:pic");

	}

	// metodo responsavel por apresentar foto na confirmação do cadastro do
	// pessoa
	public String retornaFoto() {
		if (this.pessoa != null) {
			if (this.pessoa.getFoto() != null) {
				return "/resources/fotos/" + this.pessoa.getFoto();
			} else {
				return "/resources/fotos/foto.jpg";
			}
		}
		return "/resources/fotos/foto.jpg";
	}


	public UploadArquivo getArquivo() {
		return arquivo;
	}


	public void setArquivo(UploadArquivo arquivo) {
		this.arquivo = arquivo;
	}


	public Pessoa getPessoa() {
		return pessoa;
	}


	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}


	public Pessoa getPessoaSelecionado() {
		return pessoaSelecionado;
	}


	public void setPessoaSelecionado(Pessoa pessoaSelecionado) {
		this.pessoaSelecionado = pessoaSelecionado;
	}


	public List<Pessoa> getPessoas() {
		return pessoas;
	}


	public void setPessoas(List<Pessoa> pessoas) {
		this.pessoas = pessoas;
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


	public String getFoto() {
		return foto;
	}


	public void setFoto(String foto) {
		this.foto = foto;
	}


	public Usuario getUsuario() {
		return usuario;
	}


	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	

}
