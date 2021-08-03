package co.edu.unicundi.service.imp;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import co.edu.unicundi.entity.Docente;
import co.edu.unicundi.exception.ModelNotFoundException;
import co.edu.unicundi.repo.IDocenteRepo;
import co.edu.unicundi.service.IDocenteService;

@Service
public class DocenteServiceImp implements IDocenteService {

	@Autowired
	private IDocenteRepo repo;
	
	List<Docente> docentes = new ArrayList<Docente>();
	@Override
	public Docente buscarId(int id) throws ModelNotFoundException {
		
		Docente docente = repo.findById(id).orElseThrow(
                () -> new ModelNotFoundException("Docente no exontrado"));
        return docente;

	}


	@Override
	public List<Docente> mostrarDocentes() throws ModelNotFoundException {
		return this.repo.findAll();
	}

	@Override
	public void guardar(Docente docente) throws Exception {
		for(Docente p: docentes) {
			if(p.getId()==docente.getId()) {
				throw new Exception("Ya existe el ID");
			}
				
		}
		//docentes.add(docente);
		this.repo.save(docente);
	}

	@Override
	public void editar(Docente docente) throws Exception, ModelNotFoundException {
		Docente pro = this.buscarId(docente.getId());
		pro.setDocumento(docente.getDocumento());
        pro.setNombre(docente.getNombre());
        pro.setLugarexpedicion(docente.getLugarexpedicion());
        pro.setLugarnacimiento(docente.getLugarnacimiento());
        pro.setFechanacimiento(docente.getFechanacimiento());
        pro.setSexo(docente.getSexo());
        pro.setDireccion(docente.getDireccion());
        pro.setCelular(docente.getCelular());
        pro.setFechaingreso(docente.getFechaingreso());
        pro.setCorreo(docente.getCorreo());
        pro.setSede(docente.getSede());
        
        this.repo.save(pro);
	}

	@Override
	public void eliminar(int id) throws ModelNotFoundException {
		this.repo.delete(this.buscarId(id));
	}
	
	
	@Override
	public String buscarCorreo(String correo) throws ModelNotFoundException {
		
		Docente docente = repo.findByCorreo(correo).orElseThrow(
                () -> new ModelNotFoundException("Docente no exontrado"));
        return docente.getDocumento();

	}


}
