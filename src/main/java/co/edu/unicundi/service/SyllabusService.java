package co.edu.unicundi.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.edu.unicundi.entity.Asesoria;
import co.edu.unicundi.entity.Docente;
import co.edu.unicundi.entity.Materia;
import co.edu.unicundi.entity.ProgramaAcademico;
import co.edu.unicundi.entity.Syllabus;
import co.edu.unicundi.exception.ModelNotFoundException;
import co.edu.unicundi.repo.IDocenteRepo;
import co.edu.unicundi.repo.IMateriaRepo;
import co.edu.unicundi.repo.IProgramaAcademicoRepo;
import co.edu.unicundi.repo.ISyllabusRepo;

@Service
@Transactional
public class SyllabusService {
	
	@Autowired
	ISyllabusRepo repo;

	@Autowired
	IMateriaRepo repoMateria;
	
	@Autowired
	IProgramaAcademicoRepo repoPrograma;
	
	@Autowired
	IDocenteRepo repoDocente;
	
	public List<Syllabus> list(){
        return repo.findByOrderById();
    }

    public Optional<Syllabus> getOne(int id){
        return repo.findById(id);
    }

    public void update (Syllabus syllabus) throws ModelNotFoundException {
    	Syllabus e = getOne(syllabus.getId()).get();
    	Materia materia = repoMateria.findById(syllabus.getNucleoTemático().getMate_id()).orElseThrow(
                () -> new ModelNotFoundException("materia no  exontrado"));
    	ProgramaAcademico programa = repoPrograma.findById(syllabus.getProgramaacademico().getPrac_id()).orElseThrow(
                () -> new ModelNotFoundException("programa academico no  exontrado"));
    	
    	Docente docente = repoDocente.findById(syllabus.getDocente().getId()).orElseThrow(
                () -> new ModelNotFoundException("Docente no  exontrado"));
    	
    	e.setNombre(syllabus.getNombre());
    	e.setTipoArchivo(syllabus.getTipoArchivo());
    	e.setTamaño(syllabus.getTamaño());
    	e.setFecha(syllabus.getFecha());
    	e.setSemestre(syllabus.getSemestre());
    	e.setGrupo(syllabus.getGrupo());
    	e.setPeriodoAca(syllabus.getPeriodoAca());
    	e.setMateria(materia);
    	e.setDocente(docente);
    	e.setHorasSemestral(syllabus.getHorasSemestral());
    	e.setProgramaacademico(programa);
        repo.save(e);
    }
    public void save(Syllabus syllabus){
    	repo.save(syllabus);
    }

    public void delete(int id){
        repo.deleteById(id);
    }

    public boolean exists(int id){
        return repo.existsById(id);
    }
    
    public List<Syllabus> listarDocente(int id){
    	List<Syllabus> syllabus = new ArrayList<Syllabus>();
    	for(Syllabus p: repo.findByOrderById()) {
			if(p.getDocente().getId()==id) {
				syllabus.add(p);
			}
				
		}
         return syllabus;
    }
    
    public List<Syllabus> listarAño(String año){
 
         return repo.buscarPorAño(año);
    }
}
