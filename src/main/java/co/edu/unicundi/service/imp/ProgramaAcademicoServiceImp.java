package co.edu.unicundi.service.imp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import co.edu.unicundi.entity.ProgramaAcademico;
import co.edu.unicundi.exception.ModelNotFoundException;
import co.edu.unicundi.repo.IProgramaAcademicoRepo;
import co.edu.unicundi.service.IProgramaAcademicoService;

@Service
public class ProgramaAcademicoServiceImp implements IProgramaAcademicoService {
	
	@Autowired
	private IProgramaAcademicoRepo repo;
	
	List<ProgramaAcademico> admi = new ArrayList<ProgramaAcademico>();
	
	public ProgramaAcademico buscarId(int id) throws ModelNotFoundException {
		
		ProgramaAcademico prac = repo.findById(id).orElseThrow(
                () -> new ModelNotFoundException("Programa Academico no exontrado"));
        return prac;

	}


	public List<ProgramaAcademico> mostrarProgramaAcademico() throws ModelNotFoundException {
		return this.repo.findAll();
	}

	public void guardar(ProgramaAcademico prac) throws Exception {
		this.repo.save(prac);
	}

	public void editar(ProgramaAcademico prac) throws Exception, ModelNotFoundException {
		ProgramaAcademico pro = this.buscarId(prac.getPrac_id());
        pro.setNombre(prac.getNombre());
        pro.setFechacambio(prac.getFechacambio());
        pro.setRegistradopor(prac.getRegistradopor());
        pro.setFacultad(prac.getFacultad());
        
        this.repo.save(pro);
	}

	public void eliminar(int id) throws ModelNotFoundException {
		this.repo.delete(this.buscarId(id));
	}
}
