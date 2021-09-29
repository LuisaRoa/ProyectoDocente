package co.edu.unicundi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.edu.unicundi.entity.Asesoria;
import co.edu.unicundi.repo.IAsesoria;


@Service
@Transactional
public class AsesoriaService {
	
	@Autowired
    IAsesoria repo;

    public List<Asesoria> list(){
        return repo.findByOrderById();
    }

    public Optional<Asesoria> getOne(int id){
        return repo.findById(id);
    }

    public void update (Asesoria asesoria) {
    	Asesoria e = getOne(asesoria.getId()).get();
    	e.setNombre(asesoria.getNombre());
    	e.setTipoArchivo(asesoria.getTipoArchivo());
    	e.setTamaño(asesoria.getTamaño());
    	e.setFecha(asesoria.getFecha());
    	e.setSemestre(asesoria.getSemestre());
    	e.setNucleo(asesoria.getNucleo());
        repo.save(e);
    }
    public void save(Asesoria evi){
    	repo.save(evi);
    }

    public void delete(int id){
        repo.deleteById(id);
    }

    public boolean exists(int id){
        return repo.existsById(id);
    }
}
