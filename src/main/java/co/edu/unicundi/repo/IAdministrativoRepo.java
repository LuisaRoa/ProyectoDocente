package co.edu.unicundi.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.edu.unicundi.entity.Administrativo;
import co.edu.unicundi.entity.Docente;

@Repository
public interface IAdministrativoRepo extends JpaRepository<Administrativo, Integer> {
    
	Optional<Administrativo> findByCorreo(String correo);
}

