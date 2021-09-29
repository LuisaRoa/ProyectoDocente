package co.edu.unicundi.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.edu.unicundi.entity.Miembros;



@Repository
public interface IMiembrosRepo extends JpaRepository<Miembros, Integer> {

}
