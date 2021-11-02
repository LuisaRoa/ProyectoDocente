package co.edu.unicundi.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import co.edu.unicundi.entity.Syllabus;


@Repository
public interface ISyllabusRepo extends JpaRepository<Syllabus, Integer>{
	List<Syllabus> findByOrderById();
	
	@Query(value = "select * from syllabus where fecha like %?1%", nativeQuery  = true)
	List<Syllabus> buscarPorAño(@Param("año") String año);
}
