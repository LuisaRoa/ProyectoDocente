package co.edu.unicundi.controller;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
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
import co.edu.unicundi.entity.Actas;
import co.edu.unicundi.entity.Productos;
import co.edu.unicundi.exception.ModelNotFoundException;
import co.edu.unicundi.service.ActasService;
import co.edu.unicundi.service.CloudinaryService;
import co.edu.unicundi.service.ProductoService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/producto")
@CrossOrigin
public class ProductoController {
	
	@Autowired
	CloudinaryService cloudinaryService;

	@Autowired
	ProductoService prod;

	@PreAuthorize("hasAuthority('Docente') OR hasAuthority('Administrativo')")
	@GetMapping("/list")
	public ResponseEntity<List<Productos>> list() {
		List<Productos> list = prod.list();
		return new ResponseEntity(list, HttpStatus.OK);
	}

	@PreAuthorize("hasAuthority('Docente')")
	@PostMapping("/upload")
    public ResponseEntity<?> upload(@RequestParam MultipartFile multipartFile)throws IOException {
        BufferedImage bi = ImageIO.read(multipartFile.getInputStream());
        /*if(bi == null){
            return new ResponseEntity(new Mensaje("imagen no válida"), HttpStatus.BAD_REQUEST);
        }*/
        Map result = cloudinaryService.upload(multipartFile);
        Productos evidencia =
                new Productos(0,(String)result.get("original_filename"),
                        (String)result.get("url"),
                        (String)result.get("public_id"), null, null, null, null, null, null);
                       /* (String)result.get("size")*/
        prod.save(evidencia);
        return new ResponseEntity<Productos>(evidencia, HttpStatus.OK);
    }
	
	@PreAuthorize("hasAuthority('Docente')")
	@PutMapping("/editar")
    @ApiOperation(
            value = "Editar al Producto correspondiente al id",
            notes = "Editar al Producto correspondiente al id"
            )
            @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK", response = Productos.class ),
            @ApiResponse(code = 503, message = "Servicio no Disponible", response = String.class),
            @ApiResponse(code = 500, message = "Error inesperado del sistema") })
	public ResponseEntity<Productos> editar(@Validated @RequestBody Productos evidencia) throws Exception, ModelNotFoundException{
		prod.update(evidencia);
		return new ResponseEntity<Productos>(evidencia, HttpStatus.CREATED);

	}

	@PreAuthorize("hasAuthority('Docente')")
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") int id) throws IOException {
		if (!prod.exists(id))
			return new ResponseEntity<Object>(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
		Productos evidencia = prod.getOne(id).get();
		Map result = cloudinaryService.delete(evidencia.getProductoId());
		prod.delete(id);
		return new ResponseEntity(new Mensaje("Producto eliminado"), HttpStatus.OK);
	}

	@PreAuthorize("hasAuthority('Docente') OR hasAuthority('Administrativo')")
	@GetMapping("/retornarId/{id}")
	@ApiOperation(value = "Metodo que retorna a un Producto por su id")
	public ResponseEntity<?> retornarId(@PathVariable int id) throws ModelNotFoundException, Exception {
		Productos evidencia = prod.getOne(id).get();
		return new ResponseEntity<Productos>(evidencia, HttpStatus.OK);

	}
	
	@PreAuthorize("hasAuthority('Docente') OR hasAuthority('Administrativo')")
	@GetMapping("/listarComite/{id}")
	public ResponseEntity<List<Productos>> listarComite(@PathVariable int id) {
		List<Productos> list = prod.listarComite(id);
		return new ResponseEntity(list, HttpStatus.OK);
	}
}
