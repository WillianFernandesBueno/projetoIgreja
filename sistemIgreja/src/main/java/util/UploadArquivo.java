package util;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.ha.session.BackupManager;
import org.primefaces.event.FileUploadEvent;

public class UploadArquivo {
	private String caminho;
	private String caminhoBack;
	private byte[] arquivo;
	private String nome;
	
	public UploadArquivo() {
		System.out.println("UploadArquivo na util");
	}


	public String getNome() {
		return nome;
	}
	
	
	public String getCaminho() {
		return caminho;
	}


	public void setCaminho(String caminho) {
		this.caminho = caminho;
	}


	//getRealPath pega o diretório completo da sua aplicação no servidor
	public String getRealPath() {
		ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
		HttpServletResponse response = 	(HttpServletResponse) externalContext.getResponse();

		FacesContext aFacesContext = FacesContext.getCurrentInstance();
		ServletContext context = (ServletContext) aFacesContext.getExternalContext().getContext();
		return context.getRealPath("/");
	}

	//fileUpload irá fazer o carregamento do arquivo e prepara-lo para ser gravado.
	public void fileUpload(FileUploadEvent event, String type, String diretorio, String diretoriobackup) {
		System.out.println("====================================================================");
		try {
			this.nome = new java.util.Date().getTime() + type;
			this.caminho = getRealPath() + diretorio + getNome();
			this.caminhoBack = diretoriobackup+getNome();
			this.arquivo = event.getFile().getContents();

			File file = new File(getRealPath() + diretorio);
			file.mkdirs();

		} catch (Exception ex) {
			System.out.println("Erro no upload do arquivo" + ex);
		}
	}

	//grava o arquivo no diretório informado.
	public void gravar(){
		//realizar backup das imagens em uma pasta fora do servidor de aplicação
		Backup();
		try {
			FileOutputStream fos;
			fos = new FileOutputStream(this.caminho);
			fos.write(this.arquivo);
			fos.close();

		} catch (Exception ex) {
			System.out.println(ex);
		}

	}


	private void Backup() {
		FileOutputStream fos;
		try {
			fos = new FileOutputStream(this.caminhoBack);
			fos.write(this.arquivo);
			fos.close();
		} catch (Exception ex) {
			System.out.println(ex);
		}
	
		
	}
}