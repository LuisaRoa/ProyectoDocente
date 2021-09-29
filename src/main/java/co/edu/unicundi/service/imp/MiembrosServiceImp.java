package co.edu.unicundi.service.imp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.unicundi.entity.Comite;
import co.edu.unicundi.entity.Docente;
import co.edu.unicundi.entity.Miembros;
import co.edu.unicundi.exception.ModelNotFoundException;
import co.edu.unicundi.repo.IComiteRepo;
import co.edu.unicundi.repo.IDocenteRepo;
import co.edu.unicundi.repo.IMiembrosRepo;
import co.edu.unicundi.service.IMiembrosService;


@Service
public class MiembrosServiceImp implements IMiembrosService  {

	@Autowired
	private IMiembrosRepo repo;
	
	@Autowired
	private IDocenteRepo repoDoce;
	
	@Autowired
	private IComiteRepo repoC;
	
	List<Miembros> mien = new ArrayList<Miembros>();

	public Miembros buscarId(int id) throws ModelNotFoundException {

		Miembros mien = repo.findById(id)
				.orElseThrow(() -> new ModelNotFoundException("Miembro no exontrado"));
		return mien;

	}

	public List<Miembros> mostrarMiembros() throws ModelNotFoundException {
		return this.repo.findAll();
	}

	public void guardar(Miembros mien) throws Exception {
		
			this.repo.save(mien);
	}

	public void editar(Miembros mien) throws Exception, ModelNotFoundException {
		
		Docente doce = repoDoce.findById(mien.getDocente().getId()).orElseThrow(
                () -> new ModelNotFoundException("docente no  exontrado"));
		
		Comite c = repoC.findById(mien.getComite().getId()).orElseThrow(
                () -> new ModelNotFoundException("comite no  exontrado"));
		
		Miembros m = this.buscarId(mien.getMien_id());
		m.setDocente(mien.getDocente());
		m.setComite(mien.getComite());
		this.repo.save(m);
	}

	public void eliminar(int id) throws ModelNotFoundException {
		this.repo.delete(this.buscarId(id));
	}
}
