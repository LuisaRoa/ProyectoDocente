package co.edu.unicundi.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.edu.unicundi.entity.Syllabus;


@Repository
public interface ISyllabusRepo extends JpaRepository<Syllabus, Integer>{
	List<Syllabus> findByOrderById();
}
