package co.edu.unicundi.controller;

import co.edu.unicundi.dto.Mensaje;
import co.edu.unicundi.entity.Imagen;
import co.edu.unicundi.exception.ModelNotFoundException;
import co.edu.unicundi.service.CloudinaryService;
import co.edu.unicundi.service.ImagenService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/cloudinary")
@CrossOrigin
public class MainController {

	@Autowired
	CloudinaryService cloudinaryService;

	@Autowired
	ImagenService imagenService;

	@PreAuthorize("hasAuthority('Docente') OR hasAuthority('Administrativo') OR hasAuthority('Administrador') ")
	@GetMapping("/list")
	public ResponseEntity<List<Imagen>> list() {
		List<Imagen> list = imagenService.list();
		return new ResponseEntity(list, HttpStatus.OK);
	}

	@PreAuthorize("hasAuthority('Administrador')")
	@PostMapping("/upload")
    public ResponseEntity<?> upload(@RequestParam MultipartFile multipartFile)throws IOException {
        BufferedImage bi = ImageIO.read(multipartFile.getInputStream());
        /*if(bi == null){
            return new ResponseEntity(new Mensaje("imagen no válida"), HttpStatus.BAD_REQUEST);
        }*/
        Map result = cloudinaryService.upload(multipartFile);
        Imagen imagen =
                new Imagen(0, (String)result.get("original_filename"),
                        (String)result.get("url"),
                        (String)result.get("public_id"), null, null, null, null, null);
                       /* (String)result.get("size")*/
        imagenService.save(imagen);
        return new ResponseEntity<Imagen>(imagen, HttpStatus.OK);
    }

	@PreAuthorize("hasAuthority('Administrador') ")
	@PutMapping("/editar")
    @ApiOperation(
            value = "Editar al formato correspondiente al id",
            notes = "Editar al formato correspondiente al id"
            )
            @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = Imagen.class ),
            @ApiResponse(code = 503, message = "Servicio no Disponible", response = String.class),
            @ApiResponse(code = 500, message = "Error inesperado del sistema") })
	public ResponseEntity<Imagen> editar(@Validated @RequestBody Imagen imagen) throws Exception, ModelNotFoundException{
		imagenService.update(imagen);
		return new ResponseEntity<Imagen>(imagen, HttpStatus.CREATED);

	}

	@PreAuthorize("hasAuthority('Administrador') ")
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") int id) throws IOException {
		if (!imagenService.exists(id))
			return new ResponseEntity<Object>(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
		Imagen imagen = imagenService.getOne(id).get();
		Map result = cloudinaryService.delete(imagen.getImagenId());
		imagenService.delete(id);
		return new ResponseEntity(new Mensaje("imagen eliminada"), HttpStatus.OK);
	}

	@PreAuthorize("hasAuthority('Docente') OR hasAuthority('Administrativo') OR hasAuthority('Administrador') ")
	@GetMapping("/retornarId/{id}")
	@ApiOperation(value = "Metodo que retorna a un formato por su id")
	public ResponseEntity<?> retornarId(@PathVariable int id) throws ModelNotFoundException, Exception {
		Imagen imagen = imagenService.getOne(id).get();
		return new ResponseEntity<Imagen>(imagen, HttpStatus.OK);

	}
}
