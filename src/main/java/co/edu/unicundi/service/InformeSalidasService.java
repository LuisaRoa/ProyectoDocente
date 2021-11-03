package co.edu.unicundi.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.edu.unicundi.entity.Docente;
import co.edu.unicundi.entity.InformeSalidas;
import co.edu.unicundi.entity.SolicitudSalidas;
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
    	
    	SolicitudSalidas salida = repoSolicitud.findById(informeSalida.getSolicitudSalida().getSosa_id()).orElseThrow(
                () -> new ModelNotFoundException("Solicitud no  exontrado"));
    	
    	e.setNombre(informeSalida.getNombre());
    	e.setTipoArchivo(informeSalida.getTipoArchivo());
    	e.setTamaño(informeSalida.getTamaño());
    	e.setFecha(informeSalida.getFecha());
    	e.setDocente(docente);
    	e.setSolicitudSalida(salida);
    	LocalDate fecha = LocalDate.parse(informeSalida.getFecha());
    	if((fecha.getMonthValue()>=1)&&(fecha.getMonthValue()<=6)) {
    		e.setPeriodo("1");
    	}else {
    		e.setPeriodo("2");
    	}
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
    
    public List<InformeSalidas> listarDocente(int id){
    	List<InformeSalidas> lista = new ArrayList<InformeSalidas>();
    	for(InformeSalidas p: repo.findByOrderById()) {
			if(p.getDocente().getId()==id) {
				lista.add(p);
			}
				
		}
         return lista;
    }
    
    public List<InformeSalidas> mostrarInforme(String año, String periodo) throws ModelNotFoundException {
		return this.repo.salidasperiodo(año, periodo);
	}
    public List<InformeSalidas> mostrarInformeA(String año) throws ModelNotFoundException {
		return this.repo.salidasaño(año);
	}
}
