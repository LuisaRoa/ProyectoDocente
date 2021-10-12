package co.edu.unicundi.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.edu.unicundi.entity.AdjuntarEvidencia;
import co.edu.unicundi.entity.AulasVirtuales;
import co.edu.unicundi.entity.Docente;
import co.edu.unicundi.entity.Imagen;
import co.edu.unicundi.exception.ModelNotFoundException;
import co.edu.unicundi.repo.IAdjuntarEvidenciasRepo;
import co.edu.unicundi.repo.IAulasVirtualesRepo;


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
}
