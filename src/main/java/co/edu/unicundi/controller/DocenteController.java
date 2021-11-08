package co.edu.unicundi.controller;



import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.validation.Valid;

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

import co.edu.unicundi.entity.Asesoria;
import co.edu.unicundi.entity.Docente;
import co.edu.unicundi.entity.Miembros;
import co.edu.unicundi.exception.InvalidFormatExcepcion;
import co.edu.unicundi.exception.ModelNotFoundException;
import co.edu.unicundi.service.CloudinaryService;
import co.edu.unicundi.service.IDocenteService;
import co.edu.unicundi.service.IMiembrosService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;


@RestController
@RequestMapping("/docente")
@CrossOrigin
public class DocenteController {
	
	@Autowired
	private IDocenteService service;
	
	@Autowired
	CloudinaryService cloudinaryService;
	
	@Autowired
	private IMiembrosService serviceM;
	
	@PreAuthorize("hasAuthority('Docente')")
	@PutMapping("/upload/{id}")
    public ResponseEntity<?> upload(@RequestParam MultipartFile multipartFile, @PathVariable int id)throws ModelNotFoundException, Exception {
		Docente docente = service.buscarId(id);
		if(docente.getFotoUrl()!=null) {
			Map result = cloudinaryService.delete(docente.getFotoId());
		}
		BufferedImage bi = ImageIO.read(multipartFile.getInputStream());
        Map result = cloudinaryService.upload(multipartFile);
        service.subirFoto(id, (String)result.get("original_filename"), (String)result.get("url"),(String)result.get("public_id"));
		return new ResponseEntity<Object>((String)result.get("url"), HttpStatus.CREATED);
    }
	
	@PreAuthorize("hasAuthority('Administrador')")
	@PostMapping("/guardar")
	@ApiOperation(value="Metodo que crea a un docente con su información")
	public ResponseEntity<?> guardar (@Validated @RequestBody Docente docente) throws Exception {
		service.guardar(docente);
		return new ResponseEntity<Docente>(docente, HttpStatus.CREATED);
		
			
	}
	
	@PreAuthorize("hasAuthority('Administrador')")
	@PutMapping("/editar")
    @ApiOperation(
            value = "Editar al docente correspondiente al id",
            notes = "Editar al docente correspondiente al id"
            )
            @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = Docente.class ),
            @ApiResponse(code = 503, message = "Servicio no Disponible", response = String.class),
            @ApiResponse(code = 500, message = "Error inesperado del sistema") })
	public ResponseEntity<Docente> editar(@Validated @RequestBody Docente docente) throws Exception, ModelNotFoundException{
		service.editar(docente);
		return new ResponseEntity<Docente>(docente, HttpStatus.CREATED);

	}
	
	@PreAuthorize("hasAuthority('Administrador')")
	@DeleteMapping("eliminar/{id}")
    @ApiOperation(
            value = "Elimina el docente correspondiente al id",
            notes = "Elimina el docente correspondiente al id"
            )
            @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = Docente.class ),
            @ApiResponse(code = 404, message = "NOT_FOUND", response = Docente.class ),
            @ApiResponse(code = 503, message = "Servicio no Disponible", response = String.class),
            @ApiResponse(code = 500, message = "Error inesperado del sistema") })
	
	public ResponseEntity<Object>eliminar(@PathVariable int id) throws ModelNotFoundException{
		service.eliminar(id);
		return new ResponseEntity<Object>("", HttpStatus.NO_CONTENT);
		

	}
	
	@PreAuthorize("hasAuthority('Docente') OR hasAuthority('Administrativo') OR hasAuthority('Administrador')")
	@GetMapping("/retornarTodos")
	@ApiOperation(value="Metodo que retorna todos los docentes creados")
	public ResponseEntity<List<Docente>> retornarTodos() throws ModelNotFoundException{
		
		return new ResponseEntity<List<Docente>>(service.mostrarDocentes(), HttpStatus.OK);

	}
	
	@PreAuthorize("hasAuthority('Administrador') OR hasAuthority('Administrativo') OR hasAuthority('Docente')")
	@GetMapping("/retornarId/{id}") 
	@ApiOperation(value="Metodo que retorna a un docente por su id")
	public ResponseEntity<?> retornarId(@PathVariable int id) throws ModelNotFoundException, Exception  {
		Docente docente = service.buscarId(id);
		return new ResponseEntity<Docente>(docente, HttpStatus.OK);	
				

	}
	
	@PreAuthorize("hasAuthority('Docente')")
	@GetMapping("/buscarCorreo/{correo}") 
	@ApiOperation(value="Metodo que retorna el documento por su correo")
	public ResponseEntity<?> buscarCorreo(@PathVariable String correo) throws ModelNotFoundException, Exception  {
		Docente docente = service.buscarCorreo(correo);
		return new ResponseEntity<Docente>(docente, HttpStatus.OK);	
				

	}

	@PreAuthorize("hasAuthority('Administrador') OR hasAuthority('Administrativo')")
	@GetMapping("/retornarAdministrativo/{id}")
	@ApiOperation(value="Metodo que retorna todos los docentes por Administrativo")
	public ResponseEntity<List<Docente>> retornarAdministrativo(@PathVariable int id) throws ModelNotFoundException{
		
		return new ResponseEntity<List<Docente>>(service.listarAdministrativo(id), HttpStatus.OK);

	}
	
	@PreAuthorize("hasAuthority('Docente')")
	@PutMapping("/cambiarPassword/{id}/{password}")
    public ResponseEntity<?> cambiarPassword(@PathVariable int id, @PathVariable String password)throws ModelNotFoundException, Exception {
        service.cambiarPassword(id, password);
		return new ResponseEntity<Object>("", HttpStatus.CREATED);
    }
	
	@PreAuthorize("hasAuthority('Administrativo')")
	@GetMapping("/listarNoMiembros/{id}")
	public ResponseEntity<List<Docente>> retornarNoMiembros(@PathVariable Integer id) throws ModelNotFoundException{
		
		return new ResponseEntity<List<Docente>>(service.listarNoMiembros(id), HttpStatus.OK);

	}
	@PreAuthorize("hasAuthority('Docente')")
	@GetMapping("/buscarPassword/{id}/{password}")
    public ResponseEntity<?> buscar(@PathVariable int id, @PathVariable String password)throws ModelNotFoundException, Exception {
        service.buscarPassword(id, password);
		return new ResponseEntity<Object>("", HttpStatus.OK);
    }

}
