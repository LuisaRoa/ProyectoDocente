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

import co.edu.unicundi.entity.Actas;
import co.edu.unicundi.entity.SolicitudSalidas;
import co.edu.unicundi.exception.ModelNotFoundException;
import co.edu.unicundi.service.ISolicitudSalidaService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/solicitudsalida")
//@PreAuthorize("hasAuthority('docente')")
public class SolicitudSalidaController {

	@Autowired
	private ISolicitudSalidaService service;
		
	@PreAuthorize("hasAuthority('Docente')")
	@PostMapping("/guardar")
	@ApiOperation(value="Metodo que crea una solicitud de aula virtual")
	public ResponseEntity<?> guardar (@Validated @RequestBody SolicitudSalidas soli ) throws Exception {
		service.guardar(soli);
		return new ResponseEntity<SolicitudSalidas>(soli, HttpStatus.CREATED);
		
			
	}
	
	@PreAuthorize("hasAuthority('Docente') OR hasAuthority('Administrativo')")
	@PutMapping("/editar")
    @ApiOperation(
            value = "Editar solicitud de salida  correspondiente al id",
            notes = "Editar solicitud de salida  correspondiente al id"
            )
            @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = SolicitudSalidas.class ),
            @ApiResponse(code = 503, message = "Servicio no Disponible", response = String.class),
            @ApiResponse(code = 500, message = "Error inesperado del sistema") })
	public ResponseEntity<SolicitudSalidas> editar(@Validated @RequestBody SolicitudSalidas soli) throws Exception, ModelNotFoundException{
		service.editar(soli);
		return new ResponseEntity<SolicitudSalidas>(soli, HttpStatus.CREATED);

	}
	
	@PreAuthorize("hasAuthority('Docente')")
	@DeleteMapping("eliminar/{id}")
    @ApiOperation(
            value = "Elimina la solicitud de salida  correspondiente al id",
            notes = "Elimina la solicitud de salida  correspondiente al id"
            )
            @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = SolicitudSalidas.class ),
            @ApiResponse(code = 404, message = "NOT_FOUND", response = SolicitudSalidas.class ),
            @ApiResponse(code = 503, message = "Servicio no Disponible", response = String.class),
            @ApiResponse(code = 500, message = "Error inesperado del sistema") })
	
	public ResponseEntity<Object>eliminar(@PathVariable int id) throws ModelNotFoundException{
		service.eliminar(id);
		return new ResponseEntity<Object>("", HttpStatus.NO_CONTENT);
		

	}
	
	@PreAuthorize("hasAuthority('Docente') OR hasAuthority('Administrativo')")
	@GetMapping("/retornarTodos")
	@ApiOperation(value="Metodo que retorna todas las solicitudes creadas")
	public ResponseEntity<List<SolicitudSalidas>> retornarTodos() throws ModelNotFoundException{
		
		return new ResponseEntity<List<SolicitudSalidas>>(service.mostrarSolicitudSalida(), HttpStatus.OK);

	}
	
	@PreAuthorize("hasAuthority('Docente') OR hasAuthority('Administrativo')")
	@GetMapping("/retornarEstado/{id}")
	@ApiOperation(value="Metodo que retorna todas las solicitudes por estado")
	public ResponseEntity<List<SolicitudSalidas>> retornarEstado(@PathVariable int id) throws ModelNotFoundException{
		
		return new ResponseEntity<List<SolicitudSalidas>>(service.retornarEstado(id), HttpStatus.OK);

	}
	
	@PreAuthorize("hasAuthority('Docente') OR hasAuthority('Administrativo')")
	@GetMapping("/retornarDocente/{id}")
	@ApiOperation(value="Metodo que retorna todas las solicitudes por docente")
	public ResponseEntity<List<SolicitudSalidas>> retornarDocente(@PathVariable int id) throws ModelNotFoundException{
		
		return new ResponseEntity<List<SolicitudSalidas>>(service.listarDocente(id), HttpStatus.OK);

	}
	
	@PreAuthorize("hasAuthority('Docente') OR hasAuthority('Administrativo')")
	@GetMapping("/retornarAdministrativo/{id}")
	@ApiOperation(value="Metodo que retorna todas las solicitudes por administrativo")
	public ResponseEntity<List<SolicitudSalidas>> retornarAdministrativo(@PathVariable int id) throws ModelNotFoundException{
		
		return new ResponseEntity<List<SolicitudSalidas>>(service.listarAdministrativo(id), HttpStatus.OK);

	}
	@GetMapping("/reporteanual/{a??o}")
	public ResponseEntity<List<SolicitudSalidas>> actasReporte(@PathVariable String a??o) throws ModelNotFoundException {
		List<SolicitudSalidas> list = service.mostrarSolicitudes(a??o);
		return new ResponseEntity(list, HttpStatus.OK);
	}
	
	@GetMapping("/reporteperiodo/{a??o}/{periodo}")
	public ResponseEntity<List<SolicitudSalidas>> aactasReporteP(@PathVariable String a??o, @PathVariable String periodo) throws ModelNotFoundException {
		List<SolicitudSalidas> list = service.mostrarSolicitudesP(a??o, periodo);
		return new ResponseEntity(list, HttpStatus.OK);
	}
}
