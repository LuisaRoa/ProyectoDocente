package co.edu.unicundi.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import co.edu.unicundi.entity.Docente;

@Repository
public interface IDocenteRepo extends JpaRepository<Docente, Integer> {

	Optional<Docente> findByCorreo(String correo);

	Docente findOneByCorreo(String correo);

	@Query(value = "SELECT * FROM docente WHERE doce_id NOT IN (SELECT doce_id FROM miembros WHERE comi_id = :comi_id)", nativeQuery  = true)
	List<Docente> buscarNoMiembros(@Param("comi_id") Integer comi_id);
	
}
