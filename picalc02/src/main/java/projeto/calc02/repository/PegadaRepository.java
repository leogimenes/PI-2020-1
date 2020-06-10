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
	
	@Query(value = "SELECT ROUND(SUM(p.pegadaTotal), 2) FROM Pegada p WHERE bairro_id = :bairro")
	Double somaBairroPegadas(@Param("bairro") Long bairro);
	
	@Query(value = "SELECT SUM(ROUND(p.distanciaCarro, 2)) FROM Pegada p WHERE bairro_id = :bairro")
	Double somaBairroCarros(@Param("bairro") Bairro bairro);
	
	@Query(value = "SELECT SUM(ROUND(p.distanciaBus, 2)) FROM Pegada p WHERE bairro_id = :bairro")
	Double somaBairroBus(@Param("bairro") Bairro bairro);
	
	@Query(value = "SELECT SUM(ROUND(p.pesoLixo, 2)) FROM Pegada p WHERE bairro_id = :bairro")
	Double somaBairroLixo(@Param("bairro") Bairro bairro);
	
	@Query(value = "SELECT p.id, bairro_id, SUM(p.distancia_bus) AS distancia_bus, SUM(p.distancia_carro) AS distancia_carro, SUM(p.peso_lixo) AS peso_lixo, SUM(p.pegada_total) AS pegada_total, p.usuario_id FROM Pegada p INNER JOIN bairro ON p.bairro_id = bairro.id group by p.bairro_id", nativeQuery = true)
	List <Pegada> sumPegadasByBairroId();
}
