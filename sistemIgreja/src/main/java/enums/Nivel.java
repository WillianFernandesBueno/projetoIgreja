/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enums;


public enum Nivel {
	//ADMINISTRADOR, SUPER, USUARIO
	ADMINISTRADOR("ADMINISTRADOR"), SECRETARIO("SECRETARIO"),SUPER("SUPER");

	private final String nivel; 

	Nivel(String label){ 
		this.nivel = label; 
	} 
	public String getValor(){ 
		return nivel; 
	}

}
