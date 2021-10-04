package co.edu.unicundi.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.edu.unicundi.entity.MateriaSalida;


@Repository
public interface IMateriaSalidaRepo extends JpaRepository<MateriaSalida, Integer>{

}
