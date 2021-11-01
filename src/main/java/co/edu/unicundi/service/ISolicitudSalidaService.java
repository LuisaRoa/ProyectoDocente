package co.edu.unicundi.service;

import java.util.List;

import co.edu.unicundi.entity.SolicitudSalidas;
import co.edu.unicundi.exception.ModelNotFoundException;

public interface ISolicitudSalidaService {

	public SolicitudSalidas buscarId(int id) throws ModelNotFoundException;

	public List<SolicitudSalidas>mostrarSolicitudSalida() throws ModelNotFoundException;
	
	public void guardar(SolicitudSalidas soli) throws Exception;
	
	public void editar(SolicitudSalidas soli) throws Exception, ModelNotFoundException;
	
	public void eliminar(int id) throws ModelNotFoundException;
	
	public List<SolicitudSalidas> retornarEstado(int id) throws ModelNotFoundException;
	
	public List<SolicitudSalidas> listarDocente(int id) throws ModelNotFoundException;
	
	public List<SolicitudSalidas> listarAdministrativo(int id) throws ModelNotFoundException;
	
	public List<SolicitudSalidas> mostrarSolicitudes(String año) throws ModelNotFoundException;
	
	public List<SolicitudSalidas> mostrarSolicitudesP(String año, String periodo) throws ModelNotFoundException;
	
}
