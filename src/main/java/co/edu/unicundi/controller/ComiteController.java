package co.edu.unicundi.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.unicundi.entity.Comite;
import co.edu.unicundi.exception.ModelNotFoundException;
import co.edu.unicundi.service.ComiteService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/comite")
@CrossOrigin
public class ComiteController {
	
	@Autowired
	private ComiteService service;
	
	@PostMapping("/guardar")
	@ApiOperation(value="Metodo que crea a un comite con su información")
	public ResponseEntity<?> guardar (@Validated @RequestBody Comite comite) throws Exception {
		service.guardar(comite);
		return new ResponseEntity<Comite>(comite, HttpStatus.CREATED);
		
			
	}
	@PutMapping("editar")
    @ApiOperation(
            value = "Editar al comite correspondiente al id",
            notes = "Editar al comite correspondiente al id"
            )
            @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = Comite.class ),
            @ApiResponse(code = 503, message = "Servicio no Disponible", response = String.class),
            @ApiResponse(code = 500, message = "Error inesperado del sistema") })
	public ResponseEntity<Comite> editar(@Validated @RequestBody Comite comite) throws Exception, ModelNotFoundException{
		service.editar(comite);
		return new ResponseEntity<Comite>(comite, HttpStatus.CREATED);

	}
	
	@DeleteMapping("eliminar/{id}")
    @ApiOperation(
            value = "Elimina el comite correspondiente al id",
            notes = "Elimina el comite correspondiente al id"
            )
            @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = Comite.class ),
            @ApiResponse(code = 404, message = "NOT_FOUND", response = Comite.class ),
            @ApiResponse(code = 503, message = "Servicio no Disponible", response = String.class),
            @ApiResponse(code = 500, message = "Error inesperado del sistema") })
	
	public ResponseEntity<Object> eliminar(@PathVariable int id) throws ModelNotFoundException{
		service.eliminar(id);
		return new ResponseEntity<Object>("", HttpStatus.NO_CONTENT);
		

	}
	
	@GetMapping("/retornarTodos")
	@ApiOperation(value="Metodo que retorna todos los comites creados")
	public ResponseEntity<List<Comite>> retornarTodos() throws ModelNotFoundException{
		
		return new ResponseEntity<List<Comite>>(service.mostrarComite(), HttpStatus.OK);

	}
	
	@GetMapping("/retornarId/{id}") 
	@ApiOperation(value="Metodo que retorna a un comite por su id")
	public ResponseEntity<?> retornarId(@PathVariable int id) throws ModelNotFoundException, Exception  {
		Comite c = service.buscarId(id);
		return new ResponseEntity<Comite>(c, HttpStatus.OK);	
				

	}
	


}
