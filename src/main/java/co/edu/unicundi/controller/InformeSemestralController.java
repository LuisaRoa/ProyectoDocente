package co.edu.unicundi.controller;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import co.edu.unicundi.dto.Mensaje;
import co.edu.unicundi.entity.Asesoria;
import co.edu.unicundi.entity.InformeSemestral;
import co.edu.unicundi.entity.Syllabus;
import co.edu.unicundi.exception.ModelNotFoundException;
import co.edu.unicundi.service.AsesoriaService;
import co.edu.unicundi.service.CloudinaryService;
import co.edu.unicundi.service.InformeSemestralService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/informeSemestral")
//@PreAuthorize("hasAuthority('docente')")
@CrossOrigin
public class InformeSemestralController {
	@Autowired
	CloudinaryService cloudinaryService;

	@Autowired
	InformeSemestralService adjuntar;

	@PreAuthorize("hasAuthority('Docente') OR hasAuthority('Administrativo')")
	@GetMapping("/list")
	public ResponseEntity<List<InformeSemestral>> list() {
		List<InformeSemestral> list = adjuntar.list();
		return new ResponseEntity(list, HttpStatus.OK);
	}

	@PreAuthorize("hasAuthority('Docente')")
	@PostMapping("/upload")
    public ResponseEntity<?> upload(@RequestParam MultipartFile multipartFile)throws IOException {
        BufferedImage bi = ImageIO.read(multipartFile.getInputStream());
        /*if(bi == null){
            return new ResponseEntity(new Mensaje("imagen no válida"), HttpStatus.BAD_REQUEST);
        }*/
        Map result = cloudinaryService.upload(multipartFile);
        InformeSemestral informeSemestral =
                new InformeSemestral(0 , 0, 0, 0, (String)result.get("original_filename"),
                        (String)result.get("url"),
                        (String)result.get("public_id"), null, null, null, null, null, null, null, null, null, null, null);
                       /* (String)result.get("size")*/
        adjuntar.save(informeSemestral);
        return new ResponseEntity<InformeSemestral>(informeSemestral, HttpStatus.OK);
    }

	@PreAuthorize("hasAuthority('Docente')")
	@PutMapping("/editar")
    @ApiOperation(
            value = "Editar al formato correspondiente al id",
            notes = "Editar al formato correspondiente al id"
            )
            @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = InformeSemestral.class ),
            @ApiResponse(code = 503, message = "Servicio no Disponible", response = String.class),
            @ApiResponse(code = 500, message = "Error inesperado del sistema") })
	public ResponseEntity<InformeSemestral> editar(@Validated @RequestBody InformeSemestral informeSemestral) throws Exception, ModelNotFoundException{
		adjuntar.update(informeSemestral);
		return new ResponseEntity<InformeSemestral>(informeSemestral, HttpStatus.CREATED);

	}

	@PreAuthorize("hasAuthority('Docente')")
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") int id) throws IOException {
		if (!adjuntar.exists(id))
			return new ResponseEntity<Object>(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
		InformeSemestral informeSemestral = adjuntar.getOne(id).get();
		Map result = cloudinaryService.delete(informeSemestral.getInformeId());
		adjuntar.delete(id);
		return new ResponseEntity(new Mensaje("informe Semestral eliminado"), HttpStatus.OK);
	}

	@PreAuthorize("hasAuthority('Docente') OR hasAuthority('Administrativo')")
	@GetMapping("/retornarId/{id}")
	@ApiOperation(value = "Metodo que retorna a un formato por su id")
	public ResponseEntity<?> retornarId(@PathVariable int id) throws ModelNotFoundException, Exception {
		InformeSemestral informeSemestral = adjuntar.getOne(id).get();
		return new ResponseEntity<InformeSemestral>(informeSemestral, HttpStatus.OK);

	}
	
	@PreAuthorize("hasAuthority('Docente') OR hasAuthority('Administrativo')")
	@GetMapping("/listarDocente/{id}")
	public ResponseEntity<List<InformeSemestral>> listarDocente(@PathVariable int id) {
		List<InformeSemestral> list = adjuntar.listarDocente(id);
		return new ResponseEntity(list, HttpStatus.OK);
	}
	
	@GetMapping("/reporteperiodo/{año}/{periodo}")
	public ResponseEntity<List<InformeSemestral>> InformeSemestralP(@PathVariable String año, @PathVariable String periodo) throws ModelNotFoundException {
		List<InformeSemestral> list = adjuntar.mostrarInformeP(año, periodo);
		return new ResponseEntity(list, HttpStatus.OK);
	}
	
	@GetMapping("/reporteanual/{año}")
	public ResponseEntity<List<InformeSemestral>> InformeSemestralA(@PathVariable String año) throws ModelNotFoundException {
		List<InformeSemestral> list = adjuntar.mostrarInforme(año);
		return new ResponseEntity(list, HttpStatus.OK);
	}
}
