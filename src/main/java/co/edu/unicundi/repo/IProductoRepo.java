package co.edu.unicundi.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.unicundi.entity.Productos;

public interface IProductoRepo extends JpaRepository<Productos, Integer> {
	List<Productos> findByOrderById();

}
