package com.fr.adaming.dto;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


@RequestMapping(path = "/the")
public interface ITheController {


	@PostMapping
	public ResponseEntity<?> ajouter(@RequestBody TheDto dto);

	@DeleteMapping(path = "/{id}")
	public ResponseEntity<?> supprimerThe(@PathVariable(name = "id") int id) ;

	@PutMapping
	public ResponseEntity<?> modifier(@RequestBody FullTheDto dto) ;

	@GetMapping(path = "/{id}")
	public ResponseEntity<?> get(@PathVariable(name = "id") int id) ;

	@GetMapping(path = "/all")
	public ResponseEntity<?> getAll();

	
}
