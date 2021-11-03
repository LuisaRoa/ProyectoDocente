package co.edu.unicundi.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.edu.unicundi.entity.AdjuntarEvidencia;
import co.edu.unicundi.exception.ModelNotFoundException;
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
    	e.setNombre(evid.getNombre());
    	e.setFechaModificacion(evid.getFechaModificacion());
    	e.setCorte(evid.getCorte());
    	e.setTipoArchivo(evid.getTipoArchivo());
    	e.setTamaño(evid.getTamaño());
    	e.setAulasvirtuales(evid.getAulaVirtual());
    	LocalDate fecha = LocalDate.parse(evid.getFechaModificacion());
    	if((fecha.getMonthValue()>=1)&&(fecha.getMonthValue()<=6)) {
    		e.setPeriodo("1");
    	}else {
    		e.setPeriodo("2");
    	}
        repo.save(e);
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
    
    public List<AdjuntarEvidencia> evidenciaPorIdAula(int id){
    	List<AdjuntarEvidencia> lista = new ArrayList<AdjuntarEvidencia>();
    	for(AdjuntarEvidencia p: repo.findByOrderById()) {
			if(p.getAulaVirtual().getAuvi_id()==id) {
				lista.add(p);
			}
				
		}
    	return lista;
    }
    
    public List<AdjuntarEvidencia> listarDocente(int id){
    	List<AdjuntarEvidencia> evidencia = new ArrayList<AdjuntarEvidencia>();
    	for(AdjuntarEvidencia p: repo.findByOrderById()) {
			if(p.getAulaVirtual().getDocente().getId()==id) {
				evidencia.add(p);
			}
				
		}
         return evidencia;
    }
    
    public List<AdjuntarEvidencia> mostrarEvidencias(String año) throws ModelNotFoundException {
		return this.repo.numerodeEvidencias(año);
	}
    public List<AdjuntarEvidencia> mostrarEvidenciasP(String año, String periodo) throws ModelNotFoundException {
		return this.repo.evidenciasperiodo(año, periodo);
	}
    
}
