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
import co.edu.unicundi.entity.Cronograma;
import co.edu.unicundi.exception.ModelNotFoundException;
import co.edu.unicundi.service.CloudinaryService;
import co.edu.unicundi.service.CronogramaService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/cronograma")
@CrossOrigin
public class CronogramaController {
	@Autowired
	CloudinaryService cloudinaryService;

	@Autowired
	CronogramaService cronograma;

	@PreAuthorize("hasAuthority('Docente') OR hasAuthority('Administrativo')")
	@GetMapping("/list")
	public ResponseEntity<List<Cronograma>> list() {
		List<Cronograma> list = cronograma.list();
		return new ResponseEntity(list, HttpStatus.OK);
	}

	@PreAuthorize("hasAuthority('Administrativo')")
	@PostMapping("/upload")
    public ResponseEntity<?> upload(@RequestParam MultipartFile multipartFile)throws IOException {
        BufferedImage bi = ImageIO.read(multipartFile.getInputStream());
        Map result = cloudinaryService.upload(multipartFile);
        Cronograma evidencia =
                new Cronograma(0,(String)result.get("original_filename"),
                        (String)result.get("url"),
                        (String)result.get("public_id"), null, null, null, null, null);
                       /* (String)result.get("size")*/
        cronograma.save(evidencia);
        return new ResponseEntity<Cronograma>(evidencia, HttpStatus.OK);
    }

	@PreAuthorize("hasAuthority('Administrativo')")
	@PutMapping("/editar")
    @ApiOperation(
            value = "Editar al cronograma correspondiente al id",
            notes = "Editar al cronograma correspondiente al id"
            )
            @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = Cronograma.class ),
            @ApiResponse(code = 503, message = "Servicio no Disponible", response = String.class),
            @ApiResponse(code = 500, message = "Error inesperado del sistema") })
	public ResponseEntity<Cronograma> editar(@Validated @RequestBody Cronograma evidencia) throws Exception, ModelNotFoundException{
		cronograma.update(evidencia);
		return new ResponseEntity<Cronograma>(evidencia, HttpStatus.CREATED);

	}

	@PreAuthorize("hasAuthority('Administrativo')")
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") int id) throws IOException {
		if (!cronograma.exists(id))
			return new ResponseEntity<Object>(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
		Cronograma evidencia = cronograma.getOne(id).get();
		Map result = cloudinaryService.delete(evidencia.getCronogramaId());
		cronograma.delete(id);
		return new ResponseEntity(new Mensaje("Cronograma eliminado"), HttpStatus.OK);
	}

	@PreAuthorize("hasAuthority('Docente') OR hasAuthority('Administrativo')")
	@GetMapping("/retornarId/{id}")
	@ApiOperation(value = "Metodo que retorna a un Acta por su id")
	public ResponseEntity<?> retornarId(@PathVariable int id) throws ModelNotFoundException, Exception {
		Cronograma evidencia = cronograma.getOne(id).get();
		return new ResponseEntity<Cronograma>(evidencia, HttpStatus.OK);

	}
	
	@PreAuthorize("hasAuthority('Docente') OR hasAuthority('Administrativo')")
	@GetMapping("/listarComite/{id}")
	public ResponseEntity<List<Cronograma>> listarComite(@PathVariable int id) {
		List<Cronograma> list = cronograma.listarComite(id);
		return new ResponseEntity(list, HttpStatus.OK);
	}
}
