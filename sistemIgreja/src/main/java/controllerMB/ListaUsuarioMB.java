package controllerMB;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import DTO.UsuarioDTO;
import bean.Usuario;

@ManagedBean
@ViewScoped
public class ListaUsuarioMB {
	private List<Usuario> usuarios;


	@PostConstruct
	public void init() {
		usuarios = listaUsuarios();
	}


	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public List<Usuario> listaUsuarios(){
		System.out.println("teste");
		return new UsuarioDTO().obterTodos();
	}

}
