package co.edu.unicundi.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.unicundi.entity.Materia;
import co.edu.unicundi.exception.ModelNotFoundException;
import co.edu.unicundi.repo.IMateriaRepo;
import co.edu.unicundi.service.IMateriaService;

@Service
public class MateriaServiceImp implements IMateriaService {
	
	@Autowired
	private IMateriaRepo repo;


	public Materia buscarId(int id) throws ModelNotFoundException {
		Materia mate = repo.findById(id).orElseThrow(
                () -> new ModelNotFoundException("materia no exontrada"));
        return mate;
	}

	public List<Materia> mostrarMateria() throws ModelNotFoundException {
		return this.repo.findAll();
	}

	
	public void guardar(Materia mate) throws Exception {
		this.repo.save(mate);
	}

	
	public void editar(Materia mate) throws Exception, ModelNotFoundException {
		Materia mat = this.buscarId(mate.getMate_id());
		mat.setNombre(mate.getNombre());
        mat.setSemestre(mate.getSemestre());
	}

	@Override
	public void eliminar(int id) throws ModelNotFoundException {
		this.repo.delete(this.buscarId(id));
		
	}

}
