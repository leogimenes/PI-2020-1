package projeto.calc02.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import projeto.calc02.model.Bairro;
import projeto.calc02.model.Pegada;
import projeto.calc02.model.Usuario;

public interface PegadaRepository extends JpaRepository<Pegada, Long> {
	public List<Pegada> findByUsuarioId(Long usuario);
	
	@Query(value = "SELECT SUM(ROUND(p.pegadaTotal, 2)) FROM Pegada p WHERE usuario_id = :usuario")
	Double somaUsuarioPegadas(@Param("usuario") Usuario usuario); 
	
	@Query(value = "SELECT SUM(ROUND(p.pegadaTotal, 2)) FROM Pegada p WHERE bairro_id = :bairro")
	Double somaBairroPegadas(@Param("bairro") Bairro bairro);
	
	@Query(value = "SELECT SUM(ROUND(p.pegadaTotal, 2)) FROM Pegada p WHERE bairro_id = :bairro")
	Double somaBairroPegadas(@Param("bairro") Long bairro);
}
