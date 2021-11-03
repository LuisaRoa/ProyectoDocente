package co.edu.unicundi.service;

import java.util.List;

import co.edu.unicundi.entity.AulasVirtuales;
import co.edu.unicundi.exception.ModelNotFoundException;

public interface IAulaVirtualService {
	
	public AulasVirtuales buscarId(int id) throws ModelNotFoundException;

	public List<AulasVirtuales>mostrarAulasVirtuales() throws ModelNotFoundException;
	
	public void guardar(AulasVirtuales mate) throws Exception;
	
	public void editar(AulasVirtuales mate) throws Exception, ModelNotFoundException;
	
	public void eliminar(int id) throws ModelNotFoundException;
	
	public List<AulasVirtuales>listarDocente(int id) ;

}
