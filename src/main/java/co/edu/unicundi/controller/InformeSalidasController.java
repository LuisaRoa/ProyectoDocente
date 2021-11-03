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
import co.edu.unicundi.entity.InformeHorasNoLectivas;
import co.edu.unicundi.entity.InformeSalidas;
import co.edu.unicundi.exception.ModelNotFoundException;
import co.edu.unicundi.service.CloudinaryService;
import co.edu.unicundi.service.InformeSalidasService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/informeSalidas")
@CrossOrigin
public class InformeSalidasController {
	@Autowired
	CloudinaryService cloudinaryService;

	@Autowired
	InformeSalidasService adjuntar;

	@PreAuthorize("hasAuthority('Docente') OR hasAuthority('Administrativo')")
	@GetMapping("/list")
	public ResponseEntity<List<InformeSalidas>> list() {
		List<InformeSalidas> list = adjuntar.list();
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
        InformeSalidas informeSalidas =
                new InformeSalidas(0 , (String)result.get("original_filename"),
                        (String)result.get("url"),
                        (String)result.get("public_id"), null, null, null, null, null, null, null);
                       /* (String)result.get("size")*/
        adjuntar.save(informeSalidas);
        return new ResponseEntity<InformeSalidas>(informeSalidas, HttpStatus.OK);
    }

	@PreAuthorize("hasAuthority('Docente')")
	@PutMapping("/editar")
    @ApiOperation(
            value = "Editar al formato correspondiente al id",
            notes = "Editar al formato correspondiente al id"
            )
            @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = InformeSalidas.class ),
            @ApiResponse(code = 503, message = "Servicio no Disponible", response = String.class),
            @ApiResponse(code = 500, message = "Error inesperado del sistema") })
	public ResponseEntity<InformeSalidas> editar(@Validated @RequestBody InformeSalidas informeSalidas) throws Exception, ModelNotFoundException{
		adjuntar.update(informeSalidas);
		return new ResponseEntity<InformeSalidas>(informeSalidas, HttpStatus.CREATED);

	}

	@PreAuthorize("hasAuthority('Docente')")
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") int id) throws IOException {
		if (!adjuntar.exists(id))
			return new ResponseEntity<Object>(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
		InformeSalidas informeSalidas = adjuntar.getOne(id).get();
		Map result = cloudinaryService.delete(informeSalidas.getInformeId());
		adjuntar.delete(id);
		return new ResponseEntity(new Mensaje("informe Salida eliminado"), HttpStatus.OK);
	}

	@PreAuthorize("hasAuthority('Docente') OR hasAuthority('Administrativo')")
	@GetMapping("/retornarId/{id}")
	@ApiOperation(value = "Metodo que retorna a un formato por su id")
	public ResponseEntity<?> retornarId(@PathVariable int id) throws ModelNotFoundException, Exception {
		InformeSalidas informeSalidas = adjuntar.getOne(id).get();
		return new ResponseEntity<InformeSalidas>(informeSalidas, HttpStatus.OK);

	}
	
	@PreAuthorize("hasAuthority('Docente') OR hasAuthority('Administrativo')")
	@GetMapping("/listarDocente/{id}")
	public ResponseEntity<List<InformeSalidas>> listarDocente(@PathVariable int id) {
		List<InformeSalidas> list = adjuntar.listarDocente(id);
		return new ResponseEntity(list, HttpStatus.OK);
	}
	
	@PreAuthorize("hasAuthority('Administrativo')")
	@GetMapping("/reporteanual/{año}")
	public ResponseEntity<List<InformeSalidas>> infoReporte(@PathVariable String año) throws ModelNotFoundException {
		List<InformeSalidas> list = adjuntar.mostrarInformeA(año);
		return new ResponseEntity(list, HttpStatus.OK);
	}
	
	@PreAuthorize("hasAuthority('Administrativo')")
	@GetMapping("/reporteperiodo/{año}/{periodo}")
	public ResponseEntity<List<InformeSalidas>> infosReporteP(@PathVariable String año, @PathVariable String periodo) throws ModelNotFoundException {
		List<InformeSalidas> list = adjuntar.mostrarInforme(año, periodo);
		return new ResponseEntity(list, HttpStatus.OK);
	}
}
