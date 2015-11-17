package util;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import bean.Usuario;

@FacesConverter(forClass = Usuario.class)
public class UsuarioConverter implements Converter {
    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String value) {
    	System.out.println("---------------------------------------------");
    	if (value != null && !value.isEmpty()) {
           return (Usuario) uiComponent.getAttributes().get(value);
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object value) {
    	System.out.println("=========================================");
    	if (value instanceof Usuario) {
        	Usuario entity= (Usuario) value;
            if (entity != null && entity instanceof Usuario && entity.getId() != null) {
                uiComponent.getAttributes().put( entity.getId().toString(), entity);
                System.out.println(entity.getId().toString());
                return entity.getId().toString();
            }
        }
        return "";
    }
    
    
}
