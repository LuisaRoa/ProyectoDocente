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
import co.edu.unicundi.entity.Docente;
import co.edu.unicundi.entity.Materia;
import co.edu.unicundi.entity.MateriaSalida;
import co.edu.unicundi.entity.Miembros;
import co.edu.unicundi.entity.Rol;
import co.edu.unicundi.exception.ModelNotFoundException;
import co.edu.unicundi.repo.IComiteRepo;
import co.edu.unicundi.repo.IDocenteRepo;



@Service
@Transactional
public class ComiteService {
	
	
	@Autowired
    IComiteRepo repo;
	
	@Autowired 
	IDocenteRepo repoDocente;

    public List<Comite> list(){
        return repo.findAll();
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
		if(comite.getMiembros()!=null) {
			for(Miembros p: comite.getMiembros()) {
				Docente docente = repoDocente.findById(p.getDocente().getId()).orElseThrow(
		                () -> new ModelNotFoundException("docente no  exontrada"));
				System.out.println(docente.getContrato());
				if(docente.getContrato().equals("Hora Cátedra")) {
					throw new Exception("Error, tipo de contrato hora cátedra");
				}
				p.setDocente(docente);
				p.setComite(comite);
			}
		}
		this.repo.save(comite);
	}


	public void editar(Comite comite) throws Exception, ModelNotFoundException {
		Comite pro = this.buscarId(comite.getComi_id());
		
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
	
	public List<Comite> listarPorIdDocente(int id) {
		List<Comite> lista = new ArrayList<Comite>();
		List<Miembros> listaM = new ArrayList<Miembros>();
		boolean bandera= false;
		for(Comite p: repo.findAll()) {
			bandera = false;
			for(Miembros m: p.getMiembros()) {
				if(m.getDocente().getId()==id) {
					bandera= true;
				}
			}
			if(bandera==true) {
				lista.add(p);
			}
			
		}
		
		return lista;
	}
	
}
