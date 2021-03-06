package co.edu.unicundi.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.edu.unicundi.entity.AcuerdoPedagogico;
import co.edu.unicundi.entity.Asesoria;
import co.edu.unicundi.entity.Docente;
import co.edu.unicundi.entity.Materia;
import co.edu.unicundi.entity.ProgramaAcademico;
import co.edu.unicundi.entity.Syllabus;
import co.edu.unicundi.exception.ModelNotFoundException;
import co.edu.unicundi.repo.IAcuerdoPedagogicoRepo;
import co.edu.unicundi.repo.IDocenteRepo;
import co.edu.unicundi.repo.IMateriaRepo;
import co.edu.unicundi.repo.IProgramaAcademicoRepo;

@Service
@Transactional
public class AcuerdoPedagogicoService {

	@Autowired
	IAcuerdoPedagogicoRepo repo;

	@Autowired
	IMateriaRepo repoMateria;
	
	@Autowired
	IProgramaAcademicoRepo repoPrograma;
	
	@Autowired
	IDocenteRepo repoDocente;
	
	public List<AcuerdoPedagogico> list(){
        return repo.findByOrderById();
    }

    public Optional<AcuerdoPedagogico> getOne(int id){
        return repo.findById(id);
    }

    public void update (AcuerdoPedagogico acuerdoPedagogico) throws ModelNotFoundException {
    	AcuerdoPedagogico e = getOne(acuerdoPedagogico.getId()).get();
    	Materia materia = repoMateria.findById(acuerdoPedagogico.getNucleoTemático().getMate_id()).orElseThrow(
                () -> new ModelNotFoundException("materia no  exontrado"));
    	ProgramaAcademico programa = repoPrograma.findById(acuerdoPedagogico.getProgramaacademico().getPrac_id()).orElseThrow(
                () -> new ModelNotFoundException("programa academico no  exontrado"));
    	
    	Docente docente = repoDocente.findById(acuerdoPedagogico.getDocente().getId()).orElseThrow(
                () -> new ModelNotFoundException("Docente no  exontrado"));
    	
    	e.setNombre(acuerdoPedagogico.getNombre());
    	e.setTipoArchivo(acuerdoPedagogico.getTipoArchivo());
    	e.setTamaño(acuerdoPedagogico.getTamaño());
    	e.setFecha(acuerdoPedagogico.getFecha());
    	e.setSemestre(acuerdoPedagogico.getSemestre());
    	e.setGrupo(acuerdoPedagogico.getGrupo());
    	e.setPeriodoAca(acuerdoPedagogico.getPeriodoAca());
    	e.setMateria(materia);
    	e.setDocente(docente);
    	e.setProgramaacademico(programa);
        repo.save(e);
    }
    public void save(AcuerdoPedagogico acuerdoPedagogico){
    	repo.save(acuerdoPedagogico);
    }

    public void delete(int id){
        repo.deleteById(id);
    }

    public boolean exists(int id){
        return repo.existsById(id);
    }
    
    public List<AcuerdoPedagogico> listarDocente(int id){
    	List<AcuerdoPedagogico> acuerdoPedagogico = new ArrayList<AcuerdoPedagogico>();
    	for(AcuerdoPedagogico p: repo.findByOrderById()) {
			if(p.getDocente().getId()==id) {
				acuerdoPedagogico.add(p);
			}
				
		}
         return acuerdoPedagogico;
    }
    
    public List<AcuerdoPedagogico> mostrarAcuerdoPedagogico(String año, String periodo) throws ModelNotFoundException {
		return this.repo.numerodeaAcuerdos(año, periodo);
	}
    
    public List<AcuerdoPedagogico> mostrarAcuerdoPedagogicoA(String año) throws ModelNotFoundException {
		return this.repo.numerodeaAcuerdosA(año);
	}
}
