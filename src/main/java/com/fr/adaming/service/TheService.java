package com.fr.adaming.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fr.adaming.DAO.ITheRepository;
import com.fr.adaming.dto.FullTheDto;
import com.fr.adaming.dto.TheDto;
import com.fr.adaming.entity.The;

@Service
public class TheService implements ITheService{
	
	@Autowired
	private ITheRepository repo;

	public The save(The entity) {
		return repo.save(entity);
	}

	public List<The> findAll() {
		return repo.findAll();
	}

	public The findById(Integer id) {
		return repo.findById(id).get();
	}

	public void deleteById(Integer id) {
		repo.deleteById(id);
	}

	public void delete(The entity) {
		repo.delete(entity);
	}

	public void deleteAll() {
		repo.deleteAll();
	}
	
	public void modifier(FullTheDto dto) {
		
		The the = repo.findById(dto.getId()).get();
		
		the.setMarque(dto.getBrand());
		the.setType(dto.getVariety());
		the.setPoids(dto.getWeight());
		the.setEnSachet(dto.isInBags());
		
		repo.save(the);
		
	}

}
