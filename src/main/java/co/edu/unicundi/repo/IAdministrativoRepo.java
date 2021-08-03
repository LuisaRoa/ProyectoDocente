package co.edu.unicundi.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.edu.unicundi.entity.Administrativo;

@Repository
public interface IAdministrativoRepo extends JpaRepository<Administrativo, Integer> {
    
	
}

