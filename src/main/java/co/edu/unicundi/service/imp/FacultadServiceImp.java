package co.edu.unicundi.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.unicundi.entity.Facultad;
import co.edu.unicundi.exception.ModelNotFoundException;
import co.edu.unicundi.repo.IFacultadRepo;
import co.edu.unicundi.service.IFacultadService;

@Service
public class FacultadServiceImp implements IFacultadService {

	@Autowired
	private IFacultadRepo repo;


	public Facultad buscarId(int id) throws ModelNotFoundException {
		Facultad facu = repo.findById(id).orElseThrow(
                () -> new ModelNotFoundException("facultad no exontrada"));
        return facu;
	}

	public List<Facultad> mostrarFacultad() throws ModelNotFoundException {
		return this.repo.findAll();
	}

	
	public void guardar(Facultad facu) throws Exception {
		this.repo.save(facu);
	}

	
	public void editar(Facultad facu) throws Exception, ModelNotFoundException {
		Facultad fa = this.buscarId(facu.getFacu_id());
		fa.setNombre(fa.getNombre());
	}

	
	public void eliminar(int id) throws ModelNotFoundException {
		this.repo.delete(this.buscarId(id));
		
	}

}
