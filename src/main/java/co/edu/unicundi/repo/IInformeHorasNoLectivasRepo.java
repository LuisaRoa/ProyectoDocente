package co.edu.unicundi.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import co.edu.unicundi.entity.Actas;
import co.edu.unicundi.entity.InformeHorasNoLectivas;

@Repository
public interface IInformeHorasNoLectivasRepo extends JpaRepository<InformeHorasNoLectivas, Integer>{

	List<InformeHorasNoLectivas> findByOrderById();
	
	@Query(value="SELECT * FROM informehorasnolectivas where informehorasnolectivas.fecha LIKE %?1%", nativeQuery = true)
	public List<InformeHorasNoLectivas>numerodeHoras(@Param("año") String año);
	
	@Query(value="SELECT * FROM informehorasnolectivas where informehorasnolectivas.fecha LIKE %?1% and informehorasnolectivas.periodo_aca=?2", nativeQuery = true)
	public List<InformeHorasNoLectivas>horasperiodo(@Param("año") String año, @Param("periodo") String periodo);
}
