package com.fr.adaming.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fr.adaming.converter.TheConverter;
import com.fr.adaming.dto.TheDto;
import com.fr.adaming.service.TheService;

@RestController
@RequestMapping(path = "/the")
public class TheController {
	
	private TheService service;
	
	public ResponseEntity<?> ajouter(TheDto dto){
		
		dto = TheConverter.convertTheToDto(service.save(TheConverter.convertDtoToThe(dto)));
		
		return ResponseEntity.status(HttpStatus.OK).body("Ajout effectué");		
	}

}
