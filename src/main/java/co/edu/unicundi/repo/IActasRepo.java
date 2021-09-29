package co.edu.unicundi.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.unicundi.entity.Actas;


public interface IActasRepo extends JpaRepository<Actas, Integer> {
	List<Actas> findByOrderById();
}
