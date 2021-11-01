package co.edu.unicundi.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import co.edu.unicundi.entity.InformeSemestral;
import co.edu.unicundi.entity.SolicitudSalidas;


@Repository
public interface IInformeSemestral extends JpaRepository<InformeSemestral, Integer>{
	List<InformeSemestral> findByOrderById();
	
	@Query(value="SELECT * FROM informesemestral where  informesemestral.fecha LIKE %?1%", nativeQuery = true)
	public List<InformeSemestral>informeAño(@Param("año") String año);
	
	@Query(value="SELECT * FROM informesemestral where informesemestral.fecha LIKE %?1% and informesemestral.periodo_aca=?2", nativeQuery = true)
	public List<InformeSemestral>informePeriodo(@Param("año") String año, @Param("periodo") String periodo);
}
