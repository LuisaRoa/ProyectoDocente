package co.edu.unicundi.service.imp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.unicundi.entity.Administrativo;

import co.edu.unicundi.exception.ModelNotFoundException;
import co.edu.unicundi.repo.IAdministrativoRepo;
import co.edu.unicundi.service.IAdministrativoService;

@Service
public class AdministrativoServiceImp implements IAdministrativoService {
	
	@Autowired
	private IAdministrativoRepo repo;
	
	List<Administrativo> admi = new ArrayList<Administrativo>();
	
	public Administrativo buscarId(int id) throws ModelNotFoundException {
		
		Administrativo admi = repo.findById(id).orElseThrow(
                () -> new ModelNotFoundException("Administrativo no exontrado"));
        return admi;

	}


	public List<Administrativo> mostrarAdministrativos() throws ModelNotFoundException {
		return this.repo.findAll();
	}

	public void guardar(Administrativo admi) throws Exception {
		this.repo.save(admi);
	}

	public void editar(Administrativo admi) throws Exception, ModelNotFoundException {
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
        
        this.repo.save(pro);
	}

	public void eliminar(int id) throws ModelNotFoundException {
		this.repo.delete(this.buscarId(id));
	}
}
