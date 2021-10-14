package co.edu.unicundi.service.imp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.edu.unicundi.entity.Comite;
import co.edu.unicundi.entity.Docente;
import co.edu.unicundi.entity.InformeSalidas;
import co.edu.unicundi.entity.Miembros;
import co.edu.unicundi.exception.ModelNotFoundException;
import co.edu.unicundi.repo.IComiteRepo;
import co.edu.unicundi.repo.IDocenteRepo;
import co.edu.unicundi.repo.IMiembrosRepo;
import co.edu.unicundi.service.IMiembrosService;

@Service
public class MiembrosServiceImp implements IMiembrosService {

	@Autowired
	private IMiembrosRepo repo;

	@Autowired
	private IDocenteRepo repoDoce;

	@Autowired
	private IComiteRepo repoC;

	List<Miembros> mien = new ArrayList<Miembros>();

	@Override
	public void guardarNativo(Miembros miembros) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Miembros> listarPorIdDocente(int id) {
		List<Miembros> lista = new ArrayList<Miembros>();
		for(Miembros p: repo.findAll()) {
			if(p.getDocente().getId()==id) {
				lista.add(p);
			}
		}
		
		return lista;
	}


}
