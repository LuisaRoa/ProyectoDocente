package co.edu.unicundi.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.edu.unicundi.entity.InformeRecuperacionClase;

@Repository
public interface IRecuperacionClaseRepo extends JpaRepository<InformeRecuperacionClase, Integer>{

	List<InformeRecuperacionClase> findByOrderById();
}
