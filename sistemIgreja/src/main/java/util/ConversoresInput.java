package util;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(value="convertInput")  
public class ConversoresInput implements Converter {  

	@Override  
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String valor) {  
		if(valor != null || valor != "") {  
			valor = valor.toString().replaceAll("[- /.]", "");  
			valor = valor.toString().replaceAll("[-()]", "");  
		}  
		return valor;  
	}  

	@Override  
	public String getAsString(FacesContext arg0, UIComponent arg1, Object valor) {  
		return valor.toString();  
	}  

	public static Date converterMaskDate(String dataNascimento){
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");  
		try {
			Date date = (Date) sdf.parse("27/07/2006");
			System.out.println("==============================================");
			return date;
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public static Double converterStringDouble(String str){
		double cep = Double.parseDouble(str);
		return cep;
	}
} 