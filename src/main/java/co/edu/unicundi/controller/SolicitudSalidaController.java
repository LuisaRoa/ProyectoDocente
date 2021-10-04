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

import co.edu.unicundi.entity.SolicitudSalida;
import co.edu.unicundi.exception.ModelNotFoundException;
import co.edu.unicundi.service.ISolicitudSalidaService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/solicitudsalida")
public class SolicitudSalidaController {

	@Autowired
	private ISolicitudSalidaService service;
		
	
	@PostMapping("/guardar")
	@ApiOperation(value="Metodo que crea una solicitud de aula virtual")
	public ResponseEntity<?> guardar (@Validated @RequestBody SolicitudSalida soli ) throws Exception {
		service.guardar(soli);
		return new ResponseEntity<SolicitudSalida>(soli, HttpStatus.CREATED);
		
			
	}
	@PutMapping("editar")
    @ApiOperation(
            value = "Editar solicitud de salida  correspondiente al id",
            notes = "Editar solicitud de salida  correspondiente al id"
            )
            @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = SolicitudSalida.class ),
            @ApiResponse(code = 503, message = "Servicio no Disponible", response = String.class),
            @ApiResponse(code = 500, message = "Error inesperado del sistema") })
	public ResponseEntity<SolicitudSalida> editar(@Validated @RequestBody SolicitudSalida soli) throws Exception, ModelNotFoundException{
		service.editar(soli);
		return new ResponseEntity<SolicitudSalida>(soli, HttpStatus.CREATED);

	}
	
	@DeleteMapping("eliminar/{id}")
    @ApiOperation(
            value = "Elimina la solicitud de salida  correspondiente al id",
            notes = "Elimina la solicitud de salida  correspondiente al id"
            )
            @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = SolicitudSalida.class ),
            @ApiResponse(code = 404, message = "NOT_FOUND", response = SolicitudSalida.class ),
            @ApiResponse(code = 503, message = "Servicio no Disponible", response = String.class),
            @ApiResponse(code = 500, message = "Error inesperado del sistema") })
	
	public ResponseEntity<Object>eliminar(@PathVariable int id) throws ModelNotFoundException{
		service.eliminar(id);
		return new ResponseEntity<Object>("", HttpStatus.NO_CONTENT);
		

	}
	
	@GetMapping("/retornarTodos")
	@ApiOperation(value="Metodo que retorna todas las solicitudes creadas")
	public ResponseEntity<List<SolicitudSalida>> retornarTodos() throws ModelNotFoundException{
		
		return new ResponseEntity<List<SolicitudSalida>>(service.mostrarSolicitudSalida(), HttpStatus.OK);

	}
	
	@GetMapping("/retornarEstado")
	@ApiOperation(value="Metodo que retorna todas las solicitudes por estado")
	public ResponseEntity<List<SolicitudSalida>> retornarEstado() throws ModelNotFoundException{
		
		return new ResponseEntity<List<SolicitudSalida>>(service.retornarEstado(), HttpStatus.OK);

	}
}
