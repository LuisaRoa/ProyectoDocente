package co.edu.unicundi.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.edu.unicundi.entity.Notificaciones;


@Repository
public interface INotificacionesRepo extends JpaRepository<Notificaciones, Integer>{

}
