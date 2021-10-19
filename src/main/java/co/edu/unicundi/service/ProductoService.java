package co.edu.unicundi.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.edu.unicundi.entity.Actas;
import co.edu.unicundi.entity.Productos;
import co.edu.unicundi.repo.IProductoRepo;

@Service
@Transactional
public class ProductoService {
	
	@Autowired
    IProductoRepo repo;

    public List<Productos> list(){
        return repo.findByOrderById();
    }

    public Optional<Productos> getOne(int id){
        return repo.findById(id);
    }

    public void update (Productos evid) {
    	Productos e = getOne(evid.getId()).get();
    	e.setName(evid.getName());
    	e.setFechaElaboración(evid.getFechaElaboración());
    	e.setTipoArchivo(evid.getTipoArchivo());
    	e.setTamaño(evid.getTamaño());
    	e.setComite(evid.getComite());
    	e.setNombre(evid.getNombre());
    	e.setProducto(evid.getProducto());
        repo.save(e);
    }
    public void save(Productos evi){
    	repo.save(evi);
    }

    public void delete(int id){
        repo.deleteById(id);
    }

    public boolean exists(int id){
        return repo.existsById(id);
    }
    
    public List<Productos> listarComite(int id){
    	List<Productos> actas = new ArrayList<Productos>();
    	for(Productos p: repo.findByOrderById()) {
			if(p.getComite().getComi_id()==id) {
				actas.add(p);
			}
				
		}
         return actas;
    }
}
