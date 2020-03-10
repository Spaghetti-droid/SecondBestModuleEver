package com.fr.adaming.converter;

import org.springframework.beans.factory.annotation.Autowired;

import com.fr.adaming.DAO.ITheRepository;
import com.fr.adaming.dto.TheDto;
import com.fr.adaming.entity.The;

public class TheConverter {
	
	@Autowired
	ITheRepository repo;
	
	public static The convertDtoToThe(TheDto dto) {
		
		The the = new The();
		
		the.setType(dto.getVariety());
		the.setMarque(dto.getBrand());
		the.setPoids(dto.getWeight());
		the.setEnSachet(dto.isInBags());
		
		return the;
		
	}
	
	
	public static TheDto convertTheToDto(The the) {
		
		TheDto dto = new TheDto();
		
		dto.setVariety(the.getType());
		dto.setBrand(the.getMarque());
		dto.setWeight(the.getPoids());
		dto.setInBags(the.isEnSachet());
		
		return dto;
		
	}

}
