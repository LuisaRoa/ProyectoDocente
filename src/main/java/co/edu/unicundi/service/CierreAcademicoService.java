package co.edu.unicundi.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.edu.unicundi.entity.Administrativo;
import co.edu.unicundi.entity.CierreAcademico;
import co.edu.unicundi.entity.Docente;
import co.edu.unicundi.entity.InformeSalidas;
import co.edu.unicundi.entity.SolicitudSalidas;
import co.edu.unicundi.exception.ModelNotFoundException;
import co.edu.unicundi.repo.IAdministrativoRepo;
import co.edu.unicundi.repo.ICierreAcademico;
import co.edu.unicundi.repo.IDocenteRepo;
import co.edu.unicundi.repo.IInformeSalidas;
import co.edu.unicundi.repo.ISolicitudSalidaRepo;

@Service
@Transactional
public class CierreAcademicoService {

	@Autowired
	ICierreAcademico repo;
	
	@Autowired
	IAdministrativoRepo repoAdmin;
	
	public List<CierreAcademico> list(){
        return repo.findByOrderById();
    }

    public Optional<CierreAcademico> getOne(int id){
        return repo.findById(id);
    }

    public void update (CierreAcademico cierreAcademico) throws ModelNotFoundException {
    	CierreAcademico e = getOne(cierreAcademico.getId()).get();
    	Administrativo administrativo = repoAdmin.findById(cierreAcademico.getAdministrativo().getAdmi_id()).orElseThrow(
                () -> new ModelNotFoundException("Administrativo no  exontrado"));
    	
    	e.setNombre(cierreAcademico.getNombre());
    	e.setTipoArchivo(cierreAcademico.getTipoArchivo());
    	e.setTamaño(cierreAcademico.getTamaño());
    	e.setFecha(cierreAcademico.getFecha());
    	e.setAdministrativo(administrativo);
    	e.setSemestre(cierreAcademico.getSemestre());
    	e.setPeriodoAca(cierreAcademico.getPeriodoAca());
        repo.save(e);
    }
    public void save(CierreAcademico cierreAcademico){
    	repo.save(cierreAcademico);
    }

    public void delete(int id){
        repo.deleteById(id);
    }

    public boolean exists(int id){
        return repo.existsById(id);
    }
    
    public List<CierreAcademico> listarAdministrativo(int id){
    	List<CierreAcademico> lista = new ArrayList<CierreAcademico>();
    	for(CierreAcademico p: repo.findByOrderById()) {
			if(p.getAdministrativo().getId()==id) {
				lista.add(p);
			}
				
		}
         return lista;
    }
}
