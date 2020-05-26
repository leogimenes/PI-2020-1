package projeto.calc02.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import projeto.calc02.model.Bairro;

public interface BairrosRepository extends JpaRepository<Bairro, Long> {
	Bairro findOneByNomeBairro(String nomeBairro);
}
