package entidades;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import enums.Nivel;

@Entity
@Table(name="usuario")
@NamedQueries({
	@NamedQuery(name="USUARIO.LISTARUSUARIOS",query="select u from Usuario u where u.igreja.id = :id")
})
public class Usuario implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name="id")
	private Long id;
	
	@Column(name="usuario")
	private String usuario;
	
	@Column(name="senha")
	private String senha;
	
	@Column(name="nivel")
	@Enumerated(EnumType.STRING)
	private Nivel nivel;
	
	@ManyToOne
	private Igreja igreja;
	
	public Usuario() {
		super();
	}
		
	public Usuario(Long id, String usuario, String senha, Nivel nivel,
			Igreja igreja) {
		super();
		this.id = id;
		this.usuario = usuario;
		this.senha = senha;
		this.nivel = nivel;
		this.igreja = igreja;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getSenha() {
		return senha;
	}
	public Nivel getNivel() {
		return nivel;
	}

	public void setNivel(Nivel nivel) {
		this.nivel = nivel;
	}

	public Igreja getIgreja() {
		return igreja;
	}
	public void setIgreja(Igreja igreja) {
		this.igreja = igreja;
	}
	
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", usuario=" + usuario + ", nivel="
				+ nivel + ", igreja=" + igreja + "]";
	}	
}
