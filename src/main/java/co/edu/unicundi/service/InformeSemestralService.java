package co.edu.unicundi.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.edu.unicundi.entity.Administrativo;
import co.edu.unicundi.entity.Asesoria;
import co.edu.unicundi.entity.Docente;
import co.edu.unicundi.entity.InformeSemestral;
import co.edu.unicundi.entity.Materia;
import co.edu.unicundi.entity.ProgramaAcademico;
import co.edu.unicundi.exception.ModelNotFoundException;
import co.edu.unicundi.repo.IDocenteRepo;
import co.edu.unicundi.repo.IInformeSemestral;
import co.edu.unicundi.repo.IMateriaRepo;
import co.edu.unicundi.repo.IProgramaAcademicoRepo;

@Service
@Transactional
public class InformeSemestralService {
	
	@Autowired
	IInformeSemestral repo;
	
	@Autowired
	IMateriaRepo repoMateria;
	
	@Autowired
	IProgramaAcademicoRepo repoPrograma;
	
	@Autowired
	IDocenteRepo repoDocente;
	
	public List<InformeSemestral> list(){
        return repo.findByOrderById();
    }

    public Optional<InformeSemestral> getOne(int id){
        return repo.findById(id);
    }

    public void update (InformeSemestral informeSemes) throws ModelNotFoundException {
    	InformeSemestral e = getOne(informeSemes.getId()).get();
    	Materia materia = repoMateria.findById(informeSemes.getNucleoTemático().getMate_id()).orElseThrow(
                () -> new ModelNotFoundException("materia no  exontrado"));
    	ProgramaAcademico programa = repoPrograma.findById(informeSemes.getProgramaacademico().getPrac_id()).orElseThrow(
                () -> new ModelNotFoundException("programa academico no  exontrado"));
    	
    	Docente docente = repoDocente.findById(informeSemes.getDocente().getId()).orElseThrow(
                () -> new ModelNotFoundException("Docente no  exontrado"));
    	
    	e.setNombre(informeSemes.getNombre());
    	e.setTipoArchivo(informeSemes.getTipoArchivo());
    	e.setTamaño(informeSemes.getTamaño());
    	e.setFecha(informeSemes.getFecha());
    	e.setSemestre(informeSemes.getSemestre());
    	e.setGrupo(informeSemes.getGrupo());
    	e.setAño(informeSemes.getAño());
    	e.setPeriodoAca(informeSemes.getPeriodoAca());
    	e.setMateria(materia);
    	e.setEstudianteApro(informeSemes.getEstudianteApro());
    	e.setEstudianteNoApro(informeSemes.getEstudianteNoApro());
    	e.setEstudianteRetirado(informeSemes.getEstudianteRetirado());
    	e.setDocente(docente);
    	e.setProgramaacademico(programa);
        repo.save(e);
    }
    public void save(InformeSemestral informeSemes){
    	repo.save(informeSemes);
    }

    public void delete(int id){
        repo.deleteById(id);
    }

    public boolean exists(int id){
        return repo.existsById(id);
    }
    
    public List<InformeSemestral> listarDocente(int id){
    	List<InformeSemestral> lista = new ArrayList<InformeSemestral>();
    	for(InformeSemestral p: repo.findByOrderById()) {
			if(p.getDocente().getId()==id) {
				lista.add(p);
			}
				
		}
         return lista;
    }
	
}
