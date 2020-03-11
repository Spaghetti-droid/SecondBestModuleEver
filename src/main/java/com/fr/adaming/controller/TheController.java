package com.fr.adaming.controller;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fr.adaming.converter.TheConverter;
import com.fr.adaming.dto.FullTheDto;
import com.fr.adaming.dto.TheDto;
import com.fr.adaming.service.ITheService;
import com.fr.adaming.service.TheService;

@RestController
@RequestMapping(path = "/the")
public class TheController {

	@Autowired
	private ITheService service;

	@PostMapping
	public ResponseEntity<?> ajouter(@RequestBody TheDto dto) {

		ResponseEntity<?> resp = null;

		try {
			dto = TheConverter.convertTheToDto(service.save(TheConverter.convertDtoToThe(dto)));

			resp = ResponseEntity.status(HttpStatus.OK).body("Ajout effectué");

		} catch (Exception e) {

			e.printStackTrace();
			resp = ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body("Probleme pendant l'ajout");

		}

		return resp;
	}

	@DeleteMapping(path = "/{id}")
	public ResponseEntity<?> supprimerThe(@PathVariable(name = "id") int id) {

		ResponseEntity<?> resp = null;

		try {
			service.deleteById(id);
			resp = ResponseEntity.status(HttpStatus.OK).body("Un thé en moins :( ");
		} catch (Exception e) {
			e.printStackTrace();
			resp = ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Problème pendant la suppression.");
		}

		return resp;

	}

	@PutMapping
	public ResponseEntity<?> modifier(@RequestBody FullTheDto dto) {

		ResponseEntity<?> resp = null;

		try {

			service.modifier(dto);
			resp = ResponseEntity.status(HttpStatus.OK).body("Modification éffectuée");

		} catch (Exception e) {
			resp = ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erreur pendant la modification");
		}

		return resp;

	}

	@GetMapping(path = "/{id}")
	public ResponseEntity<?> get(@PathVariable(name = "id") int id) {

		ResponseEntity<?> resp = null;

		try {

			TheDto dto = TheConverter.convertTheToDto(service.findById(id));
			resp = ResponseEntity.status(HttpStatus.OK).body(dto);

		} catch (Exception e) {

			e.printStackTrace(); // TODO trouver l'exception specifique lancé quand on essay de convertir un
									// null. Probablement NullPointerException
			resp = ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Ce thé n'as pas été trouvé");

		}

		return resp;
	}

	@GetMapping(path = "/all")
	public ResponseEntity<?> getAll() {

		ResponseEntity<?> resp = null;

		try {

			List<FullTheDto> dtoList = TheConverter.convertThetoFullDto(service.findAll()); // Note: Ceci est la version du
																					// convertisseur qui prend une liste
																					// en entrée

			resp = ResponseEntity.status(HttpStatus.OK).body(dtoList);

		} catch (Exception e) {
			e.printStackTrace();
			resp = ResponseEntity.status(HttpStatus.I_AM_A_TEAPOT).body("Exception pendant getAll");
		}

		return resp;

	}

}
