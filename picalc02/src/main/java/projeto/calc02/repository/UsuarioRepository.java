package projeto.calc02.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import projeto.calc02.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

	public Usuario findOneByNomeIndividualAndCpfIndividual(String nomeIndividual, String cpfIndividual);
}
