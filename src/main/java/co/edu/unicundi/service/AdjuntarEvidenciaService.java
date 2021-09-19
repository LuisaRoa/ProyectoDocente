package co.edu.unicundi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.edu.unicundi.entity.AdjuntarEvidencia;
import co.edu.unicundi.entity.Imagen;
import co.edu.unicundi.repo.IAdjuntarEvidenciasRepo;


@Service
@Transactional
public class AdjuntarEvidenciaService {
	
	@Autowired
    IAdjuntarEvidenciasRepo repo;

    public List<AdjuntarEvidencia> list(){
        return repo.findByOrderById();
    }

    public Optional<AdjuntarEvidencia> getOne(int id){
        return repo.findById(id);
    }

    public void update (AdjuntarEvidencia evid) {
    	AdjuntarEvidencia e = getOne(evid.getId()).get();
    	e.setName(evid.getName());
    	e.setAulasvirtuales(evid.getAulasvirtuales());
        repo.save(evid);
    }
    public void save(AdjuntarEvidencia evi){
    	repo.save(evi);
    }

    public void delete(int id){
        repo.deleteById(id);
    }

    public boolean exists(int id){
        return repo.existsById(id);
    }
}
