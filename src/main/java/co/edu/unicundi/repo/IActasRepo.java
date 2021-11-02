package co.edu.unicundi.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import co.edu.unicundi.entity.Actas;


public interface IActasRepo extends JpaRepository<Actas, Integer> {
	List<Actas> findByOrderById();
	
	@Query(value="SELECT * FROM actas where actas.fecha LIKE %?1%", nativeQuery = true)
	public List<Actas>numerodeActas(@Param("año") String año);
	
	@Query(value="SELECT * FROM actas where actas.fecha LIKE %?1% and actas.periodo=?2", nativeQuery = true)
	public List<Actas>actasperiodo(@Param("año") String año, @Param("periodo") String periodo);
}
