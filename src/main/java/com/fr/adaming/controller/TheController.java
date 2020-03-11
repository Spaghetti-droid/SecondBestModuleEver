package com.fr.adaming.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.fr.adaming.converter.TheConverter;
import com.fr.adaming.dto.FullTheDto;
import com.fr.adaming.dto.ITheController;
import com.fr.adaming.dto.TheDto;
import com.fr.adaming.service.ITheService;

@RestController
public class TheController implements ITheController{

	@Autowired
	private ITheService service;

	public ResponseEntity<?> ajouter(@Valid TheDto dto) {

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

	public ResponseEntity<?> supprimerThe(int id) {

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

	public ResponseEntity<?> modifier(@Valid FullTheDto dto) {

		ResponseEntity<?> resp = null;

		try {

			service.modifier(dto);
			resp = ResponseEntity.status(HttpStatus.OK).body("Modification éffectuée");

		} catch (Exception e) {
			resp = ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erreur pendant la modification");
		}

		return resp;

	}

	public ResponseEntity<?> get(int id) {

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
