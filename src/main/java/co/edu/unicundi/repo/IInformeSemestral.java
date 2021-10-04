package co.edu.unicundi.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.edu.unicundi.entity.InformeSemestral;


@Repository
public interface IInformeSemestral extends JpaRepository<InformeSemestral, Integer>{
	List<InformeSemestral> findByOrderById();
}
