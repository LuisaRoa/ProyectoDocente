package co.edu.unicundi.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import co.edu.unicundi.entity.InformeHorasNoLectivas;
import co.edu.unicundi.entity.InformeRecuperacionClase;

@Repository
public interface IRecuperacionClaseRepo extends JpaRepository<InformeRecuperacionClase, Integer>{

	List<InformeRecuperacionClase> findByOrderById();
	
	@Query(value="SELECT * FROM recuperacionclase where recuperacionclase.fecha LIKE %?1%", nativeQuery = true)
	public List<InformeRecuperacionClase>numerodeRecuperacion(@Param("año") String año);
	
	@Query(value="SELECT * FROM recuperacionclase where recuperacionclase.fecha LIKE %?1% and recuperacionclase.periodo_aca=?2", nativeQuery = true)
	public List<InformeRecuperacionClase>recuperacionsperiodo(@Param("año") String año, @Param("periodo") String periodo);
	
}
