package co.edu.unicundi.controller;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import co.edu.unicundi.dto.Mensaje;
import co.edu.unicundi.entity.InformeRecuperacionClase;
import co.edu.unicundi.exception.ModelNotFoundException;
import co.edu.unicundi.service.CloudinaryService;
import co.edu.unicundi.service.RecuperacionClaseService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/recuperacionclase")
@CrossOrigin
public class RecuperacionClaseController {
	@Autowired
	CloudinaryService cloudinaryService;

	@Autowired
	RecuperacionClaseService adjuntar;

	@GetMapping("/list")
	public ResponseEntity<List<InformeRecuperacionClase>> list() {
		List<InformeRecuperacionClase> list = adjuntar.list();
		return new ResponseEntity(list, HttpStatus.OK);
	}

	@PostMapping("/upload")
    public ResponseEntity<?> upload(@RequestParam MultipartFile multipartFile)throws IOException {
        BufferedImage bi = ImageIO.read(multipartFile.getInputStream());
        /*if(bi == null){
            return new ResponseEntity(new Mensaje("imagen no válida"), HttpStatus.BAD_REQUEST);
        }*/
        Map result = cloudinaryService.upload(multipartFile);
        InformeRecuperacionClase recuperacionClase =
                new InformeRecuperacionClase(0,(String)result.get("original_filename"),
                        (String)result.get("url"),
                        (String)result.get("public_id"), null, null, null, null, null, null, null, 0, null, null, null, null);
                       /* (String)result.get("size")*/
        adjuntar.save(recuperacionClase);
        return new ResponseEntity<InformeRecuperacionClase>(recuperacionClase, HttpStatus.OK);
    }

	@PutMapping("/editar")
    @ApiOperation(
            value = "Editar al formato correspondiente al id",
            notes = "Editar al formato correspondiente al id"
            )
            @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = InformeRecuperacionClase.class ),
            @ApiResponse(code = 503, message = "Servicio no Disponible", response = String.class),
            @ApiResponse(code = 500, message = "Error inesperado del sistema") })
	public ResponseEntity<InformeRecuperacionClase> editar(@Validated @RequestBody InformeRecuperacionClase recuperacionClase) throws Exception, ModelNotFoundException{
		adjuntar.update(recuperacionClase);
		return new ResponseEntity<InformeRecuperacionClase>(recuperacionClase, HttpStatus.CREATED);

	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") int id) throws IOException {
		if (!adjuntar.exists(id))
			return new ResponseEntity<Object>(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
		InformeRecuperacionClase recuperacionClase = adjuntar.getOne(id).get();
		Map result = cloudinaryService.delete(recuperacionClase.getInformeId());
		adjuntar.delete(id);
		return new ResponseEntity(new Mensaje("AcuerdoPedagogico eliminado"), HttpStatus.OK);
	}

	@GetMapping("/retornarId/{id}")
	@ApiOperation(value = "Metodo que retorna a un formato por su id")
	public ResponseEntity<?> retornarId(@PathVariable int id) throws ModelNotFoundException, Exception {
		InformeRecuperacionClase recuperacionClase = adjuntar.getOne(id).get();
		return new ResponseEntity<InformeRecuperacionClase>(recuperacionClase, HttpStatus.OK);

	}
}
