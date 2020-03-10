package com.fr.adaming.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.fr.adaming.converter.UserConverter;
import com.fr.adaming.dto.LoginDto;
import com.fr.adaming.dto.ModifierDto;
import com.fr.adaming.dto.RegisterDto;
import com.fr.adaming.service.UserService;

@RestController
@RequestMapping(path = "/bob")
public class UserController {

	@Autowired
	UserService service;

	@PostMapping(path = "/sleigh")
	public ResponseEntity<?> login(@RequestBody LoginDto dto) {

		dto = UserConverter.logConvertUserToDto(service.findByEmailAndPwd(dto.getMail(), dto.getMotDePasse()));

		if (dto != null) {
			return ResponseEntity.status(HttpStatus.OK).body("Bienvenue dans la matrice");
		} else {

			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("L'univers vous rejete");
		}

	}

	@PostMapping(path = "/reg")
	public ResponseEntity<?> reg(@RequestBody RegisterDto dto) {

		dto = UserConverter.regConvertUserToDto(service.save(UserConverter.regConverterDtoToUser(dto)));

		if (dto != null) {
			return ResponseEntity.status(HttpStatus.OK).body("Vous etes inscrit");
		} else {

			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("ça ne marchera pas de toute façon");
		}

	}

	@GetMapping(path = "/mod")
	public ResponseEntity<?> suprimmerUser(@PathVariable(name = "id") int id) {
		service.deleteById(id);

		try {
			return ResponseEntity.status(HttpStatus.OK).body("vous etes suprimmer");

		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.OK).body("t'es toujours en vie");
		}

	}

	@PostMapping(path = "/update")
	public ResponseEntity<?> modifierUser(@RequestBody ModifierDto dto) {

		service.modifierUser(dto);

		return ResponseEntity.status(HttpStatus.OK).body(dto);
	}
	
	

}
