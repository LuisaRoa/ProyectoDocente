package co.edu.unicundi.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.unicundi.entity.AdjuntarEvidencia;


public interface IAdjuntarEvidenciasRepo extends JpaRepository<AdjuntarEvidencia, Integer>{
	 List<AdjuntarEvidencia> findByOrderById();
}