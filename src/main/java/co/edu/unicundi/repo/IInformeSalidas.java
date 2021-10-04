package co.edu.unicundi.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.edu.unicundi.entity.InformeSalidas;


@Repository
public interface IInformeSalidas extends JpaRepository<InformeSalidas, Integer>{
	List<InformeSalidas> findByOrderById();
}
