package co.edu.unicundi.repo;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import co.edu.unicundi.entity.AulasVirtuales;

public interface IAulasVirtualesRepo extends JpaRepository<AulasVirtuales, Integer> {
	

}
