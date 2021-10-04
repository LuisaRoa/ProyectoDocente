package co.edu.unicundi.service;

import java.util.List;

import co.edu.unicundi.entity.SolicitudSalida;
import co.edu.unicundi.exception.ModelNotFoundException;

public interface ISolicitudSalidaService {

	public SolicitudSalida buscarId(int id) throws ModelNotFoundException;

	public List<SolicitudSalida>mostrarSolicitudSalida() throws ModelNotFoundException;
	
	public void guardar(SolicitudSalida soli) throws Exception;
	
	public void editar(SolicitudSalida soli) throws Exception, ModelNotFoundException;
	
	public void eliminar(int id) throws ModelNotFoundException;
	
	public List<SolicitudSalida> retornarEstado() throws ModelNotFoundException;
	
}
