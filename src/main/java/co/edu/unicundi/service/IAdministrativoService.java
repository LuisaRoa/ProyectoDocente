package co.edu.unicundi.service;

import java.util.List;

import org.springframework.stereotype.Service;

import co.edu.unicundi.entity.Administrativo;
import co.edu.unicundi.exception.ModelNotFoundException;



public interface IAdministrativoService {
	
	public Administrativo buscarId(int id) throws ModelNotFoundException;

	public List<Administrativo>mostrarAdministrativos() throws ModelNotFoundException;
	
	public void guardar(Administrativo admi) throws Exception;
	
	public void editar(Administrativo admi) throws Exception, ModelNotFoundException;
	
	public void eliminar(int id) throws ModelNotFoundException;


}
