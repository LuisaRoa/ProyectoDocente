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

import co.edu.unicundi.entity.Notificaciones;
import co.edu.unicundi.exception.ModelNotFoundException;
import co.edu.unicundi.service.NotificacionesService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/notificacion")
@PreAuthorize("hasAuthority('administrativo')")
public class NotificacionesController {
	@Autowired
	private NotificacionesService service;
	
	@PostMapping("/guardar")
	@ApiOperation(value="Metodo que crea una Notificacion con su información")
	public ResponseEntity<?> guardar (@Validated @RequestBody Notificaciones notificacion ) throws Exception {
		service.guardar(notificacion);
		return new ResponseEntity<Notificaciones>(notificacion, HttpStatus.CREATED);
		
			
	}
	@PutMapping("editar")
    @ApiOperation(
            value = "Editar la Notificacion correspondiente al id",
            notes = "Editar la Notificacion correspondiente al id"
            )
            @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = Notificaciones.class ),
            @ApiResponse(code = 503, message = "Servicio no Disponible", response = String.class),
            @ApiResponse(code = 500, message = "Error inesperado del sistema") })
	public ResponseEntity<Notificaciones> editar(@Validated @RequestBody Notificaciones notificacion) throws Exception, ModelNotFoundException{
		service.editar(notificacion);
		return new ResponseEntity<Notificaciones>(notificacion, HttpStatus.CREATED);

	}
	
	@DeleteMapping("eliminar/{id}")
    @ApiOperation(
            value = "Elimina la Notificacion correspondiente al id",
            notes = "Elimina la Notificacion correspondiente al id"
            )
            @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = Notificaciones.class ),
            @ApiResponse(code = 404, message = "NOT_FOUND", response = Notificaciones.class ),
            @ApiResponse(code = 503, message = "Servicio no Disponible", response = String.class),
            @ApiResponse(code = 500, message = "Error inesperado del sistema") })
	
	public ResponseEntity<Object>eliminar(@PathVariable int id) throws ModelNotFoundException{
		service.eliminar(id);
		return new ResponseEntity<Object>("", HttpStatus.NO_CONTENT);
		

	}
	
	@GetMapping("/retornarTodos")
	@ApiOperation(value="Metodo que retorna todas las Notificaciones creadas")
	public ResponseEntity<List<Notificaciones>> retornarTodos() throws ModelNotFoundException{
		
		return new ResponseEntity<List<Notificaciones>>(service.mostrarNotificaciones(), HttpStatus.OK);

	}
}
