package projeto.calc02.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Bairro implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String nomeBairro;
	private String regiao;
	private Double volumeCo2;
	
	@OneToMany(mappedBy= "bairro", cascade=CascadeType.MERGE)
	private List<Usuario> usuarios = new ArrayList<>();
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNomeBairro() {
		return nomeBairro;
	}
	public void setNomeBairro(String nomeBairro) {
		this.nomeBairro = nomeBairro;
	}
	public String getRegiao() {
		return regiao;
	}
	public void setRegiao(String regiao) {
		this.regiao = regiao;
	}
	public Double getVolumeCo2() {
		return volumeCo2;
	}
	public void setVolumeCo2(Double volumeCo2) {
		this.volumeCo2 = volumeCo2;
	}
	
	public void addUsuario(Usuario usuario) {
		usuarios.add(usuario);
		usuario.setBairro(null);
	}
	
	public void removerComment(Usuario usuario) {
		usuarios.remove(usuario);
		usuario.setBairro(null);
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((nomeBairro == null) ? 0 : nomeBairro.hashCode());
		result = prime * result + ((regiao == null) ? 0 : regiao.hashCode());
		result = prime * result + ((usuarios == null) ? 0 : usuarios.hashCode());
		result = prime * result + ((volumeCo2 == null) ? 0 : volumeCo2.hashCode());
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
		Bairro other = (Bairro) obj;
		if (id != other.id)
			return false;
		if (nomeBairro == null) {
			if (other.nomeBairro != null)
				return false;
		} else if (!nomeBairro.equals(other.nomeBairro))
			return false;
		if (regiao == null) {
			if (other.regiao != null)
				return false;
		} else if (!regiao.equals(other.regiao))
			return false;
		if (usuarios == null) {
			if (other.usuarios != null)
				return false;
		} else if (!usuarios.equals(other.usuarios))
			return false;
		if (volumeCo2 == null) {
			if (other.volumeCo2 != null)
				return false;
		} else if (!volumeCo2.equals(other.volumeCo2))
			return false;
		return true;
	}
}
