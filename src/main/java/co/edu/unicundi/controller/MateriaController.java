package co.edu.unicundi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.unicundi.entity.AulasVirtuales;
import co.edu.unicundi.entity.Materia;
import co.edu.unicundi.exception.ModelNotFoundException;
import co.edu.unicundi.service.IMateriaService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/materia")
@PreAuthorize("hasAuthority('Docente') OR hasAuthority('Administrativo') OR hasAuthority('Administrador') ")
public class MateriaController {
	
	@Autowired
	private IMateriaService service;
		
	
	@PostMapping("/guardar")
	@ApiOperation(value="Metodo que crea una materia con su información")
	public ResponseEntity<?> guardar (@Validated @RequestBody Materia materia ) throws Exception {
		service.guardar(materia);
		return new ResponseEntity<Materia>(materia, HttpStatus.CREATED);
		
			
	}
	@PutMapping("editar")
    @ApiOperation(
            value = "Editar la materia correspondiente al id",
            notes = "Editar la materia correspondiente al id"
            )
            @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = Materia.class ),
            @ApiResponse(code = 503, message = "Servicio no Disponible", response = String.class),
            @ApiResponse(code = 500, message = "Error inesperado del sistema") })
	public ResponseEntity<Materia> editar(@Validated @RequestBody Materia materia) throws Exception, ModelNotFoundException{
		service.editar(materia);
		return new ResponseEntity<Materia>(materia, HttpStatus.CREATED);

	}
	
	@DeleteMapping("eliminar/{id}")
    @ApiOperation(
            value = "Elimina la materia correspondiente al id",
            notes = "Elimina la materia correspondiente al id"
            )
            @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = Materia.class ),
            @ApiResponse(code = 404, message = "NOT_FOUND", response = Materia.class ),
            @ApiResponse(code = 503, message = "Servicio no Disponible", response = String.class),
            @ApiResponse(code = 500, message = "Error inesperado del sistema") })
	
	public ResponseEntity<Object>eliminar(@PathVariable int id) throws ModelNotFoundException{
		service.eliminar(id);
		return new ResponseEntity<Object>("", HttpStatus.NO_CONTENT);
		

	}
	
	@GetMapping("/retornarTodos")
	@ApiOperation(value="Metodo que retorna todas las materias creadas")
	public ResponseEntity<List<Materia>> retornarTodos() throws ModelNotFoundException{
		
		return new ResponseEntity<List<Materia>>(service.mostrarMateria(), HttpStatus.OK);

	}
	
	@GetMapping("/retornarId/{id}") 
	@ApiOperation(value="Metodo que retorna una Materia por su id")
	public ResponseEntity<?> retornarId(@PathVariable int id) throws ModelNotFoundException, Exception  {
		Materia materia = service.buscarId(id);
		return new ResponseEntity<Materia>(materia, HttpStatus.OK);	
				

	}

}
