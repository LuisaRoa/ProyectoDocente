package co.edu.unicundi.service.imp;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.unicundi.entity.Docente;
import co.edu.unicundi.entity.Materia;
import co.edu.unicundi.entity.MateriaSalida;
import co.edu.unicundi.entity.ProgramaAcademico;
import co.edu.unicundi.entity.SolicitudAulas;
import co.edu.unicundi.entity.SolicitudSalida;
import co.edu.unicundi.exception.ModelNotFoundException;
import co.edu.unicundi.repo.IDocenteRepo;
import co.edu.unicundi.repo.IMateriaRepo;
import co.edu.unicundi.repo.IMateriaSalidaRepo;
import co.edu.unicundi.repo.IProgramaAcademicoRepo;
import co.edu.unicundi.repo.ISolicitudAulasRepo;
import co.edu.unicundi.repo.ISolicitudSalidaRepo;
import co.edu.unicundi.service.ISolicitudSalidaService;


@Service
public class SolicitudSalidaServiceImp implements ISolicitudSalidaService{
	@Autowired
	private ISolicitudSalidaRepo repo;
	
	@Autowired
	private IDocenteRepo repoDoce;
	
	@Autowired
	private IProgramaAcademicoRepo repoPrograma;
	
	@Autowired
	private IMateriaRepo repoMateria;
	
	@Autowired
	private IMateriaSalidaRepo repoMateSalida;

	@Override
	public SolicitudSalida buscarId(int id) throws ModelNotFoundException {
		SolicitudSalida salida = repo.findById(id).orElseThrow(
                () -> new ModelNotFoundException("solicitud no exontrada"));
        return salida;
	}

	@Override
	public List<SolicitudSalida> mostrarSolicitudSalida() throws ModelNotFoundException {
		return this.repo.findAll();
	}

	@Override
	public void guardar(SolicitudSalida soli) throws Exception {
		if(soli.getMateria_solicitudsalidas()!=null) {
			for(MateriaSalida p: soli.getMateria_solicitudsalidas()) {
				Materia mater = repoMateria.findById(p.getMateria().getMate_id()).orElseThrow(
		                () -> new ModelNotFoundException("materia no  exontrada"));
				p.setMateria(mater);
				p.setSolicitudsalida(soli);
			}
		}
		
		this.repo.save(soli);
	}
		

	@Override
	public void editar(SolicitudSalida soli) throws Exception, ModelNotFoundException {
		
		SolicitudSalida so = this.buscarId(soli.getSosa_id());
		Docente doce = repoDoce.findById(soli.getDocente().getId()).orElseThrow(
                () -> new ModelNotFoundException("docente no  exontrado"));
		ProgramaAcademico programa = repoPrograma.findById(soli.getProgramaacademico().getPrac_id()).orElseThrow(
                () -> new ModelNotFoundException("programa academico no  exontrada"));
		so.setFechaSolicitud(soli.getFechaSolicitud());
		so.setEstado(soli.getEstado());
		so.setSemestre(soli.getSemestre());
		so.setFechaInicio(soli.getFechaInicio());
		so.setFechaTerminacion(soli.getFechaTerminacion());
		so.setNombre(soli.getNombre());
		so.setTipo(soli.getTipo());
		so.setNoEstudiantes(soli.getNoEstudiantes());
		so.setDocente(doce);
		so.setProgramaacademico(programa);
		
	}

	@Override
	public void eliminar(int id) throws ModelNotFoundException {
		this.repo.delete(this.buscarId(id));
	}

	@Override
	public List<SolicitudSalida> retornarEstado() throws ModelNotFoundException {
		List<SolicitudSalida> lista = new ArrayList();
		for(SolicitudSalida s: this.repo.findAll()) {
			if(s.getEstado().equals("Aprobado")) {
				lista.add(s);
			}
		}
		return lista;
	}
}
