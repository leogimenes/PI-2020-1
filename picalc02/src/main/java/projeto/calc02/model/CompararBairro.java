package projeto.calc02.model;

import java.util.Comparator;

public class CompararBairro implements Comparator<Bairro> {

	@Override
	public int compare(Bairro o1, Bairro o2) {
		return String.CASE_INSENSITIVE_ORDER.compare(o1.getNomeBairro(), o2.getNomeBairro());
	}

}
