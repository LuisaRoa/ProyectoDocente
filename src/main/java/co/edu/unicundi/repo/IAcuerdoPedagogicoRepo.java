package co.edu.unicundi.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.edu.unicundi.entity.AcuerdoPedagogico;


@Repository
public interface IAcuerdoPedagogicoRepo extends JpaRepository<AcuerdoPedagogico, Integer>{
	List<AcuerdoPedagogico> findByOrderById();

}
