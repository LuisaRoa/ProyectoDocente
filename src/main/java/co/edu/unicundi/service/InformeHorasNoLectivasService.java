package co.edu.unicundi.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.edu.unicundi.entity.Docente;
import co.edu.unicundi.entity.Facultad;
import co.edu.unicundi.entity.InformeHorasNoLectivas;
import co.edu.unicundi.entity.Materia;
import co.edu.unicundi.entity.ProgramaAcademico;
import co.edu.unicundi.exception.ModelNotFoundException;
import co.edu.unicundi.repo.IDocenteRepo;
import co.edu.unicundi.repo.IFacultadRepo;
import co.edu.unicundi.repo.IInformeHorasNoLectivasRepo;
import co.edu.unicundi.repo.IMateriaRepo;
import co.edu.unicundi.repo.IProgramaAcademicoRepo;

@Service
@Transactional
public class InformeHorasNoLectivasService {

	@Autowired
	IInformeHorasNoLectivasRepo repo;
	
	@Autowired
	IFacultadRepo repoF;
	
	@Autowired
	IProgramaAcademicoRepo repoPrograma;
	
	@Autowired
	IDocenteRepo repoDocente;
	
	public List<InformeHorasNoLectivas> list(){
        return repo.findByOrderById();
    }

    public Optional<InformeHorasNoLectivas> getOne(int id){
        return repo.findById(id);
    }

    public void update (InformeHorasNoLectivas informe) throws ModelNotFoundException {
    	InformeHorasNoLectivas e = getOne(informe.getId()).get();
    	Facultad facultad = repoF.findById(informe.getFacultad().getFacu_id()).orElseThrow(
                () -> new ModelNotFoundException("programa academico no  exontrado"));
    	
    	ProgramaAcademico programa = repoPrograma.findById(informe.getProgramaacademico().getPrac_id()).orElseThrow(
                () -> new ModelNotFoundException("programa academico no  exontrado"));
    	
    	Docente docente = repoDocente.findById(informe.getDocente().getId()).orElseThrow(
                () -> new ModelNotFoundException("Docente no  exontrado"));
    	
    	e.setNombre(informe.getNombre());
    	e.setTipoArchivo(informe.getTipoArchivo());
    	e.setTamaño(informe.getTamaño());
    	e.setFecha(informe.getFecha());
    	e.setSemestre(informe.getSemestre());
    	e.setGrupo(informe.getGrupo());
    	e.setAño(informe.getAño());
    	e.setPeriodoAca(informe.getPeriodoAca());
    	e.setDocente(docente);
    	e.setProgramaacademico(programa);
    	e.setFacultad(facultad);
        repo.save(e);
    }
    public void save(InformeHorasNoLectivas informe){
    	repo.save(informe);
    }

    public void delete(int id){
        repo.deleteById(id);
    }

    public boolean exists(int id){
        return repo.existsById(id);
    }
    
    public List<InformeHorasNoLectivas> listarDocente(int id){
    	List<InformeHorasNoLectivas> lista = new ArrayList<InformeHorasNoLectivas>();
    	for(InformeHorasNoLectivas p: repo.findByOrderById()) {
			if(p.getDocente().getId()==id) {
				lista.add(p);
			}
				
		}
         return lista;
    }
}
