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

import co.edu.unicundi.entity.Miembros;
import co.edu.unicundi.exception.ModelNotFoundException;
import co.edu.unicundi.repo.IDocenteRepo;
import co.edu.unicundi.service.IMiembrosService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/miembros")
public class MiembrosController {
	
	@Autowired	
	private IMiembrosService service;
	
	
	@PostMapping("/guardar")
	@ApiOperation(value="Metodo que crea a un miembro con su información")
	public ResponseEntity<?> guardar (@Validated @RequestBody Miembros mien) throws Exception {
		service.guardar(mien);
		return new ResponseEntity<Miembros>(mien, HttpStatus.CREATED);
		
			
	}
	@PutMapping("/editar")
    @ApiOperation(
            value = "Editar al Miembro correspondiente al id",
            notes = "Editar al Miembro correspondiente al id"
            )
            @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = Miembros.class ),
            @ApiResponse(code = 503, message = "Servicio no Disponible", response = String.class),
            @ApiResponse(code = 500, message = "Error inesperado del sistema") })
	public ResponseEntity<Miembros> editar(@Validated @RequestBody Miembros mien) throws Exception, ModelNotFoundException{
		service.editar(mien);
		return new ResponseEntity<Miembros>(mien, HttpStatus.CREATED);

	}
	
	@DeleteMapping("eliminar/{id}")
    @ApiOperation(
            value = "Elimina el Miembro correspondiente al id",
            notes = "Elimina el Miembro correspondiente al id"
            )
            @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = Miembros.class ),
            @ApiResponse(code = 404, message = "NOT_FOUND", response = Miembros.class ),
            @ApiResponse(code = 503, message = "Servicio no Disponible", response = String.class),
            @ApiResponse(code = 500, message = "Error inesperado del sistema") })
	public ResponseEntity<Object>eliminar(@PathVariable int id) throws ModelNotFoundException{
		service.eliminar(id);
		return new ResponseEntity<Object>("", HttpStatus.NO_CONTENT);
		

	}
	
	@GetMapping("/retornarTodos")
	@ApiOperation(value="Metodo que retorna todos los Miembros creados")
	public ResponseEntity<List<Miembros>> retornarTodos() throws ModelNotFoundException{
		
		return new ResponseEntity<List<Miembros>>(service.mostrarMiembros(), HttpStatus.OK);

	}
	@GetMapping("/retornarId/{id}") 
	@ApiOperation(value="Metodo que retorna a un Miembro por su id")
	public ResponseEntity<?> retornarId(@PathVariable int id) throws ModelNotFoundException, Exception  {
		Miembros mien = service.buscarId(id);
		return new ResponseEntity<Miembros>(mien, HttpStatus.OK);	
				

	}
}
