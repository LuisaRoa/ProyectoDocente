package co.edu.unicundi.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.edu.unicundi.entity.Cronograma;
import co.edu.unicundi.repo.ICronogramaRepo;

@Service
@Transactional
public class CronogramaService {

	@Autowired
    ICronogramaRepo repo;

    public List<Cronograma> list(){
        return repo.findByOrderById();
    }

    public Optional<Cronograma> getOne(int id){
        return repo.findById(id);
    }

    public void update (Cronograma evid) {
    	Cronograma e = getOne(evid.getId()).get();
    	e.setNombre(evid.getNombre());
    	e.setFecha(evid.getFecha());
    	e.setTipoArchivo(evid.getTipoArchivo());
    	e.setTamaño(evid.getTamaño());
    	e.setComite(evid.getComite());
        repo.save(e);
    }
    public void save(Cronograma evi){
    	repo.save(evi);
    }

    public void delete(int id){
        repo.deleteById(id);
    }

    public boolean exists(int id){
        return repo.existsById(id);
    }
    
    public List<Cronograma> listarComite(int id){
    	List<Cronograma> crono = new ArrayList<Cronograma>();
    	for(Cronograma p: repo.findByOrderById()) {
			if(p.getComite().getComi_id()==id) {
				crono.add(p);
			}
				
		}
         return crono;
    }
}
