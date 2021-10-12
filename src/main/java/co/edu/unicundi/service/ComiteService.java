package co.edu.unicundi.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import co.edu.unicundi.entity.Comite;
import co.edu.unicundi.repo.IComiteRepo;
import co.edu.unicundi.repo.IDocenteRepo;


@Service
@Transactional
public class ComiteService {
	
	@Autowired
	IDocenteRepo repoDocente; 
	
	@Autowired
    IComiteRepo repo;

    public List<Comite> list(){
        return repo.findByOrderById();
    }

    public Optional<Comite> getOne(int id){
        return repo.findById(id);
    }

    public void update (Comite com) {
    	Comite e = getOne(com.getId()).get();
    	e.setName(com.getName());
    	e.setFechaModificacion(com.getFechaModificacion());
    	e.setTipoArchivo(com.getTipoArchivo());
    	e.setTamaño(com.getTamaño());

        repo.save(e);
    }
    public void save(Comite com){
    	repo.save(com);
    }

    public void delete(int id){
        repo.deleteById(id);
    }

    public boolean exists(int id){
        return repo.existsById(id);
    }
   /* public List<Comite> listarPoIdDocente(int ids){
    	List<Comite> comite = new ArrayList<Comite>();
    	for(Comite p: repo.findByOrderById()) {
			//if(p.getMiembros().g{
				comite.add(p);
		//	}
				
		}
         return comite;
    }*/

}
