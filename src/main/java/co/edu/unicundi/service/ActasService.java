package co.edu.unicundi.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.edu.unicundi.entity.Actas;
import co.edu.unicundi.entity.AdjuntarEvidencia;
import co.edu.unicundi.entity.Asesoria;
import co.edu.unicundi.exception.ModelNotFoundException;
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
    	e.setNombre(evid.getNombre());
    	e.setPeriodo(evid.getPeriodo());
    	e.setLugar(evid.getLugar());
    	e.setFecha(evid.getFecha());
    	e.setTipoArchivo(evid.getTipoArchivo());
    	e.setTamaño(evid.getTamaño());
    	e.setComite(evid.getComite());
    	LocalDate fecha = LocalDate.parse(evid.getFecha());
    	if((fecha.getMonthValue()>=1)&&(fecha.getMonthValue()<=6)) {
    		e.setPeriodo("1");
    	}else {
    		e.setPeriodo("2");
    	}
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
    
    public List<Actas> listarComite(int id){
    	List<Actas> actas = new ArrayList<Actas>();
    	for(Actas p: repo.findByOrderById()) {
			if(p.getComite().getComi_id()==id) {
				actas.add(p);
			}
				
		}
         return actas;
    }
    
    public List<Actas> mostrarActas(String año) throws ModelNotFoundException {
		return this.repo.numerodeActas(año);
	}
    public List<Actas> mostrarActasP(String año, String periodo) throws ModelNotFoundException {
		return this.repo.actasperiodo(año, periodo);
	}
}
