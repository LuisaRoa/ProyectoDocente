package co.edu.unicundi.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.unicundi.entity.CierreAcademico;

public interface ICierreAcademico extends JpaRepository<CierreAcademico, Integer>{
	
	List<CierreAcademico> findByOrderById();

}
