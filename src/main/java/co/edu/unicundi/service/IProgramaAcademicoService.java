package co.edu.unicundi.service;

import java.util.List;

import co.edu.unicundi.entity.ProgramaAcademico;
import co.edu.unicundi.exception.ModelNotFoundException;

public interface IProgramaAcademicoService {
	
	public ProgramaAcademico buscarId(int id) throws ModelNotFoundException;

	public List<ProgramaAcademico>mostrarProgramaAcademico() throws ModelNotFoundException;
	
	public void guardar(ProgramaAcademico prac) throws Exception;
	
	public void editar(ProgramaAcademico prac) throws Exception, ModelNotFoundException;
	
	public void eliminar(int id) throws ModelNotFoundException;

}
