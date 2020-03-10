package com.fr.adaming.converter;

import com.fr.adaming.dto.LoginDto;
import com.fr.adaming.dto.RegisterDto;
import com.fr.adaming.entity.User;

public class UserConverter {

	public User regConverterDtoToUser(RegisterDto regdto) {

		User user = new User();

		user.setNom(regdto.getName());
		user.setEmail(regdto.getMail());
		user.setPwd(regdto.getMotDePasse());

		return user;

	}

	public User logConverterDtoToUser(LoginDto logdto) {

		User user = new User();

		user.setNom(logdto.getName());
		user.setEmail(logdto.getMail());
		user.setPwd(logdto.getMotDePasse());

		return user;

	}

	public static RegisterDto regConvertUserToDto(User user) {

		RegisterDto regdto = new RegisterDto();

		regdto.setMail(user.getEmail());
		regdto.setMotDePasse(user.getPwd());
		regdto.setName(user.getNom());

		return regdto;

	}

	public static LoginDto logConvertUserToDto(User user) {

		LoginDto logdto = new LoginDto();

		logdto.setMail(user.getEmail());
		logdto.setMotDePasse(user.getPwd());
		logdto.setName(user.getNom());

		return logdto;

	}

}
