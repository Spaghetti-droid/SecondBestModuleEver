package com.fr.adaming.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fr.adaming.converter.UserConverter;
import com.fr.adaming.dto.LoginDto;
import com.fr.adaming.dto.RegisterDto;
import com.fr.adaming.service.UserService;

@RestController
@RequestMapping(path = "/bob")
public class UserController {
	
	@Autowired
	UserService service;
	
	
	@PostMapping(path = "/sleigh")
	public ResponseEntity<?> login(LoginDto dto) {
		
		dto = UserConverter.logConvertUserToDto (service.findByEmailAndPwd(dto.getMail(), dto.getMotDePasse()));
		
		if (dto != null) {
		return ResponseEntity.status(HttpStatus.OK).body("Bienvenue dans la matrice");
		} else {
			
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("L'univers vous rejete");
		}
		
	}
	
	
	public ResponseEntity<?> reg (RegisterDto dto){
		
		dto = UserConverter.regConvertUserToDto(service.save(UserConverter.regConverterDtoToUser(dto)));
		
		
		if (dto != null) {
			return ResponseEntity.status(HttpStatus.OK).body("Vous etes inscrit");
			} else {
				
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("ça ne marchera pas de toute façon");
			}
		
	}
	

}


