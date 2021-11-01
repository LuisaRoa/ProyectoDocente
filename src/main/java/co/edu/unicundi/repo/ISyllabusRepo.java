package co.edu.unicundi.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import co.edu.unicundi.dto.ReporteDto;
import co.edu.unicundi.entity.AcuerdoPedagogico;
import co.edu.unicundi.entity.Syllabus;


@Repository
public interface ISyllabusRepo extends JpaRepository<Syllabus, Integer>{
	List<Syllabus> findByOrderById();
	
	@Query(value="SELECT * FROM  syllabus where syllabus.fecha LIKE %?1% and syllabus.periodo_aca=?2", nativeQuery = true)
	public List<Syllabus>numerodeSyllabus(@Param("año") String año, @Param("periodo") String periodo);
	
	@Query(value="SELECT * FROM syllabus where syllabus.fecha LIKE %?1%", nativeQuery = true)
	public List<Syllabus>numerodeSyllabusA(@Param("año") String año);
}
