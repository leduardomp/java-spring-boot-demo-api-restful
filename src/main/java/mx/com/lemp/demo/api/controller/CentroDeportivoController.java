package mx.com.lemp.demo.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mx.com.lemp.demo.api.model.CentroDeportivo;
import mx.com.lemp.demo.api.service.CentroDeportivoService;

@RestController
@RequestMapping(value = "/centro_deportivo")
public class CentroDeportivoController {

	@Autowired
	private CentroDeportivoService centroDeportivoService;
	
	@GetMapping("/")
	public List<CentroDeportivo> getAll() {
		return centroDeportivoService.getAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<CentroDeportivo> getByID(@PathVariable("id") Long id) {
		CentroDeportivo centroDeportivo = centroDeportivoService.get(id);
		return new ResponseEntity<CentroDeportivo>(centroDeportivo, HttpStatus.OK); 
	}
	
	@PostMapping("/")
	public ResponseEntity<CentroDeportivo> save(@RequestBody CentroDeportivo centroDeportivo) {
		CentroDeportivo centroDeportivoNew = centroDeportivoService.save(centroDeportivo);
		return new ResponseEntity<CentroDeportivo>(centroDeportivoNew, HttpStatus.OK);
	}
	
	@PutMapping("/")
	public ResponseEntity<CentroDeportivo> update(@RequestBody CentroDeportivo centroDeportivo) {
		CentroDeportivo centroDeportivoNew = centroDeportivoService.save(centroDeportivo);
		return new ResponseEntity<CentroDeportivo>(centroDeportivoNew, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<CentroDeportivo> delete(@PathVariable Long id) {
		
		CentroDeportivo centroDeportivo = centroDeportivoService.get(id);
		
		if(centroDeportivo != null) {
			centroDeportivoService.delete(id);
			return new ResponseEntity<CentroDeportivo>(centroDeportivo, HttpStatus.OK);	
		}else {
			return new ResponseEntity<CentroDeportivo>(centroDeportivo, HttpStatus.NOT_FOUND);
		}
		
	}

}
