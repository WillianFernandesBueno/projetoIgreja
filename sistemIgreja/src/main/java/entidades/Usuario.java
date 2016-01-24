package entidades;


import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="usuario")
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	@Column(name="id")
	private Long id;
	
	@Column(name="nome")
	private String nome;
	
	@Column(name="nomeMae")
	private String nomeMae;
	
	@Column(name="nomePai")
	private String nomePai;
	
	@Column(name="cpf")
	private String cpf;
	
	@Column(name="rg")
	private String rg;
	
	@Column(name="dataNascimento")
	private Date dataNascimento;
	
	@Column(name="dataBatismo")
	private Date dataBatismo;
	
	@Column(name="situacao")
	private String situacao;
	
	@Column(name="cargo")
	private String cargo;
	
	@Column(name="estadoCivil")
	private String estadoCivil;
	
	@Column(name="sexo")
	private String sexo;
	
	@Column(name="dirigente")
	private boolean dirigente;
	
	@Column(name="endereco")
	private String endereco;
	
	@Column(name="bairro")
	private String bairro;
	
	@Column(name="complemento")
	private String complemento;
	
	@Column(name="estado")
	private String estado;
	
	@Column(name="numero")
	private String numero;
	
	@Column(name="cidade")
	private String cidade;
	
	@Column(name="cep")
	private String cep;
	
	@Column(name="email")
	private String email;
	
	@Column(name="telefoneFixo")
	private String telefoneFixo;
	
	@Column(name="telefoneCelular")
	private String telefoneCelular;
	
	@Column(name="observacao")
	private String observacao;
	
	@Column(name="foto")
	private String foto;
	
	@ManyToOne
	private Igreja igreja;
	
	public Usuario(Long id, String nome, String nomeMae, String nomePai,
			String cpf, String rg, Date dataNascimento, Date dataBatismo,
			String situacao, String cargo, String estadoCivil, String sexo,
			boolean dirigente, String endereco, String bairro,
			String complemento, String estado, String numero, String cidade,
			String cep, String email, String telefoneFixo,
			String telefoneCelular, String observacao, String foto,
			Igreja igreja) {
		super();
		this.id = id;
		this.nome = nome;
		this.nomeMae = nomeMae;
		this.nomePai = nomePai;
		this.cpf = cpf;
		this.rg = rg;
		this.dataNascimento = dataNascimento;
		this.dataBatismo = dataBatismo;
		this.situacao = situacao;
		this.cargo = cargo;
		this.estadoCivil = estadoCivil;
		this.sexo = sexo;
		this.dirigente = dirigente;
		this.endereco = endereco;
		this.bairro = bairro;
		this.complemento = complemento;
		this.estado = estado;
		this.numero = numero;
		this.cidade = cidade;
		this.cep = cep;
		this.email = email;
		this.telefoneFixo = telefoneFixo;
		this.telefoneCelular = telefoneCelular;
		this.observacao = observacao;
		this.foto = foto;
		this.igreja = igreja;
	}
	public Usuario() {}
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

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nome=" + nome + ", nomeMae=" + nomeMae
				+ ", nomePai=" + nomePai + ", cpf=" + cpf + ", rg=" + rg
				+ ", dataNascimento=" + dataNascimento + ", dataBatismo="
				+ dataBatismo + ", situacao=" + situacao + ", cargo=" + cargo
				+ ", estadoCivil=" + estadoCivil + ", sexo=" + sexo
				+ ", dirigente=" + dirigente + ", endereco=" + endereco
				+ ", bairro=" + bairro + ", complemento=" + complemento
				+ ", estado=" + estado + ", numero=" + numero + ", cidade="
				+ cidade + ", cep=" + cep + ", email=" + email
				+ ", telefoneFixo=" + telefoneFixo + ", telefoneCelular="
				+ telefoneCelular + ", observacao=" + observacao + ", foto="
				+ foto + ", igreja=" + igreja + "]";
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getNomeMae() {
		return nomeMae;
	}
	public void setNomeMae(String nomeMae) {
		this.nomeMae = nomeMae;
	}
	public String getNomePai() {
		return nomePai;
	}
	public void setNomePai(String nomePai) {
		this.nomePai = nomePai;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getRg() {
		return rg;
	}
	public void setRg(String rg) {
		this.rg = rg;
	}
	public boolean getDirigente() {
		return dirigente;
	}
	public void setDirigente(boolean dirigente) {
		this.dirigente = dirigente;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public Date getDataBatismo() {
		return dataBatismo;
	}
	public void setDataBatismo(Date dataBatismo) {
		this.dataBatismo = dataBatismo;
	}
	public String getSituacao() {
		return situacao;
	}
	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}
	public String getCargo() {
		return cargo;
	}
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	public String getEstadoCivil() {
		return estadoCivil;
	}
	public void setEstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getComplemento() {
		return complemento;
	}
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public String getTelefoneFixo() {
		return telefoneFixo;
	}
	public void setTelefoneFixo(String telefoneFixo) {
		this.telefoneFixo = telefoneFixo;
	}
	public String getTelefoneCelular() {
		return telefoneCelular;
	}
	public void setTelefoneCelular(String telefoneCelular) {
		this.telefoneCelular = telefoneCelular;
	}
	public String getObservacao() {
		return observacao;
	}
	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}
	public String getFoto() {
		return foto;
	}
	public void setFoto(String foto) {
		this.foto = foto;
	}

	public Igreja getIgreja() {
		if(igreja!=null){
			System.out.println("-------------------------");
			System.out.println(igreja.getNome()+ igreja.getCep()+igreja.getId());
		}
		return igreja;
	}

	public void setIgreja(Igreja igreja) {
		if(igreja!=null){
			System.out.println("++++++++++++++++++++++++++");
			System.out.println(igreja.getNome()+ igreja.getCep()+igreja.getId());
		}
		this.igreja = igreja;
	}


}
