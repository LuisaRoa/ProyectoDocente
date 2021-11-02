package co.edu.unicundi.service.imp;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.unicundi.entity.AcuerdoPedagogico;
import co.edu.unicundi.entity.AulasVirtuales;
import co.edu.unicundi.entity.Docente;
import co.edu.unicundi.entity.Materia;
import co.edu.unicundi.exception.ModelNotFoundException;
import co.edu.unicundi.repo.IAulasVirtualesRepo;
import co.edu.unicundi.repo.IDocenteRepo;
import co.edu.unicundi.repo.IMateriaRepo;
import co.edu.unicundi.service.IAulaVirtualService;

@Service
public class AulasVirtualesServiceImp implements IAulaVirtualService{
	
	@Autowired
	private IAulasVirtualesRepo repo;

	@Autowired
	private IDocenteRepo repoDoce;
	
	@Autowired
	private IMateriaRepo repoMate;
	
	public AulasVirtuales buscarId(int id) throws ModelNotFoundException {
		AulasVirtuales aulas = repo.findById(id).orElseThrow(
                () -> new ModelNotFoundException("materia no exontrada"));
        return aulas;
	}

	public List<AulasVirtuales> mostrarAulasVirtuales() throws ModelNotFoundException {
		return this.repo.findAll();
	}

	
	public void guardar(AulasVirtuales aulas) throws Exception {
		
		LocalDate fecha = LocalDate.parse(aulas.getFechacambio());
    	if((fecha.getMonthValue()>=1)&&(fecha.getMonthValue()<=6)) {
    		aulas.setPeriodo("1");
    	}else {
    		aulas.setPeriodo("2");
    	}
		this.repo.save(aulas);
	}

	
	public void editar(AulasVirtuales aulas) throws Exception, ModelNotFoundException {
		AulasVirtuales au = this.buscarId(aulas.getAuvi_id());
		Docente doce = repoDoce.findById(aulas.getDocente().getId()).orElseThrow(
                () -> new ModelNotFoundException("administrativo no  exontrado"));
		Materia mate = repoMate.findById(aulas.getMateria().getMate_id()).orElseThrow(
                () -> new ModelNotFoundException("administrativo no  exontrado"));
		au.setNombre(aulas.getNombre());
		au.setGrupo(aulas.getGrupo());
        au.setSemestre(aulas.getSemestre());
        au.setSede(aulas.getSede());
        au.setDocente(doce);
        au.setMateria(mate);
	}

	public void eliminar(int id) throws ModelNotFoundException {
		this.repo.delete(this.buscarId(id));
		
	}
	
	public List<AulasVirtuales> listarDocente(int id){
    	List<AulasVirtuales> aulasVirtuales = new ArrayList<AulasVirtuales>();
    	for(AulasVirtuales p: repo.findAll()) {
			if(p.getDocente().getId()==id) {
				aulasVirtuales.add(p);
			}
				
		}
         return aulasVirtuales;
    }

	 
	
	@Override
	public List<AulasVirtuales> mostrarAulasVirtuales(String año, String periodo) {
		return this.repo.aulasperiodo(año, periodo);
	}

	@Override
	public List<AulasVirtuales> mostrarAulasVirtualesA(String año) {
		return this.repo.numerodeAulas(año);
	}

}
