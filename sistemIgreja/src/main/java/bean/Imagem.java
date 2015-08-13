package bean;
import javax.persistence.*;
@Entity
@Table(name="tb_produto")
public class Imagem {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="prod_id")
	private int id;
	
	@Column(name="prod_foto")
	private String foto;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}
	
}
