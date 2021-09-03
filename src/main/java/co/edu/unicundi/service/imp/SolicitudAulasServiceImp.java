package co.edu.unicundi.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.unicundi.entity.AulasVirtuales;
import co.edu.unicundi.entity.SolicitudAulas;
import co.edu.unicundi.exception.ModelNotFoundException;
import co.edu.unicundi.repo.ISolicitudAulasRepo;
import co.edu.unicundi.service.ISolicitudAulasService;

@Service
public class SolicitudAulasServiceImp implements ISolicitudAulasService{
	
	@Autowired
	private ISolicitudAulasRepo repo;

	@Override
	public SolicitudAulas buscarId(int id) throws ModelNotFoundException {
		SolicitudAulas aulas = repo.findById(id).orElseThrow(
                () -> new ModelNotFoundException("materia no exontrada"));
        return aulas;
	}

	@Override
	public List<SolicitudAulas> mostrarSolicitudAulas() throws ModelNotFoundException {
		return this.repo.findAll();
	}

	@Override
	public void guardar(SolicitudAulas soli) throws Exception {
		this.repo.save(soli);
		
	}

	@Override
	public void editar(SolicitudAulas soli) throws Exception, ModelNotFoundException {
		SolicitudAulas so = this.buscarId(soli.getSoau_id());
		so.setFecha(soli.getFecha());
		so.setEstado(soli.getEstado());
		
		
	}

	@Override
	public void eliminar(int id) throws ModelNotFoundException {
		this.repo.delete(this.buscarId(id));
	}

}
