package beans;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import util.Util;
import DTO.IgrejaDTO;
import DTO.PessoaDTO;
import DTO.UsuarioDTO;
import entidades.Igreja;
import entidades.Usuario;
import enums.Nivel;

@ManagedBean
@ViewScoped
public class UsuarioBean {
	private Usuario usuario;
	private List<Usuario> usuarios;
	private List<Igreja> igrejas;
	private List<Igreja> congregacoes;
	private Igreja igrejaSelecionado;
	private Usuario usuarioSelecionado;
	private String buscaSede;
	private String buscaCongregacao;
	private boolean verSede;
	private boolean verCongregacao;
	private boolean ver;
	@PostConstruct
	public void init(){
		listar();
	}

	public void cadastrar(){
		if(getIgrejas().isEmpty() && getIgrejas().size()<1){
			setVer(false);
			Util.criarAvisoErro("Não existe igreja para vincular o usuario! por favor cadastre uma igreja");
		}else if(getIgrejaSelecionado()==null){
			setVer(false);
			Util.criarAvisoErro("Selecione uma Igreja");
		}else{
			setVer(true);
			this.usuario = new Usuario();			
		}
	}

	public void listarUsuarios(){
		this.usuarios = new UsuarioDTO().buscarUsuarios(getIgrejaSelecionado());

	}

	public void listar() {
		this.usuario = (Usuario) Util.pegarObjetoDaSessao("usuarioLogado");			
		if(usuario.getNivel().getValor().equalsIgnoreCase("SUPER")){
			this.verSede = true;
			igrejaSelecionado = new Igreja();
			this.igrejas = new IgrejaDTO().listarSedes();
		}else{
			Util.criarAvisoErro("Você nao tem permissão de Super Administrador");
		}
	}
	public void listaIgreja(){
		this.congregacoes = new IgrejaDTO().listarCongregacao(getIgrejaSelecionado());
		this.verSede = false;
		this.verCongregacao = true;

	}

	public void salvar(){
		if(verificaUsuario()){
			this.usuario.setIgreja(getIgrejaSelecionado());
			new UsuarioDTO().inserir(getUsuario());			
			Util.criarAviso("Cadastrado com sucesso!");
		}else{
			Util.criarAvisoErro("Usuario já existente");			
		}
		setVer(false);
		Util.atualizarForm("usuario");
		Util.executarJavaScript("PF('dlgCadastrarUsuario').hide();");
	}

	private boolean verificaUsuario() {
		listarUsuarios();
		for (Usuario u : usuarios) {
			if(u.getUsuario().equalsIgnoreCase(this.usuario.getUsuario())){
				return false;
			}
		}
		return true;
		
	}

	public void buscarSede() {
		igrejas = new IgrejaDTO().buscarSede(getBuscaSede());
	}

	public void buscarCongregacao() {
		this.congregacoes = new IgrejaDTO().buscarCongregacao(getBuscaCongregacao());
	}

	public Nivel[] retornaNivel(){
		return Nivel.values();
	}
	public void desabilitaVerLista(){
		this.verCongregacao = false;
		this.verSede = true;
	}

	public void excluir() {
		new UsuarioDTO().excluir(this.usuarioSelecionado);
		listarUsuarios();
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

	public List<Igreja> getIgrejas() {
		return igrejas;
	}

	public void setIgrejas(List<Igreja> igrejas) {
		this.igrejas = igrejas;
	}



	public String getBuscaSede() {
		return buscaSede;
	}

	public void setBuscaSede(String buscaSede) {
		this.buscaSede = buscaSede;
	}

	public String getBuscaCongregacao() {
		return buscaCongregacao;
	}

	public void setBuscaCongregacao(String buscaCongregacao) {
		this.buscaCongregacao = buscaCongregacao;
	}

	public boolean isVer() {
		return ver;
	}

	public void setVer(boolean ver) {
		this.ver = ver;
	}

	public boolean isVerSede() {
		return verSede;
	}

	public void setVerSede(boolean verSede) {
		this.verSede = verSede;
	}

	public boolean isVerCongregacao() {
		return verCongregacao;
	}

	public void setVerCongregacao(boolean verCongregacao) {
		this.verCongregacao = verCongregacao;
	}

	public Igreja getIgrejaSelecionado() {
		return igrejaSelecionado;
	}

	public void setIgrejaSelecionado(Igreja igrejaSelecionado) {
		this.igrejaSelecionado = igrejaSelecionado;
	}

	public List<Igreja> getCongregacoes() {
		return congregacoes;
	}

	public void setCongregacoes(List<Igreja> congregacoes) {
		this.congregacoes = congregacoes;
	}

	public Usuario getUsuarioSelecionado() {
		return usuarioSelecionado;
	}

	public void setUsuarioSelecionado(Usuario usuarioSelecionado) {
		this.usuarioSelecionado = usuarioSelecionado;
	}




}
