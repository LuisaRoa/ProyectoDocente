package co.edu.unicundi.controller;



import java.util.List;


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
import org.springframework.web.bind.annotation.RestController;

import co.edu.unicundi.entity.Docente;
import co.edu.unicundi.exception.InvalidFormatExcepcion;
import co.edu.unicundi.exception.ModelNotFoundException;
import co.edu.unicundi.service.IDocenteService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;


@RestController
@RequestMapping("/docente")
public class DocenteController {
	
	@Autowired
	private IDocenteService service;
		
	
	@PostMapping("/guardar")
	@ApiOperation(value="Metodo que crea a un docente con su información")
	public ResponseEntity<?> guardar (@Validated @RequestBody Docente docente) throws Exception {
		service.guardar(docente);
		return new ResponseEntity<Docente>(docente, HttpStatus.CREATED);
		
			
	}
	@PutMapping("editar")
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
	
	@GetMapping("/retornarTodos")
	@ApiOperation(value="Metodo que retorna todos los docentes creados")
	public ResponseEntity<List<Docente>> retornarTodos() throws ModelNotFoundException{
		
		return new ResponseEntity<List<Docente>>(service.mostrarDocentes(), HttpStatus.OK);

	}
	
	@GetMapping("/retornarId/{id}") 
	@ApiOperation(value="Metodo que retorna a un docente por su id")
	public ResponseEntity<?> retornarId(@PathVariable int id) throws ModelNotFoundException, Exception  {
		Docente docente = service.buscarId(id);
		return new ResponseEntity<Docente>(docente, HttpStatus.OK);	
				

	}
	
	@GetMapping("/buscarCorreo/{correo}") 
	@ApiOperation(value="Metodo que retorna el documento por su correo")
	public ResponseEntity<?> buscarCorreo(@PathVariable String correo) throws ModelNotFoundException, Exception  {
		Docente docente = service.buscarCorreo(correo);
		return new ResponseEntity<Docente>(docente, HttpStatus.OK);	
				

	}
	 
	

}
