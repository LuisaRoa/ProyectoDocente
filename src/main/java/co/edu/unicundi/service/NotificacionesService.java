package co.edu.unicundi.service;

import java.util.List;

import co.edu.unicundi.entity.Notificaciones;
import co.edu.unicundi.exception.ModelNotFoundException;

public interface NotificacionesService {
	
	public Notificaciones buscarId(int id) throws ModelNotFoundException;

	public List<Notificaciones>mostrarNotificaciones() throws ModelNotFoundException;
	
	public void guardar(Notificaciones notificacion) throws Exception;
	
	public void editar(Notificaciones notificacion) throws Exception, ModelNotFoundException;
	
	public void eliminar(int id) throws ModelNotFoundException;
}
