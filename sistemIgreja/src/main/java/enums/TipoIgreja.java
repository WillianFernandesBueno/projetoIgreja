package enums;

public enum TipoIgreja {
	SEDE("sede"), CONGREGACAO("congregacao"); 
	private final String label; 
	
	TipoIgreja(String label){ 
		this.label = label; 
	} 
	public String getValor(){ 
		return label; 
	}
}
