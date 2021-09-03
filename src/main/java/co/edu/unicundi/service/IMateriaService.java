package co.edu.unicundi.service;

import java.util.List;


import co.edu.unicundi.entity.Materia;
import co.edu.unicundi.exception.ModelNotFoundException;

public interface IMateriaService {
	
	public Materia buscarId(int id) throws ModelNotFoundException;

	public List<Materia>mostrarMateria() throws ModelNotFoundException;
	
	public void guardar(Materia mate) throws Exception;
	
	public void editar(Materia mate) throws Exception, ModelNotFoundException;
	
	public void eliminar(int id) throws ModelNotFoundException;

}
