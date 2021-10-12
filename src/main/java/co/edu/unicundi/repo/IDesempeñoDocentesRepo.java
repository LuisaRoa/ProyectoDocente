package co.edu.unicundi.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.edu.unicundi.entity.DesempeñoDocentes;


@Repository
public interface IDesempeñoDocentesRepo extends JpaRepository<DesempeñoDocentes, Integer>{

	List<DesempeñoDocentes> findByOrderById();
}
