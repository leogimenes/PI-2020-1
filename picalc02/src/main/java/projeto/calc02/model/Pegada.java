package projeto.calc02.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

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
	private Double pesoLixo = 0.0;
	@Column(columnDefinition = "double default 0")
	private Double pegadaTotal = 0.0;
	@Transient
	private LocalDate localDate;

	@ManyToOne(cascade=CascadeType.MERGE, optional = false)
	private Usuario usuario;

	@ManyToOne(cascade=CascadeType.MERGE, optional = false)
	private Bairro bairro;

	public Pegada() {
		setLocalDate(LocalDate.now());
	}

	

	public Pegada(Double distanciaCarro, Double distanciaBus, Double pesoLixo, Double pegadaTotal) {
		setLocalDate(LocalDate.now());
		this.distanciaCarro = distanciaCarro;
		this.distanciaBus = distanciaBus;
		this.pesoLixo = pesoLixo;
		this.pegadaTotal = pegadaTotal;
	}



	private static double round(double value, int places) {
		if (places < 0) throw new IllegalArgumentException();

		BigDecimal bd = new BigDecimal(Double.toString(value));
		bd = bd.setScale(places, RoundingMode.HALF_UP);
		return bd.doubleValue();
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
		distanciaCarro = round(distanciaCarro, 1);
		return distanciaCarro;
	}


	public void setDistanciaCarro(Double distanciaCarro) {
		this.distanciaCarro = distanciaCarro*0.473;
	}


	public Double getDistanciaBus() {
		distanciaBus = round(distanciaBus, 1);
		return distanciaBus;
	}


	public void setDistanciaBus(Double distanciaBus) {
		this.distanciaBus = distanciaBus*0.458;
	}


	public Double getPesoLixo() {
		pesoLixo = round(pesoLixo, 1);
		return pesoLixo;
	}


	public void setPesoLixo(Double pesoLixo) {
		this.pesoLixo = pesoLixo*2.64;
	}


	public Double getPegadaTotal() {
		pegadaTotal = round(pegadaTotal, 1);
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
		return "Pegada [id=" + id + ", tempCarro=" + distanciaCarro + ", tempBus=" + distanciaBus + ", pesoLixo=" + pesoLixo
				+ ", pegadaTotal=" + pegadaTotal + ", localDate=" + localDate + "]";
	}



}
