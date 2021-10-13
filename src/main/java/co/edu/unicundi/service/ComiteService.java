package co.edu.unicundi.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.edu.unicundi.entity.Administrativo;
import co.edu.unicundi.entity.AulasVirtuales;
import co.edu.unicundi.entity.Comite;
import co.edu.unicundi.entity.Rol;
import co.edu.unicundi.exception.ModelNotFoundException;
import co.edu.unicundi.repo.IComiteRepo;



@Service
@Transactional
public class ComiteService {
	
	
	@Autowired
    IComiteRepo repo;

    public List<Comite> list(){
        return repo.findByOrderById();
    }

    public Optional<Comite> getOne(int id){
        return repo.findById(id);
    }

    List<Comite> Comite = new ArrayList<Comite>();
    
	public Comite buscarId(int id) throws ModelNotFoundException {
		
		Comite C = repo.findById(id).orElseThrow(
                () -> new ModelNotFoundException("docente no exontrado"));
        return C;

	}


	public List<Comite> mostrarComite() throws ModelNotFoundException {
		return this.repo.findAll();
	}


	public void guardar(Comite comite) throws Exception {
		
		this.repo.save(comite);
	}


	public void editar(Comite comite) throws Exception, ModelNotFoundException {
		Comite pro = this.buscarId(comite.getId());
		
        pro.setNombre(comite.getNombre());
        pro.setNombreActividadAcademica(comite.getNombreActividadAcademica());;
        pro.setClaseDeActividad(comite.getClaseDeActividad());
        pro.setLugarDeEjecucion(comite.getLugarDeEjecucion());
        pro.setFechaInicio(comite.getFechaInicio());
        pro.setFechaFinalizacion(comite.getFechaFinalizacion());
        pro.setCertificacion(comite.getCertificacion());
        pro.setIntensidadHoraria(comite.getIntensidadHoraria());
        this.repo.save(pro);
	}


	public void eliminar(int id) throws ModelNotFoundException {
		this.repo.delete(this.buscarId(id));
	}
	
}
