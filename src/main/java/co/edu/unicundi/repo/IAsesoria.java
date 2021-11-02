package co.edu.unicundi.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import co.edu.unicundi.entity.AcuerdoPedagogico;
import co.edu.unicundi.entity.AdjuntarEvidencia;
import co.edu.unicundi.entity.Asesoria;


public interface IAsesoria extends JpaRepository<Asesoria, Integer>{
	List<Asesoria> findByOrderById();
	
	@Query(value="SELECT * FROM asesoria where asesoria.fecha LIKE %?1%", nativeQuery = true)
	public List<Asesoria>numerodeAsesoria(@Param("año") String año);
	
	@Query(value="SELECT * FROM asesoria where asesoria.fecha LIKE %?1% and asesoria.periodo=?2", nativeQuery = true)
	public List<Asesoria>asesoriaperiodo(@Param("año") String año, @Param("periodo") String periodo);
}
