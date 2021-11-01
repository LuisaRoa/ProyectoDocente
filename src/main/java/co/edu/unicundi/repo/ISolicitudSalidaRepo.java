package co.edu.unicundi.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import co.edu.unicundi.entity.SolicitudSalidas;

@Repository
public interface ISolicitudSalidaRepo extends JpaRepository<SolicitudSalidas, Integer>{
	
	@Query(value="SELECT * FROM solicitudsalidas where solicitudsalidas.sosa_fechaterminacion LIKE %?1%", nativeQuery = true)
	public List<SolicitudSalidas>numerodeSolicitudSalidas(@Param("año") String año);
	
	@Query(value="SELECT * FROM solicitudsalidas where solicitudsalidas.sosa_fechaterminacion LIKE %?1% and solicitudsalidas.sosa_periodo=?2", nativeQuery = true)
	public List<SolicitudSalidas>SolicitudSalidasperiodo(@Param("año") String año, @Param("periodo") String periodo);
}
