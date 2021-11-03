package co.edu.unicundi.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import co.edu.unicundi.entity.AdjuntarEvidencia;


public interface IAdjuntarEvidenciasRepo extends JpaRepository<AdjuntarEvidencia, Integer>{
	 List<AdjuntarEvidencia> findByOrderById();
	
	 @Query(value="SELECT * FROM adjuntarevidencia where adjuntarevidencia.fecha_modificacion LIKE %?1%", nativeQuery = true)
		public List<AdjuntarEvidencia>numerodeEvidencias(@Param("año") String año);
		
	@Query(value="SELECT * FROM adjuntarevidencia where adjuntarevidencia.fecha_modificacion LIKE %?1% and adjuntarevidencia.periodo=?2", nativeQuery = true)
	public List<AdjuntarEvidencia>evidenciasperiodo(@Param("año") String año, @Param("periodo") String periodo);
}