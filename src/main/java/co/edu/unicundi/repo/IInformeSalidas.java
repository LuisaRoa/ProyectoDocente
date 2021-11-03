package co.edu.unicundi.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import co.edu.unicundi.entity.InformeSalidas;


@Repository
public interface IInformeSalidas extends JpaRepository<InformeSalidas, Integer>{
	List<InformeSalidas> findByOrderById();
	
	@Query(value="SELECT * FROM informesalidas where informesalidas.fecha LIKE %?1%", nativeQuery = true)
	public List<InformeSalidas>salidasaño(@Param("año") String año);
	
	@Query(value="SELECT * FROM informesalidas where informesalidas.fecha LIKE %?1% and informesalidas.periodo=?2", nativeQuery = true)
	public List<InformeSalidas>salidasperiodo(@Param("año") String año, @Param("periodo") String periodo);
	
}
