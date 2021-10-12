package co.edu.unicundi.service;

import java.util.List;

import co.edu.unicundi.entity.Docente;
import co.edu.unicundi.exception.ModelNotFoundException;



public interface IDocenteService  {
	
	public Docente buscarId(int id) throws ModelNotFoundException;

	public List<Docente>mostrarDocentes() throws ModelNotFoundException;
	
	public void guardar(Docente profesor) throws Exception;
	
	public void editar(Docente profesor) throws Exception, ModelNotFoundException;
	
	public void eliminar(int id) throws ModelNotFoundException;

	public Docente buscarCorreo(String correo) throws ModelNotFoundException;

	public List<Docente> listarAdministrativo(int id) throws ModelNotFoundException;
	
	
}
