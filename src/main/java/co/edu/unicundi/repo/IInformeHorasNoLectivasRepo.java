package co.edu.unicundi.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.edu.unicundi.entity.InformeHorasNoLectivas;

@Repository
public interface IInformeHorasNoLectivasRepo extends JpaRepository<InformeHorasNoLectivas, Integer>{

	List<InformeHorasNoLectivas> findByOrderById();
}
