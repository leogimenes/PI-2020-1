package projeto.calc02.model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Pegada implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private int tempCarro;
	private int tempBus;
	private int volLixo;
	private double pegadaTotal;
	private LocalDate localDate;

	@ManyToOne(cascade=CascadeType.MERGE)
	@JoinColumn
	private Usuario usuario;
	
	public Pegada() {
		setLocalDate(LocalDate.now());
	}


	public Pegada(String nomeIndividual, String cpfIndividual, int tempCarro, int tempBus, int volLixo,
			double pegadaTotal, String cepIndividual, String complementoIndividual, int idBairro, LocalDate localDate) {
		super();
		this.tempCarro = tempCarro;
		this.tempBus = tempBus;
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

	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getTempCarro() {
		return tempCarro;
	}


	public void setTempCarro(int tempCarro) {
		setPegadaTotal(tempCarro);
		this.tempCarro = tempCarro;
	}


	public int getTempBus() {
		return tempBus;
	}


	public void setTempBus(int tempBus) {
		setPegadaTotal(tempBus);
		this.tempBus = tempBus;
	}


	public int getVolLixo() {
		return volLixo;
	}


	public void setVolLixo(int volLixo) {
		setPegadaTotal(volLixo);
		this.volLixo = volLixo;
	}


	public double getPegadaTotal() {
		return pegadaTotal;
	}


	public void setPegadaTotal(double pegadaTotal) {
		this.pegadaTotal = this.pegadaTotal + pegadaTotal;
	}


	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	/*
	public void setUsuario(Usuario usuario) {
		
		if(sameAsFormer(this.usuario))
			return ;
		
		Usuario oldUsuario = this.usuario;
		this.usuario = usuario;
		
		if(oldUsuario != null) 
			usuario.removePegada(this);		
			
		if(usuario != null)
			usuario.addPegada(this);
	}
	
	private boolean sameAsFormer(Usuario usuario) {
		return this.usuario == null ? usuario == null : this.usuario.equals(usuario); 
	}*/


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
		Pegada other = (Pegada) obj;
		if (id != other.id)
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Pegada [id=" + id + ", tempCarro=" + tempCarro + ", tempBus=" + tempBus + ", volLixo=" + volLixo
				+ ", pegadaTotal=" + pegadaTotal + ", localDate=" + localDate + ", usuario=" + usuario + "]";
	}
	
	

}
