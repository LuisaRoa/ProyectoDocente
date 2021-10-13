package co.edu.unicundi.controller;



import java.awt.image.BufferedImage;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.validation.annotation.Validated;
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

import co.edu.unicundi.entity.Administrativo;
import co.edu.unicundi.entity.Docente;
import co.edu.unicundi.exception.ModelNotFoundException;
import co.edu.unicundi.service.CloudinaryService;
import co.edu.unicundi.service.IAdministrativoService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;


@RestController
@RequestMapping("/administrativo")
public class AdministrativoController {
	
	@Autowired
	CloudinaryService cloudinaryService;
	
	@Autowired	
	private IAdministrativoService service;
	
	@PutMapping("/upload/{id}")
    public ResponseEntity<?> upload(@RequestParam MultipartFile multipartFile, @PathVariable int id)throws ModelNotFoundException, Exception {
		Administrativo administrativo = service.buscarId(id);
		if(administrativo.getFotoUrl()!=null) {
			Map result = cloudinaryService.delete(administrativo.getFotoId());
		}
		BufferedImage bi = ImageIO.read(multipartFile.getInputStream());
        Map result = cloudinaryService.upload(multipartFile);
        service.subirFoto(id, (String)result.get("original_filename"), (String)result.get("url"),(String)result.get("public_id"));
		return new ResponseEntity<Object>((String)result.get("url"), HttpStatus.CREATED);
    }

	@PostMapping("/guardar")
	@ApiOperation(value="Metodo que crea a un administrativo con su información")
	public ResponseEntity<?> guardar (@Validated @RequestBody Administrativo admi) throws Exception {
		service.guardar(admi);
		return new ResponseEntity<Administrativo>(admi, HttpStatus.CREATED);
		
			
	}
	@PutMapping("/editar")
    @ApiOperation(
            value = "Editar al Administrativo correspondiente al id",
            notes = "Editar al Administrativo correspondiente al id"
            )
            @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = Administrativo.class ),
            @ApiResponse(code = 503, message = "Servicio no Disponible", response = String.class),
            @ApiResponse(code = 500, message = "Error inesperado del sistema") })
	public ResponseEntity<Administrativo> editar(@Validated @RequestBody Administrativo admi) throws Exception, ModelNotFoundException{
		service.editar(admi);
		return new ResponseEntity<Administrativo>(admi, HttpStatus.CREATED);

	}
	
	@DeleteMapping("eliminar/{id}")
    @ApiOperation(
            value = "Elimina el Administrativo correspondiente al id",
            notes = "Elimina el Administrativo correspondiente al id"
            )
            @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = Administrativo.class ),
            @ApiResponse(code = 404, message = "NOT_FOUND", response = Administrativo.class ),
            @ApiResponse(code = 503, message = "Servicio no Disponible", response = String.class),
            @ApiResponse(code = 500, message = "Error inesperado del sistema") })
	public ResponseEntity<Object>eliminar(@PathVariable int id) throws ModelNotFoundException{
		service.eliminar(id);
		return new ResponseEntity<Object>("", HttpStatus.NO_CONTENT);
		

	}
	
	@GetMapping("/retornarTodos")
	@ApiOperation(value="Metodo que retorna todos los Administrativo creados")
	public ResponseEntity<List<Administrativo>> retornarTodos() throws ModelNotFoundException{
		
		return new ResponseEntity<List<Administrativo>>(service.mostrarAdministrativos(), HttpStatus.OK);

	}
	@GetMapping("/retornarId/{id}") 
	@ApiOperation(value="Metodo que retorna a un Administrativo por su id")
	public ResponseEntity<?> retornarId(@PathVariable int id) throws ModelNotFoundException, Exception  {
		Administrativo admi = service.buscarId(id);
		return new ResponseEntity<Administrativo>(admi, HttpStatus.OK);	
				

	}

	@GetMapping("/buscarCorreo/{correo}") 
	@ApiOperation(value="Metodo que retorna el documento por su correo")
	public ResponseEntity<?> buscarCorreo(@PathVariable String correo) throws ModelNotFoundException, Exception  {
		Administrativo admin = service.buscarCorreo(correo);
		return new ResponseEntity<Administrativo>(admin, HttpStatus.OK);	
				

	}
	
	@PutMapping("/cambiarPassword/{id}/{password}")
    public ResponseEntity<?> cambiarPassword(@PathVariable int id, @PathVariable String password)throws ModelNotFoundException, Exception {
        service.cambiarPassword(id, password);
		return new ResponseEntity<Object>("", HttpStatus.CREATED);
    }

}
