package co.edu.unicundi.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.edu.unicundi.entity.SolicitudSalida;

@Repository
public interface ISolicitudSalidaRepo extends JpaRepository<SolicitudSalida, Integer>{

}
