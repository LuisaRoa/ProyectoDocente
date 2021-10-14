package co.edu.unicundi.service;

import java.util.List;

import co.edu.unicundi.entity.Docente;
import co.edu.unicundi.entity.Miembros;
import co.edu.unicundi.exception.ModelNotFoundException;

public interface IMiembrosService {

	public void guardarNativo(Miembros miembros);

	List<Miembros> listarPorIdDocente(Integer doce_id);

}
