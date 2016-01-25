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

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.event.FlowEvent;

import util.UploadArquivo;
import util.Util;

/**
 *
 * @author Willian Bueno
 */
@ManagedBean
@ViewScoped
public class UsuarioBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private static final String DIRETORIO = "/resources/fotos/";
	private static final String DIRETORIOBACKUP = "C:/Users/Willian Bueno/Projetos/imagens/";
	private UploadArquivo arquivo;
	private Usuario usuario;
	private Usuario usuarioSelecionado;
	private List<Usuario> usuarios;
	private boolean ver;
	private String texto;
	private List<Igreja> igrejas;
	private Igreja igreja;
	private String foto;

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
		this.arquivo.back();
		new UsuarioDTO().inserir(getUsuario());
		listar();
		Util.atualizarForm("usuario");
		Util.executarJavaScript("PF('dlgcadastrar').hide();");
		resetarFormulario();
	}

	public void inserir() {
		this.usuario = new Usuario();
		arquivo = new UploadArquivo();
		this.igreja = new Igreja();
		this.igrejas = new ArrayList<Igreja>(new IgrejaDAO().obterTodos());
		this.foto = retornaFoto();
	}
	public void alterar() {
		this.usuario = getUsuarioSelecionado();
		this.igreja = new Igreja();
		this.igrejas = new ArrayList<Igreja>(new IgrejaDAO().obterTodos());
	}

	public void excluir() {
		new UsuarioDTO().excluir(this.usuarioSelecionado);
		listar();
	}

	public void resetarFormulario() {
		Util.resetarFormulario("cadastrar");
	}


	// fileUpload irá fazer o carregamento do arquivo e prepara-lo para ser
	// gravado.
	public void uploadAction(FileUploadEvent event) {
		this.arquivo.fileUpload(event, ".jpg", DIRETORIO, DIRETORIOBACKUP);
		usuario.setFoto(this.arquivo.getNome());
		this.arquivo.gravar();
		Util.criarAviso("Foto processada!");
        Util.executarJavaScript("PF('dlgfoto').hide();");
        Util.atualizarForm("cadastrar:pic");
		
	}

	// metodo responsavel por apresentar foto na confirmação do cadastro do
	// usuario
	public String retornaFoto() {
		 if (this.usuario != null) {
	            if (this.usuario.getFoto() != null) {
	            	System.out.println("TESTEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEE");
	                return "/resources/fotos/" + this.usuario.getFoto();
	            } else {
	                return "/resources/fotos/foto.gif";
	            }
	        }
	        return "/resources/fotos/foto.gif";
	}
	 

	public UploadArquivo getArquivo() {
		return arquivo;
	}


	public void setArquivo(UploadArquivo arquivo) {
		this.arquivo = arquivo;
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



}
