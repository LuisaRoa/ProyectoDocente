package co.edu.unicundi.repo;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import co.edu.unicundi.entity.AulasVirtuales;

public interface IAulasVirtualesRepo extends JpaRepository<AulasVirtuales, Integer> {
	
	@Query(value="SELECT * FROM aulasvirtuales where aulasvirtuales.fecha LIKE %?1%", nativeQuery = true)
	public List<AulasVirtuales>numerodeAulas(@Param("año") String año);
	
	@Query(value="SELECT * FROM aulasvirtuales where aulasvirtuales.fecha LIKE %?1% and aulasvirtuales.periodo_aca=?2", nativeQuery = true)
	public List<AulasVirtuales>aulasperiodo(@Param("año") String año, @Param("periodo") String periodo);
	

}
