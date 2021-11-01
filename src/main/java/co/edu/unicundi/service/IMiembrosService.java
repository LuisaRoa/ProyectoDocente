package co.edu.unicundi.service;

import java.util.List;

import co.edu.unicundi.dto.MiembrosDto;
import co.edu.unicundi.entity.Docente;
import co.edu.unicundi.entity.Miembros;
import co.edu.unicundi.exception.ModelNotFoundException;

public interface IMiembrosService {

	public void guardarNativo(MiembrosDto miembros) throws ModelNotFoundException;

	List<Miembros> listarPorIdDocente(int id);


}
