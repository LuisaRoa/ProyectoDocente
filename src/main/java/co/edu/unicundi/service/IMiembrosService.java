package co.edu.unicundi.service;

import java.util.List;

import co.edu.unicundi.entity.Miembros;
import co.edu.unicundi.exception.ModelNotFoundException;

public interface IMiembrosService {
	
	public Miembros buscarId(int id) throws ModelNotFoundException;

	public List<Miembros>mostrarMiembros() throws ModelNotFoundException;
	
	public void guardar(Miembros mien) throws Exception;
	
	public void editar(Miembros mien) throws Exception, ModelNotFoundException;
	
	public void eliminar(int id) throws ModelNotFoundException;


}
