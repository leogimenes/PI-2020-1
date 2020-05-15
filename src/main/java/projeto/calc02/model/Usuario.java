package projeto.calc02.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;


@Entity
@Table(
		uniqueConstraints= {
				@UniqueConstraint(columnNames = "cpfIndividual")
		}
		)
public class Usuario implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String nomeIndividual;
	private String cpfIndividual;
	private String cepIndividual;
	private String complementoIndividual;
	
	@OneToMany(mappedBy="idUsuario")
	Set<Pegada> idPegada = new HashSet<Pegada>();
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name="FK_idBairro")
	private Bairro idBairro;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNomeIndividual() {
		return nomeIndividual;
	}
	public void setNomeIndividual(String nomeIndividual) {
		this.nomeIndividual = nomeIndividual;
	}
	public String getCpfIndividual() {
		return cpfIndividual;
	}
	public void setCpfIndividual(String cpfIndividual) {
		this.cpfIndividual = cpfIndividual;
	}
	public String getCepIndividual() {
		return cepIndividual;
	}
	public void setCepIndividual(String cepIndividual) {
		this.cepIndividual = cepIndividual;
	}
	public String getComplementoIndividual() {
		return complementoIndividual;
	}
	public void setComplementoIndividual(String complementoIndividual) {
		this.complementoIndividual = complementoIndividual;
	}
	public Bairro getIdBairro() {
		return idBairro;
	}
	public void setIdBairro(Bairro idBairro) {
		this.idBairro = idBairro;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idBairro == null) ? 0 : idBairro.hashCode());
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
		if (idBairro == null) {
			if (other.idBairro != null)
				return false;
		} else if (!idBairro.equals(other.idBairro))
			return false;
		return true;
	}
	
	
	
}
