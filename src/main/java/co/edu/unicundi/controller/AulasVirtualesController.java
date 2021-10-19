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

import co.edu.unicundi.entity.Administrativo;
import co.edu.unicundi.entity.AulasVirtuales;
import co.edu.unicundi.entity.Facultad;
import co.edu.unicundi.exception.ModelNotFoundException;
import co.edu.unicundi.service.IAulaVirtualService;
import co.edu.unicundi.service.IFacultadService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/aulasvirtuales")
@PreAuthorize("hasAuthority('docente')")
public class AulasVirtualesController {
	
	@Autowired
	private IAulaVirtualService service;
		
	
	@PostMapping("/guardar")
	@ApiOperation(value="Metodo que crea una Aula Virtual con su información")
	public ResponseEntity<?> guardar (@Validated @RequestBody AulasVirtuales aulas ) throws Exception {
		service.guardar(aulas);
		return new ResponseEntity<AulasVirtuales>(aulas, HttpStatus.CREATED);
		
			
	}
	@PutMapping("editar")
    @ApiOperation(
            value = "Editar la Aula Virtual correspondiente al id",
            notes = "Editar la Aula Virtual correspondiente al id"
            )
            @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = AulasVirtuales.class ),
            @ApiResponse(code = 503, message = "Servicio no Disponible", response = String.class),
            @ApiResponse(code = 500, message = "Error inesperado del sistema") })
	public ResponseEntity<AulasVirtuales> editar(@Validated @RequestBody AulasVirtuales aulas) throws Exception, ModelNotFoundException{
		service.editar(aulas);
		return new ResponseEntity<AulasVirtuales>(aulas, HttpStatus.CREATED);

	}
	
	@DeleteMapping("eliminar/{id}")
    @ApiOperation(
            value = "Elimina la Aula Virtual correspondiente al id",
            notes = "Elimina la Aula Virtual correspondiente al id"
            )
            @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = AulasVirtuales.class ),
            @ApiResponse(code = 404, message = "NOT_FOUND", response = AulasVirtuales.class ),
            @ApiResponse(code = 503, message = "Servicio no Disponible", response = String.class),
            @ApiResponse(code = 500, message = "Error inesperado del sistema") })
	
	public ResponseEntity<Object>eliminar(@PathVariable int id) throws ModelNotFoundException{
		service.eliminar(id);
		return new ResponseEntity<Object>("", HttpStatus.NO_CONTENT);
		

	}
	
	@GetMapping("/retornarTodos")
	@ApiOperation(value="Metodo que retorna todas las Facultades creadas")
	public ResponseEntity<List<AulasVirtuales>> retornarTodos() throws ModelNotFoundException{
		
		return new ResponseEntity<List<AulasVirtuales>>(service.mostrarAulasVirtuales(), HttpStatus.OK);

	}

	@GetMapping("/retornarId/{id}") 
	@ApiOperation(value="Metodo que retorna a un Aula virtual por su id")
	public ResponseEntity<?> retornarId(@PathVariable int id) throws ModelNotFoundException, Exception  {
		AulasVirtuales aula = service.buscarId(id);
		return new ResponseEntity<AulasVirtuales>(aula, HttpStatus.OK);	
				

	}
	
	@GetMapping("/listarDocente/{id}") 
	@ApiOperation(value="Metodo que retorna a un Aula virtual por su id")
	public ResponseEntity<?> listarDocente(@PathVariable int id) throws ModelNotFoundException, Exception  {
		return new ResponseEntity<List<AulasVirtuales>>(service.listarDocente(id), HttpStatus.OK);	
				

	}


}
