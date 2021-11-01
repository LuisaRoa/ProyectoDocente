package co.edu.unicundi.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.unicundi.entity.Cronograma;


public interface ICronogramaRepo extends JpaRepository<Cronograma, Integer>{

	List<Cronograma> findByOrderById();
}
