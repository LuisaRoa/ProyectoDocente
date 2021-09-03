package co.edu.unicundi.service;

import java.util.List;

import co.edu.unicundi.entity.Facultad;
import co.edu.unicundi.exception.ModelNotFoundException;

public interface IFacultadService {
	
	public Facultad buscarId(int id) throws ModelNotFoundException;

	public List<Facultad>mostrarFacultad() throws ModelNotFoundException;
	
	public void guardar(Facultad facu) throws Exception;
	
	public void editar(Facultad facu) throws Exception, ModelNotFoundException;
	
	public void eliminar(int id) throws ModelNotFoundException;

}
