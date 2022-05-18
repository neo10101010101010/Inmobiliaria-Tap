package com.app.inmobiliaria.rest;

import java.net.URI;
import java.util.List;
import java.util.Optional;

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

import com.app.inmobiliaria.model.Inmobiliaria;
import com.app.inmobiliaria.service.InmobiliariaService;

@RestController
@RequestMapping ("/api/inmobiliaria/")
public class InmobiliariaREST {

	@Autowired
	private InmobiliariaService inmobiliariaService;
	
	@PostMapping
	private ResponseEntity<Inmobiliaria> guardar (@RequestBody Inmobiliaria inmobiliaria){
		Inmobiliaria temporal = inmobiliariaService.create(inmobiliaria);
		
		try {
			return ResponseEntity.created(new URI("/api/inmobiliaria"+temporal.getId())).body(temporal);
			
		}catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
	
	@GetMapping
	private ResponseEntity<List<Inmobiliaria>> listarTodasLasCasas (){
		return ResponseEntity.ok(inmobiliariaService.getAllCasas());
	}
	
	@DeleteMapping
	private ResponseEntity<Void> eliminarInmobiliaria (@RequestBody Inmobiliaria inmobiliaria){
		inmobiliariaService.delete(inmobiliaria);
		return ResponseEntity.ok().build();
	}
	
	@PutMapping
    public ResponseEntity<Inmobiliaria> editInmobiliaria (@RequestBody Inmobiliaria inmobiliaria){
        return ResponseEntity.status(HttpStatus.CREATED).body(inmobiliariaService.editInmobiliaria(inmobiliaria));
    }
	
	@GetMapping (value = "{id}")
	private ResponseEntity<Optional<Inmobiliaria>> listarCasasPorID (@PathVariable ("id") Long id){
		return ResponseEntity.ok(inmobiliariaService.findById(id));
	}
}
