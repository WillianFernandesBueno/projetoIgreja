package controllerMB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import java.util.ArrayList;
import java.util.List;

import org.primefaces.event.FileUploadEvent;

import util.UploadArquivo;
import DAO.ImagemDao;
import bean.Imagem;

@ManagedBean
@ViewScoped
public class ImagemMB {

	private Imagem imagem;
	private List<Imagem> listarProdutos;
	private UploadArquivo arquivo = new UploadArquivo();

	public ImagemMB() {
		this.imagem = new Imagem();
		this.listarProdutos = new ArrayList<Imagem>();
	}

	public List<Imagem> getListarProdutos() {
		return listarProdutos;
	}

	public void setListarProdutos(List<Imagem> listarProdutos) {
		this.listarProdutos = listarProdutos;
	}

	public Imagem getProduto() {
		return imagem;
	}

	public void setProduto(Imagem produto) {
		this.imagem = produto;
	}

	public void uploadAction (FileUploadEvent event){
		this.arquivo.fileUpload(event, ".jpg", "/image/", null);
		this.imagem.setFoto(this.arquivo.getNome());
	}

	public void salvar(){
		new ImagemDao().salvar(imagem);
		this.arquivo.gravar();

		this.imagem = new Imagem();
		this.arquivo = new UploadArquivo();
	}
}
