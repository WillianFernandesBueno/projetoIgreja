package util;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class FacesUtil {
	public static void addMsgInfo(String msg){
		FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO,msg,msg);
		FacesContext.getCurrentInstance().addMessage(null, facesMessage);   
	}

	public static void addMsgError(String msg){
		FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_ERROR,msg,msg);
		FacesContext.getCurrentInstance().addMessage(null, facesMessage);  
	}
}
