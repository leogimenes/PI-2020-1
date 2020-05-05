package model;

public class PegadaIndividual {
	private int id;
	private String nomeIndividual;
	private String cpfIndividual;
	private int tempCarro;
	private int tempBus;
	private int volLixo;
	private double pegadaTotal;
	private String cepIndividual;
	private String complementoIndividual;
	private int idBairro;


	public PegadaIndividual(int id, String nomeIndividual, String cpfIndividual, int tempCarro, int tempBus,
			int volLixo, double pegadaTotal, String cepIndividual, String complementoIndividual, int idBairro) {
		super();
		this.id = id;
		this.nomeIndividual = nomeIndividual;
		this.cpfIndividual = cpfIndividual;
		this.tempCarro = tempCarro;
		this.tempBus = tempBus;
		this.volLixo = volLixo;
		this.pegadaTotal = pegadaTotal;
		this.cepIndividual = cepIndividual;
		this.complementoIndividual = complementoIndividual;
		this.idBairro = idBairro;
	}


	public PegadaIndividual(String nomeIndividual, String cpfIndividual, int tempCarro, int tempBus, int volLixo,
			double pegadaTotal, String cepIndividual, String complementoIndividual, int idBairro) {
		super();
		this.nomeIndividual = nomeIndividual;
		this.cpfIndividual = cpfIndividual;
		this.tempCarro = tempCarro;
		this.tempBus = tempBus;
		this.volLixo = volLixo;
		this.pegadaTotal = pegadaTotal;
		this.cepIndividual = cepIndividual;
		this.complementoIndividual = complementoIndividual;
		this.idBairro = idBairro;
	}



	public PegadaIndividual() {
	}


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
	public int getTempCarro() {
		return tempCarro;
	}
	public void setTempCarro(int tempCarro) {
		this.tempCarro = tempCarro;
	}
	public int getTempBus() {
		return tempBus;
	}
	public void setTempBus(int tempBus) {
		this.tempBus = tempBus;
	}
	public int getVolLixo() {
		return volLixo;
	}
	public void setVolLixo(int volLixo) {
		this.volLixo = volLixo;
	}
	public double getPegadaTotal() {
		return pegadaTotal;
	}
	public void setPegadaTotal(double pegadaTotal) {
		this.pegadaTotal = pegadaTotal;
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

	public int getIdBairro() {
		return idBairro;
	}

	public void setIdBairro(int idBairro) {
		this.idBairro = idBairro;
	}

	@Override
	public String toString() {
		return "PegadaIndividual [id=" + id + ", nomeIndividual=" + nomeIndividual + ", cpfIndividual=" + cpfIndividual
				+ ", pegadaTotal=" + pegadaTotal + "]";
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PegadaIndividual other = (PegadaIndividual) obj;
		if (cepIndividual == null) {
			if (other.cepIndividual != null)
				return false;
		} else if (!cepIndividual.equals(other.cepIndividual))
			return false;
		if (complementoIndividual == null) {
			if (other.complementoIndividual != null)
				return false;
		} else if (!complementoIndividual.equals(other.complementoIndividual))
			return false;
		if (cpfIndividual == null) {
			if (other.cpfIndividual != null)
				return false;
		} else if (!cpfIndividual.equals(other.cpfIndividual))
			return false;
		if (id != other.id)
			return false;
		if (nomeIndividual == null) {
			if (other.nomeIndividual != null)
				return false;
		} else if (!nomeIndividual.equals(other.nomeIndividual))
			return false;
		if (Double.doubleToLongBits(pegadaTotal) != Double.doubleToLongBits(other.pegadaTotal))
			return false;
		if (tempBus != other.tempBus)
			return false;
		if (tempCarro != other.tempCarro)
			return false;
		if (volLixo != other.volLixo)
			return false;
		return true;
	}	
}
