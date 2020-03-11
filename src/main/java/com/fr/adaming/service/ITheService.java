package com.fr.adaming.service;

import java.util.List;

import com.fr.adaming.dto.FullTheDto;
import com.fr.adaming.entity.The;

public interface ITheService {
	
	public The save(The entity);

	public List<The> findAll();

	public The findById(Integer id);

	public void deleteById(Integer id);

	public void delete(The entity);

	public void deleteAll();
	
	public void modifier(FullTheDto dto);

}
