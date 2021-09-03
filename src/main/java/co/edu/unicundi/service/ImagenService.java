package co.edu.unicundi.service;

import co.edu.unicundi.entity.Imagen;
import co.edu.unicundi.repo.ImagenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ImagenService {

    @Autowired
    ImagenRepository imagenRepository;

    public List<Imagen> list(){
        return imagenRepository.findByOrderById();
    }

    public Optional<Imagen> getOne(int id){
        return imagenRepository.findById(id);
    }

    public void update (Imagen imagen) {
    	Imagen img = getOne(imagen.getId()).get();
    	img.setNombre(imagen.getNombre());
    	img.setCodigo(imagen.getCodigo());
    	img.setProceso(imagen.getProceso());
    	img.setVersion(imagen.getVersion());
    	img.setFechaAprobacion(imagen.getFechaAprobacion());
        imagenRepository.save(img);
    }
    public void save(Imagen imagen){
    	imagenRepository.save(imagen);
    }

    public void delete(int id){
        imagenRepository.deleteById(id);
    }

    public boolean exists(int id){
        return imagenRepository.existsById(id);
    }
}
