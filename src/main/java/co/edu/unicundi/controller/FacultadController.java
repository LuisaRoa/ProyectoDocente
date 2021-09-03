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

import co.edu.unicundi.entity.Facultad;
import co.edu.unicundi.entity.Materia;
import co.edu.unicundi.exception.ModelNotFoundException;
import co.edu.unicundi.service.IFacultadService;
import co.edu.unicundi.service.IMateriaService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/facultad")
public class FacultadController {
	
	@Autowired
	private IFacultadService service;
		
	
	@PostMapping("/guardar")
	@ApiOperation(value="Metodo que crea una facultad con su información")
	public ResponseEntity<?> guardar (@Validated @RequestBody Facultad facultad ) throws Exception {
		service.guardar(facultad);
		return new ResponseEntity<Facultad>(facultad, HttpStatus.CREATED);
		
			
	}
	@PutMapping("editar")
    @ApiOperation(
            value = "Editar la facultad correspondiente al id",
            notes = "Editar la facultad correspondiente al id"
            )
            @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = Facultad.class ),
            @ApiResponse(code = 503, message = "Servicio no Disponible", response = String.class),
            @ApiResponse(code = 500, message = "Error inesperado del sistema") })
	public ResponseEntity<Facultad> editar(@Validated @RequestBody Facultad facultad) throws Exception, ModelNotFoundException{
		service.editar(facultad);
		return new ResponseEntity<Facultad>(facultad, HttpStatus.CREATED);

	}
	
	@DeleteMapping("eliminar/{id}")
    @ApiOperation(
            value = "Elimina la Facultad correspondiente al id",
            notes = "Elimina la Facultad correspondiente al id"
            )
            @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = Facultad.class ),
            @ApiResponse(code = 404, message = "NOT_FOUND", response = Facultad.class ),
            @ApiResponse(code = 503, message = "Servicio no Disponible", response = String.class),
            @ApiResponse(code = 500, message = "Error inesperado del sistema") })
	
	public ResponseEntity<Object>eliminar(@PathVariable int id) throws ModelNotFoundException{
		service.eliminar(id);
		return new ResponseEntity<Object>("", HttpStatus.NO_CONTENT);
		

	}
	
	@GetMapping("/retornarTodos")
	@ApiOperation(value="Metodo que retorna todas las Facultades creadas")
	public ResponseEntity<List<Facultad>> retornarTodos() throws ModelNotFoundException{
		
		return new ResponseEntity<List<Facultad>>(service.mostrarFacultad(), HttpStatus.OK);

	}

}
