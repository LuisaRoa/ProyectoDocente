package co.edu.unicundi.repo;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import co.edu.unicundi.entity.Miembros;



@Repository
public interface IMiembrosRepo extends JpaRepository<Miembros, Integer> {

	@Transactional
	@Modifying
	@Query(value= "INSERT INTO miembros(doce_id, comi_id)" 
					+ "VALUES (:idDocente, :idComite)", nativeQuery = true)
	void guardar (@Param("idDocente") Integer idDocente, @Param("idComite") Integer idComite);


}
