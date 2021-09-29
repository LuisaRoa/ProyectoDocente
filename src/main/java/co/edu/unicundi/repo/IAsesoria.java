package co.edu.unicundi.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.unicundi.entity.AdjuntarEvidencia;
import co.edu.unicundi.entity.Asesoria;


public interface IAsesoria extends JpaRepository<Asesoria, Integer>{
	List<Asesoria> findByOrderById();
}
