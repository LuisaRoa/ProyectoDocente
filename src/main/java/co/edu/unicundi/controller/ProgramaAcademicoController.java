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
import co.edu.unicundi.entity.ProgramaAcademico;
import co.edu.unicundi.exception.ModelNotFoundException;
import co.edu.unicundi.service.IAdministrativoService;
import co.edu.unicundi.service.IProgramaAcademicoService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/programaacademico")
@PreAuthorize("hasAuthority('Docente') OR hasAuthority('Administrativo')")
public class ProgramaAcademicoController {
	
	@Autowired	
	private IProgramaAcademicoService service;

	@PostMapping("/guardar")
	@ApiOperation(value="Metodo que crea a un Programa Academico con su información")
	public ResponseEntity<?> guardar (@Validated @RequestBody ProgramaAcademico prac) throws Exception {
		service.guardar(prac);
		return new ResponseEntity<ProgramaAcademico>(prac, HttpStatus.CREATED);
		
			
	}
	@PutMapping("editar")
    @ApiOperation(
            value = "Editar al Programa Academico correspondiente al id",
            notes = "Editar al Programa Academico correspondiente al id"
            )
            @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = ProgramaAcademico.class ),
            @ApiResponse(code = 503, message = "Servicio no Disponible", response = String.class),
            @ApiResponse(code = 500, message = "Error inesperado del sistema") })
	public ResponseEntity<ProgramaAcademico> editar(@Validated @RequestBody ProgramaAcademico prac) throws Exception, ModelNotFoundException{
		service.editar(prac);
		return new ResponseEntity<ProgramaAcademico>(prac, HttpStatus.CREATED);

	}
	
	@DeleteMapping("eliminar/{id}")
    @ApiOperation(
            value = "Elimina el Programa Academico correspondiente al id",
            notes = "Elimina el Programa Academico correspondiente al id"
            )
            @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = ProgramaAcademico.class ),
            @ApiResponse(code = 404, message = "NOT_FOUND", response = ProgramaAcademico.class ),
            @ApiResponse(code = 503, message = "Servicio no Disponible", response = String.class),
            @ApiResponse(code = 500, message = "Error inesperado del sistema") })
	public ResponseEntity<Object>eliminar(@PathVariable int id) throws ModelNotFoundException{
		service.eliminar(id);
		return new ResponseEntity<Object>("", HttpStatus.NO_CONTENT);
		

	}
	
	@GetMapping("/retornarTodos")
	@ApiOperation(value="Metodo que retorna todos los Programas Academicos creados")
	public ResponseEntity<List<ProgramaAcademico>> retornarTodos() throws ModelNotFoundException{
		
		return new ResponseEntity<List<ProgramaAcademico>>(service.mostrarProgramaAcademico(), HttpStatus.OK);

	}
	@GetMapping("/retornarId/{id}") 
	@ApiOperation(value="Metodo que retorna a un Programa Academico por su id")
	public ResponseEntity<?> retornarId(@PathVariable int id) throws ModelNotFoundException, Exception  {
		ProgramaAcademico prac = service.buscarId(id);
		return new ResponseEntity<ProgramaAcademico>(prac, HttpStatus.OK);	
				

	}

}
