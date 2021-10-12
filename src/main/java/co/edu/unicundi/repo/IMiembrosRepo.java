package co.edu.unicundi.repo;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import co.edu.unicundi.entity.InformeSalidas;
import co.edu.unicundi.entity.Miembros;



@Repository
public interface IMiembrosRepo extends JpaRepository<Miembros, Integer> {


}
