package co.edu.unicundi.service;

import java.util.List;

import co.edu.unicundi.entity.Docente;
import co.edu.unicundi.entity.SolicitudAulas;
import co.edu.unicundi.exception.ModelNotFoundException;

public interface ISolicitudAulasService {
	
	public SolicitudAulas buscarId(int id) throws ModelNotFoundException;

	public List<SolicitudAulas>mostrarSolicitudAulas() throws ModelNotFoundException;
	
	public void guardar(SolicitudAulas soli) throws Exception;
	
	public void editar(SolicitudAulas soli) throws Exception, ModelNotFoundException;
	
	public void eliminar(int id) throws ModelNotFoundException;

	public List<SolicitudAulas> listarAdministrativo(int id) throws ModelNotFoundException;
}
