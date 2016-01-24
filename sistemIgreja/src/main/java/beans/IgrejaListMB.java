package beans;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import entidades.Usuario;
import DTO.UsuarioDTO;

@ManagedBean
@ViewScoped
public class IgrejaListMB {
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
