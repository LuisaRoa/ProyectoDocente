package co.edu.unicundi.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.edu.unicundi.entity.AcuerdoPedagogico;
import co.edu.unicundi.entity.AdjuntarEvidencia;
import co.edu.unicundi.entity.Asesoria;
import co.edu.unicundi.entity.Docente;
import co.edu.unicundi.exception.ModelNotFoundException;
import co.edu.unicundi.repo.IAsesoria;
import co.edu.unicundi.repo.IDocenteRepo;


@Service
@Transactional
public class AsesoriaService {
	
	@Autowired
    IAsesoria repo;
	
	@Autowired
	IDocenteRepo repoDocente;

    public List<Asesoria> list(){
        return repo.findByOrderById();
    }

    public Optional<Asesoria> getOne(int id){
        return repo.findById(id);
    }

    public void update (Asesoria asesoria) throws ModelNotFoundException {
    	Asesoria e = getOne(asesoria.getId()).get();
    	Docente docente = repoDocente.findById(asesoria.getDocente().getId()).orElseThrow(
                () -> new ModelNotFoundException("Docente no  exontrado"));
    	e.setNombre(asesoria.getNombre());
    	e.setTipoArchivo(asesoria.getTipoArchivo());
    	e.setTamaño(asesoria.getTamaño());
    	e.setFecha(asesoria.getFecha());
    	e.setSemestre(asesoria.getSemestre());
    	e.setNucleo(asesoria.getNucleoTemático());
    	e.setPeriodo(asesoria.getPeriodo());
    	e.setDocente(docente);
        repo.save(e);
    }
    public void save(Asesoria evi){
    	repo.save(evi);
    }

    public void delete(int id){
        repo.deleteById(id);
    }

    public boolean exists(int id){
        return repo.existsById(id);
    }
    
    public List<Asesoria> listarDocente(int id){
    	List<Asesoria> asesorias = new ArrayList<Asesoria>();
    	for(Asesoria p: repo.findByOrderById()) {
			if(p.getDocente().getId()==id) {
				asesorias.add(p);
			}
				
		}
         return asesorias;
    }
    
    public List<Asesoria> mostrarAsesoria(String año) throws ModelNotFoundException {
		return this.repo.numerodeAsesoria(año);
	}
    public List<Asesoria> mostrarAsesoriaP(String año, String periodo) throws ModelNotFoundException {
		return this.repo.asesoriaperiodo(año, periodo);
	}
}
