package co.edu.unicundi.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.edu.unicundi.entity.ProgramaAcademico;


@Repository
public interface IProgramaAcademicoRepo extends JpaRepository<ProgramaAcademico, Integer>{

}
