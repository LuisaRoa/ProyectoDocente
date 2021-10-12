package co.edu.unicundi.service.imp;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.unicundi.entity.Asesoria;
import co.edu.unicundi.entity.Docente;
import co.edu.unicundi.entity.Materia;
import co.edu.unicundi.entity.MateriaSalida;
import co.edu.unicundi.entity.ProgramaAcademico;
import co.edu.unicundi.entity.SolicitudAulas;
import co.edu.unicundi.entity.SolicitudSalidas;
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
	public SolicitudSalidas buscarId(int id) throws ModelNotFoundException {
		SolicitudSalidas salida = repo.findById(id).orElseThrow(
                () -> new ModelNotFoundException("solicitud no exontrada"));
        return salida;
	}

	@Override
	public List<SolicitudSalidas> mostrarSolicitudSalida() throws ModelNotFoundException {
		return this.repo.findAll();
	}

	@Override
	public void guardar(SolicitudSalidas soli) throws Exception {
		if(soli.getMateriaSalida()!=null) {
			for(MateriaSalida p: soli.getMateriaSalida()) {
				Materia mater = repoMateria.findById(p.getMateria().getMate_id()).orElseThrow(
		                () -> new ModelNotFoundException("materia no  exontrada"));
				p.setMateria(mater);
				p.setSolicitudSalida(soli);
			}
		}
		
		this.repo.save(soli);
	}
		

	@Override
	public void editar(SolicitudSalidas soli) throws Exception, ModelNotFoundException {
		
		SolicitudSalidas so = this.buscarId(soli.getSosa_id());
		Docente doce = repoDoce.findById(soli.getDocente().getId()).orElseThrow(
                () -> new ModelNotFoundException("docente no  exontrado"));
		ProgramaAcademico programa = repoPrograma.findById(soli.getProgramaacademico().getPrac_id()).orElseThrow(
                () -> new ModelNotFoundException("programa academico no  exontrada"));
		so.setFechaSolicitud(soli.getFechaSolicitud());
		so.setEstado(soli.getEstado());
		so.setSemestre(soli.getSemestre());
		so.setFechaInicio(soli.getFechaInicio());
		so.setFechaTerminación(soli.getFechaTerminación());
		so.setNombre(soli.getNombre());
		so.setTipoSalida(soli.getTipoSalida());
		so.setNoEstudiantes(soli.getNoEstudiantes());
		so.setDocente(doce);
		so.setProgramaacademico(programa);
		this.repo.save(so);
	}

	@Override
	public void eliminar(int id) throws ModelNotFoundException {
		this.repo.delete(this.buscarId(id));
	}

	@Override
	public List<SolicitudSalidas> retornarEstado(int id) throws ModelNotFoundException {
		List<SolicitudSalidas> lista = new ArrayList();
		for(SolicitudSalidas s: this.repo.findAll()) {
			if((s.getEstado().equals("Aprobado"))&&(s.getDocente().getId()==id)) {
				lista.add(s);
			}
		}
		return lista;
	}
	
	public List<SolicitudSalidas> listarDocente(int id){
    	List<SolicitudSalidas> lista = new ArrayList<SolicitudSalidas>();
    	for(SolicitudSalidas p: repo.findAll()) {
			if(p.getDocente().getId()==id) {
				lista.add(p);
			}
				
		}
         return lista;
    }
	
	@Override
	public List<SolicitudSalidas> listarAdministrativo(int id) throws ModelNotFoundException {
		List<SolicitudSalidas> lista = new ArrayList<SolicitudSalidas>();
		for(SolicitudSalidas p: repo.findAll()) {
			if((p.getDocente().getAdministrativo().getAdmi_id()==id)&&p.getEstado().equals("No aprobado")) {
				lista.add(p);
			}
		}
		return lista;
	}
}
