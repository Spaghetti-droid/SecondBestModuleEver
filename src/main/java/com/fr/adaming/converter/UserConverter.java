package com.fr.adaming.converter;

import com.fr.adaming.dto.RegisterDto;
import com.fr.adaming.entity.User;

public class UserConverter {

	
	public User converterDtoToUser(RegisterDto dto) {
		
		User user = new User();
		
		
		user.setNom(dto.getName());
		user.setEmail(dto.getMail());
		user.setPwd(dto.getMotDePasse());
		
		return user;	
		
	}
	
	public static RegisterDto convertUserToDto(User user) {

		RegisterDto dto = new RegisterDto();

		dto.setMail(user.getEmail());
		dto.setMotDePasse(user.getPwd());
		dto.setName(user.getNom());

		return dto;

	}
	
	
}
