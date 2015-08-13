package bean;



import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.model.UploadedFile;

@ManagedBean
@ViewScoped
public class UploadBean {
	private String file;

	public String getFile() {
		return file;
	}

	public void setFile(UploadedFile file) {
		this.file = file.getFileName();
	}
	public void upload() {
		System.out.println(getFile());
	}
}
