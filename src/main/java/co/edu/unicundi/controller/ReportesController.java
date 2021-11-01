package co.edu.unicundi.controller;

import org.springframework.data.jpa.repository.Query;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/reportes")
public class ReportesController {

	
	
	
	@GetMapping("/syllabus/{año},{periodo}")
	@ApiOperation(value="Metodo que retorna un director por ID")
	@Query(value="SELECT  doce_nombre, doce_codigo,count(syllabus.id)FROM docente, syllabus where syllabus.docente_doce_id = doce_id and syllabus.periodo_aca =?1 and syllabus.fecha LIKE '?2%' GROUP BY doce_nombre,doce_codigo;", nativeQuery = true)
	public Integer numerodeSyllabus(Integer año, Integer periodo) {
		return null;
	}
}
