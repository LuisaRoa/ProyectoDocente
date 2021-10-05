package co.edu.unicundi.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.edu.unicundi.entity.AcuerdoPedagogico;
import co.edu.unicundi.entity.Asesoria;
import co.edu.unicundi.entity.Docente;
import co.edu.unicundi.entity.InformeRecuperacionClase;
import co.edu.unicundi.entity.Materia;
import co.edu.unicundi.entity.ProgramaAcademico;
import co.edu.unicundi.exception.ModelNotFoundException;
import co.edu.unicundi.repo.IDocenteRepo;
import co.edu.unicundi.repo.IMateriaRepo;
import co.edu.unicundi.repo.IProgramaAcademicoRepo;
import co.edu.unicundi.repo.IRecuperacionClaseRepo;

@Service
@Transactional
public class RecuperacionClaseService {
	
	@Autowired
	IRecuperacionClaseRepo repo;

	@Autowired
	IMateriaRepo repoMateria;
	
	@Autowired
	IProgramaAcademicoRepo repoPrograma;
	
	@Autowired
	IDocenteRepo repoDocente;
	
	public List<InformeRecuperacionClase> list(){
        return repo.findByOrderById();
    }

    public Optional<InformeRecuperacionClase> getOne(int id){
        return repo.findById(id);
    }

    public void update (InformeRecuperacionClase recuperacionClase) throws ModelNotFoundException {
    	InformeRecuperacionClase e = getOne(recuperacionClase.getId()).get();
    	Materia materia = repoMateria.findById(recuperacionClase.getNucleoTemático().getMate_id()).orElseThrow(
                () -> new ModelNotFoundException("materia no  exontrado"));
    	ProgramaAcademico programa = repoPrograma.findById(recuperacionClase.getProgramaacademico().getPrac_id()).orElseThrow(
                () -> new ModelNotFoundException("programa academico no  exontrado"));
    	
    	Docente docente = repoDocente.findById(recuperacionClase.getDocente().getId()).orElseThrow(
                () -> new ModelNotFoundException("Docente no  exontrado"));
    	
    	e.setNombre(recuperacionClase.getNombre());
    	e.setTipoArchivo(recuperacionClase.getTipoArchivo());
    	e.setTamaño(recuperacionClase.getTamaño());
    	e.setFecha(recuperacionClase.getFecha());
    	e.setSemestre(recuperacionClase.getSemestre());
    	e.setGrupo(recuperacionClase.getGrupo());
    	e.setPeriodoAca(recuperacionClase.getPeriodoAca());
    	e.setHorasRecuperadas(recuperacionClase.getHorasRecuperadas());
    	e.setMotivo(recuperacionClase.getMotivo());
    	e.setMateria(materia);
    	e.setDocente(docente);
    	e.setProgramaacademico(programa);
        repo.save(e);
    }
    public void save(InformeRecuperacionClase recuperacionClase){
    	repo.save(recuperacionClase);
    }

    public void delete(int id){
        repo.deleteById(id);
    }

    public boolean exists(int id){
        return repo.existsById(id);
    }
    
    public List<InformeRecuperacionClase> listarDocente(int id){
    	List<InformeRecuperacionClase> lista = new ArrayList<InformeRecuperacionClase>();
    	for(InformeRecuperacionClase p: repo.findByOrderById()) {
			if(p.getDocente().getId()==id) {
				lista.add(p);
			}
				
		}
         return lista;
    }
}
