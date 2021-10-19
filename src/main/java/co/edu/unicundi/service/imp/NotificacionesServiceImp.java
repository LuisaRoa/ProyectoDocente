package co.edu.unicundi.service.imp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.unicundi.entity.Docente;
import co.edu.unicundi.entity.Notificaciones;
import co.edu.unicundi.exception.ModelNotFoundException;
import co.edu.unicundi.repo.IDocenteRepo;
import co.edu.unicundi.repo.INotificacionesRepo;
import co.edu.unicundi.service.NotificacionesService;

@Service
public class NotificacionesServiceImp implements NotificacionesService {

	@Autowired
	private IDocenteRepo repoD;
	
	@Autowired
	private INotificacionesRepo repo;
	
	List<Notificaciones> notificaciones = new ArrayList<Notificaciones>();

	public Notificaciones buscarId(int id) throws ModelNotFoundException {

		Notificaciones n = repo.findById(id).orElseThrow(() -> new ModelNotFoundException("Notificacion no exontrada"));
		return n;

	}

	public List<Notificaciones> mostrarNotificaciones() throws ModelNotFoundException {
		return this.repo.findAll();
	}

	public void guardar(Notificaciones notificacion) throws Exception {
		for (Notificaciones p : notificaciones) {
			if (p.getNoti_id()==notificacion.getNoti_id()) {
				throw new Exception("Ya existe el docente");
			}

		}
		this.repo.save(notificacion);
	}


	public void editar(Notificaciones notificacion) throws Exception, ModelNotFoundException {
		Notificaciones pro = this.buscarId(notificacion.getNoti_id());

		Docente doce = repoD.findById(notificacion.getDocente().getId())
				.orElseThrow(() -> new ModelNotFoundException("docente no  exontrado"));
		
		pro.setNoti_observacion(notificacion.getNoti_observacion() );
		pro.setNoti_actividad(notificacion.getNoti_actividad());
		pro.setDocente(doce);
	
		this.repo.save(pro);
	}

	public void eliminar(int id) throws ModelNotFoundException {
		this.repo.delete(this.buscarId(id));
	}
}
