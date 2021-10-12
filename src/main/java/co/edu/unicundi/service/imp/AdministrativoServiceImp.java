package co.edu.unicundi.service.imp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import co.edu.unicundi.entity.Administrativo;
import co.edu.unicundi.entity.Docente;
import co.edu.unicundi.entity.ProgramaAcademico;
import co.edu.unicundi.entity.Rol;
import co.edu.unicundi.exception.ModelNotFoundException;
import co.edu.unicundi.exception.ObjectItsCreatedExceptionHandler;
import co.edu.unicundi.repo.IAdministrativoRepo;
import co.edu.unicundi.repo.IProgramaAcademicoRepo;
import co.edu.unicundi.repo.IRolRepo;
import co.edu.unicundi.service.IAdministrativoService;

@Service
public class AdministrativoServiceImp implements IAdministrativoService {

	@Autowired
	private IAdministrativoRepo repo;

	@Autowired
	private IProgramaAcademicoRepo repoPrac;
	
	@Autowired
	private IRolRepo repoRol;

	List<Administrativo> admid = new ArrayList<Administrativo>();

	public Administrativo buscarId(int id) throws ModelNotFoundException {

		Administrativo admi = repo.findById(id)
				.orElseThrow(() -> new ModelNotFoundException("Administrativo no exontrado"));
		return admi;

	}

	public List<Administrativo> mostrarAdministrativos() throws ModelNotFoundException {
		return this.repo.findAll();
	}

	public void guardar(Administrativo admi) throws Exception {
		
		List<Administrativo> ad = mostrarAdministrativos();
		if (admi.getDocumento() == null) {

			for (Administrativo p : ad) {
				if (p.getSede() == admi.getSede() && p.getProgramaacademico() == admi.getProgramaacademico()) {
					throw new Exception("el programa academico ya tiene administrativo");
				}

			}
			
			
		} else {
			Rol rol = repoRol.findById(2).orElseThrow(
	                () -> new ModelNotFoundException("rol no  exontrado"));
			admi.setRol(rol);
			this.repo.save(admi);
		}
	}

	public void editar(Administrativo admi) throws Exception, ModelNotFoundException {

		ProgramaAcademico prog = repoPrac.findById(admi.getProgramaacademico().getPrac_id())
				.orElseThrow(() -> new ModelNotFoundException("programa academico no exontrado"));
		Administrativo pro = this.buscarId(admi.getId());
		pro.setDocumento(admi.getDocumento());
		pro.setNombre(admi.getNombre());
		pro.setCodigo(admi.getCodigo());
		pro.setPassword(admi.getPassword());
		pro.setFechanacimiento(admi.getFechanacimiento());
		pro.setSexo(admi.getSexo());
		pro.setDireccion(admi.getDireccion());
		pro.setCelular(admi.getCelular());
		pro.setFechaIngreso(admi.getFechaIngreso());
		pro.setCorreo(admi.getCorreo());
		pro.setSede(admi.getSede());
		pro.setProgrmaacademico(prog);
		this.repo.save(pro);
	}

	public void eliminar(int id) throws ModelNotFoundException {
		this.repo.delete(this.buscarId(id));
	}
	
	@Override
	public Administrativo buscarCorreo(String correo) throws ModelNotFoundException {
		
		Administrativo admin = repo.findByCorreo(correo).orElseThrow(
                () -> new ModelNotFoundException("Administrativo no exontrado"));
        return admin;

	}
}
