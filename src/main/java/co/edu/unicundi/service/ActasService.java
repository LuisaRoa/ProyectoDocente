package co.edu.unicundi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.edu.unicundi.entity.Actas;
import co.edu.unicundi.entity.AdjuntarEvidencia;
import co.edu.unicundi.repo.IActasRepo;
import co.edu.unicundi.repo.IAdjuntarEvidenciasRepo;

@Service
@Transactional
public class ActasService {
	
	@Autowired
    IActasRepo repo;

    public List<Actas> list(){
        return repo.findByOrderById();
    }

    public Optional<Actas> getOne(int id){
        return repo.findById(id);
    }

    public void update (Actas evid) {
    	Actas e = getOne(evid.getId()).get();
    	e.setName(evid.getName());
    	e.setFechaModificacion(evid.getFechaModificacion());
    	e.setTipoArchivo(evid.getTipoArchivo());
    	e.setTamaño(evid.getTamaño());
    	e.setComite(evid.getComite());
        repo.save(e);
    }
    public void save(Actas evi){
    	repo.save(evi);
    }

    public void delete(int id){
        repo.deleteById(id);
    }

    public boolean exists(int id){
        return repo.existsById(id);
    }
}
