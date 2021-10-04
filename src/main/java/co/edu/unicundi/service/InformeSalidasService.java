package co.edu.unicundi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.edu.unicundi.entity.Docente;
import co.edu.unicundi.entity.InformeSalidas;
import co.edu.unicundi.entity.InformeSemestral;
import co.edu.unicundi.entity.Materia;
import co.edu.unicundi.entity.ProgramaAcademico;
import co.edu.unicundi.entity.SolicitudSalida;
import co.edu.unicundi.exception.ModelNotFoundException;
import co.edu.unicundi.repo.IDocenteRepo;
import co.edu.unicundi.repo.IInformeSalidas;
import co.edu.unicundi.repo.ISolicitudSalidaRepo;

@Service
@Transactional
public class InformeSalidasService {

	@Autowired
	IInformeSalidas repo;
	
	@Autowired
	ISolicitudSalidaRepo repoSolicitud;
	
	@Autowired
	IDocenteRepo repoDocente;
	
	public List<InformeSalidas> list(){
        return repo.findByOrderById();
    }

    public Optional<InformeSalidas> getOne(int id){
        return repo.findById(id);
    }

    public void update (InformeSalidas informeSalida) throws ModelNotFoundException {
    	InformeSalidas e = getOne(informeSalida.getId()).get();
    	Docente docente = repoDocente.findById(informeSalida.getDocente().getId()).orElseThrow(
                () -> new ModelNotFoundException("Docente no  exontrado"));
    	
    	SolicitudSalida salida = repoSolicitud.findById(informeSalida.getSolicitudSalida().getSosa_id()).orElseThrow(
                () -> new ModelNotFoundException("Solicitud no  exontrado"));
    	
    	e.setNombre(informeSalida.getNombre());
    	e.setTipoArchivo(informeSalida.getTipoArchivo());
    	e.setTamaño(informeSalida.getTamaño());
    	e.setFecha(informeSalida.getFecha());
    	e.setDocente(docente);
    	e.setSolicitudSalida(salida);
        repo.save(e);
    }
    public void save(InformeSalidas informeSalida){
    	repo.save(informeSalida);
    }

    public void delete(int id){
        repo.deleteById(id);
    }

    public boolean exists(int id){
        return repo.existsById(id);
    }
}
