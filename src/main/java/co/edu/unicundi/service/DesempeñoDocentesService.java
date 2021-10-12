package co.edu.unicundi.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.edu.unicundi.entity.Administrativo;
import co.edu.unicundi.entity.DesempeñoDocentes;
import co.edu.unicundi.exception.ModelNotFoundException;
import co.edu.unicundi.repo.IAdministrativoRepo;
import co.edu.unicundi.repo.IDesempeñoDocentesRepo;

@Service
@Transactional
public class DesempeñoDocentesService {

	@Autowired
	IDesempeñoDocentesRepo repo;
	
	@Autowired
	IAdministrativoRepo repoAdmin;
	
	public List<DesempeñoDocentes> list(){
        return repo.findByOrderById();
    }

    public Optional<DesempeñoDocentes> getOne(int id){
        return repo.findById(id);
    }

    public void update (DesempeñoDocentes desempeñoDocentes) throws ModelNotFoundException {
    	DesempeñoDocentes e = getOne(desempeñoDocentes.getId()).get();
    	Administrativo administrativo = repoAdmin.findById(desempeñoDocentes.getAdministrativo().getAdmi_id()).orElseThrow(
                () -> new ModelNotFoundException("Administrativo no  exontrado"));
    	
    	e.setNombre(desempeñoDocentes.getNombre());
    	e.setTipoArchivo(desempeñoDocentes.getTipoArchivo());
    	e.setTamaño(desempeñoDocentes.getTamaño());
    	e.setFecha(desempeñoDocentes.getFecha());
    	e.setAdministrativo(administrativo);
    	e.setSemestre(desempeñoDocentes.getSemestre());
    	e.setPeriodoAca(desempeñoDocentes.getPeriodoAca());
        repo.save(e);
    }
    public void save(DesempeñoDocentes desempeñoDocentes){
    	repo.save(desempeñoDocentes);
    }

    public void delete(int id){
        repo.deleteById(id);
    }

    public boolean exists(int id){
        return repo.existsById(id);
    }
    
    public List<DesempeñoDocentes> listarAdministrativo(int id){
    	List<DesempeñoDocentes> lista = new ArrayList<DesempeñoDocentes>();
    	for(DesempeñoDocentes p: repo.findByOrderById()) {
			if(p.getAdministrativo().getId()==id) {
				lista.add(p);
			}
				
		}
         return lista;
    }
}
