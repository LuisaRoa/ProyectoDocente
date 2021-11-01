package co.edu.unicundi.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import co.edu.unicundi.entity.AcuerdoPedagogico;


@Repository
public interface IAcuerdoPedagogicoRepo extends JpaRepository<AcuerdoPedagogico, Integer>{
	List<AcuerdoPedagogico> findByOrderById();
	
	@Query(value="SELECT * FROM acuerdopedagogico where acuerdopedagogico.fecha LIKE %?1% and acuerdopedagogico.periodo_aca=?2", nativeQuery = true)
	public List<AcuerdoPedagogico>numerodeaAcuerdos(@Param("año") String año, @Param("periodo") String periodo);

	@Query(value="SELECT * FROM acuerdopedagogico where acuerdopedagogico.fecha LIKE %?1%", nativeQuery = true)
	public List<AcuerdoPedagogico>numerodeaAcuerdosA(@Param("año") String año);
}
