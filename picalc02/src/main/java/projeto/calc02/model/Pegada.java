package projeto.calc02.model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Pegada implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@Column(columnDefinition = "double default 0")
	private Double distanciaCarro = 0.0;
	@Column(columnDefinition = "double default 0")
	private Double distanciaBus = 0.0;
	@Column(columnDefinition = "double default 0")
	private Double volLixo = 0.0;
	@Column(columnDefinition = "double default 0")
	private Double pegadaTotal = 0.0;
	private LocalDate localDate;

	@ManyToOne(cascade=CascadeType.MERGE, optional = false)
	private Usuario usuario;
	
	@ManyToOne(cascade=CascadeType.MERGE, optional = false)
	private Bairro bairro;
	
	public Pegada() {
		setLocalDate(LocalDate.now());
	}


	public Pegada(String nomeIndividual, String cpfIndividual, Double distanciaCarro, Double distanciaBus, Double volLixo,
			Double pegadaTotal, String cepIndividual, String complementoIndividual, Long idBairro, LocalDate localDate) {
		super();
		this.distanciaCarro = distanciaCarro;
		this.distanciaBus = distanciaBus;
		this.volLixo = volLixo;
		this.pegadaTotal = pegadaTotal;
		this.localDate = localDate;
	}


	public LocalDate getLocalDate() {
		return localDate;
	}


	public void setLocalDate(LocalDate localDate) {
		this.localDate = localDate;
	}

	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Double getDistanciaCarro() {
		return distanciaCarro;
	}


	public void setDistanciaCarro(Double distanciaCarro) {
		setPegadaTotal(distanciaCarro*0.15);
		this.distanciaCarro = distanciaCarro*0.15;
	}


	public Double getDistanciaBus() {
		return distanciaBus;
	}


	public void setDistanciaBus(Double distanciaBus) {
		setPegadaTotal(distanciaBus*0.186);
		this.distanciaBus = distanciaBus*0.186;
	}


	public Double getVolLixo() {
		return volLixo;
	}


	public void setVolLixo(Double volLixo) {
		setPegadaTotal(volLixo*2.64);
		this.volLixo = volLixo*2.64;
	}


	public Double getPegadaTotal() {
		return pegadaTotal;
	}


	public void setPegadaTotal(Double pegadaTotal) {
		this.pegadaTotal = this.pegadaTotal + pegadaTotal;
	}


	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public Bairro getBairro() {
		return bairro;
	}


	public void setBairro(Bairro bairro) {
		this.bairro = bairro;
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
		Pegada other = (Pegada) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Pegada [id=" + id + ", tempCarro=" + distanciaCarro + ", tempBus=" + distanciaBus + ", volLixo=" + volLixo
				+ ", pegadaTotal=" + pegadaTotal + ", localDate=" + localDate + "]";
	}
	
	

}
