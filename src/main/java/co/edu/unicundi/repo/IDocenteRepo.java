package co.edu.unicundi.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import co.edu.unicundi.entity.Docente;

@Repository
public interface IDocenteRepo extends JpaRepository<Docente, Integer> {

	Optional<Docente> findByCorreo(String correo);


    
	
}
