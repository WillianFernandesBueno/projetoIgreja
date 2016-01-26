package beans;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import DTO.PessoaDTO;
import entidades.Pessoa;

@ManagedBean
@ViewScoped
public class IgrejaListMB {
	private List<Pessoa> pessoas;


	@PostConstruct
	public void init() {
		pessoas = listaPessoas();
	}

	public List<Pessoa> getPessoas() {
		return pessoas;
	}

	public void setPessoas(List<Pessoa> pessoas) {
		this.pessoas = pessoas;
	}

	public List<Pessoa> listaPessoas(){
		System.out.println("teste");
		return new PessoaDTO().obterTodos();
	}

}
