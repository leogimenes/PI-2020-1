package projeto.calc02.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
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
	
	@ManyToOne(fetch = FetchType.LAZY, cascade=CascadeType.ALL, optional = false)
	@JoinColumn
	private Bairro bairro;
	
	@OneToMany(mappedBy = "usuario")
	private Collection<Pegada> pegada = new ArrayList<Pegada>();
	
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
	public Bairro getBairro() {
		return bairro;
	}
	public void setBairro(Bairro bairro) {
		this.bairro = bairro;
	}	
	
	public Collection<Pegada> getPegada() {
		return new ArrayList<Pegada>(pegada);
	}
	
	public void addPegada(Pegada pegada) {
		
		if(this.pegada.contains(pegada))
			return ;
		this.pegada.add(pegada);
		pegada.setUsuario(this);
	}
	
	public void removePegada(Pegada newPegada) {
		
		if(!pegada.contains(newPegada))
			return ;
		pegada.remove(newPegada);
		newPegada.setUsuario(null);
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
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
		if (id != other.id)
			return false;
		return true;
	}
	
	
	
	
	
}
