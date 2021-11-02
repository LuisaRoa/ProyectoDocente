package co.edu.unicundi.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import co.edu.unicundi.entity.Productos;

public interface IProductoRepo extends JpaRepository<Productos, Integer> {
	List<Productos> findByOrderById();
	
	@Query(value="SELECT * FROM productos where productos.fecha_elaboracion LIKE %?1%", nativeQuery = true)
	public List<Productos>numerodeProductos(@Param("año") String año);
	
	@Query(value="SELECT * FROM productos where productos.fecha_elaboracion LIKE %?1% and productos.periodo_aca=?2", nativeQuery = true)
	public List<Productos>productosperiodo(@Param("año") String año, @Param("periodo") String periodo);

}
