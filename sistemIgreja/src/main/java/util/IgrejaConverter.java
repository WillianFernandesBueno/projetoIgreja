package util;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import bean.Igreja;

@FacesConverter(forClass = Igreja.class)
public class IgrejaConverter implements Converter {
	
	@Override
	public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String value) {
		System.out.println("CONVERTER 1");
		System.out.println(value);
		if (value != null && !value.isEmpty()) {
			System.out.println((Igreja) uiComponent.getAttributes().get(value));
			return (Igreja) uiComponent.getAttributes().get(value);
		}
		return null;
	}

	@Override
	public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object value) {
		System.out.println("CONVERTER 2");
		System.out.println(value.toString());
		if (value instanceof Igreja) {
			Igreja entity= (Igreja) value;
			if (entity != null && entity instanceof Igreja && entity.getId() != null) {
				uiComponent.getAttributes().put( entity.getId().toString(), entity);
				return entity.getId().toString();
			}
		}
		return "";
	}

}
