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
import co.edu.unicundi.entity.Actas;
import co.edu.unicundi.entity.AdjuntarEvidencia;
import co.edu.unicundi.entity.Asesoria;
import co.edu.unicundi.exception.ModelNotFoundException;
import co.edu.unicundi.service.ActasService;
import co.edu.unicundi.service.AdjuntarEvidenciaService;
import co.edu.unicundi.service.CloudinaryService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/actas")
//@PreAuthorize("hasAuthority('docente')")
@CrossOrigin
public class ActasController {
	
	@Autowired
	CloudinaryService cloudinaryService;

	@Autowired
	ActasService actas;

	@GetMapping("/list")
	public ResponseEntity<List<Actas>> list() {
		List<Actas> list = actas.list();
		return new ResponseEntity(list, HttpStatus.OK);
	}

	@PostMapping("/upload")
    public ResponseEntity<?> upload(@RequestParam MultipartFile multipartFile)throws IOException {
        BufferedImage bi = ImageIO.read(multipartFile.getInputStream());
        /*if(bi == null){
            return new ResponseEntity(new Mensaje("imagen no válida"), HttpStatus.BAD_REQUEST);
        }*/
        Map result = cloudinaryService.upload(multipartFile);
        Actas evidencia =
                new Actas(0,(String)result.get("original_filename"),
                        (String)result.get("url"),
                        (String)result.get("public_id"), null, null, null, null, null, null, null);
                       /* (String)result.get("size")*/
        actas.save(evidencia);
        return new ResponseEntity<Actas>(evidencia, HttpStatus.OK);
    }

	@PutMapping("/editar")
    @ApiOperation(
            value = "Editar al Acta correspondiente al id",
            notes = "Editar al Acta correspondiente al id"
            )
            @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = Actas.class ),
            @ApiResponse(code = 503, message = "Servicio no Disponible", response = String.class),
            @ApiResponse(code = 500, message = "Error inesperado del sistema") })
	public ResponseEntity<Actas> editar(@Validated @RequestBody Actas evidencia) throws Exception, ModelNotFoundException{
		actas.update(evidencia);
		return new ResponseEntity<Actas>(evidencia, HttpStatus.CREATED);

	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") int id) throws IOException {
		if (!actas.exists(id))
			return new ResponseEntity<Object>(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
		Actas evidencia = actas.getOne(id).get();
		Map result = cloudinaryService.delete(evidencia.getActaId());
		actas.delete(id);
		return new ResponseEntity(new Mensaje("Acta eliminada"), HttpStatus.OK);
	}

	@GetMapping("/retornarId/{id}")
	@ApiOperation(value = "Metodo que retorna a un Acta por su id")
	public ResponseEntity<?> retornarId(@PathVariable int id) throws ModelNotFoundException, Exception {
		Actas evidencia = actas.getOne(id).get();
		return new ResponseEntity<Actas>(evidencia, HttpStatus.OK);

	}
	
	@GetMapping("/listarComite/{id}")
	public ResponseEntity<List<Actas>> listarComite(@PathVariable int id) {
		List<Actas> list = actas.listarComite(id);
		return new ResponseEntity(list, HttpStatus.OK);
	}
	
	@GetMapping("/reporteanual/{año}")
	public ResponseEntity<List<Actas>> actasReporte(@PathVariable String año) throws ModelNotFoundException {
		List<Actas> list = actas.mostrarActas(año);
		return new ResponseEntity(list, HttpStatus.OK);
	}
	
	@GetMapping("/reporteperiodo/{año}/{periodo}")
	public ResponseEntity<List<Actas>> aactasReporteP(@PathVariable String año, @PathVariable String periodo) throws ModelNotFoundException {
		List<Actas> list = actas.mostrarActasP(año, periodo);
		return new ResponseEntity(list, HttpStatus.OK);
	}
}
