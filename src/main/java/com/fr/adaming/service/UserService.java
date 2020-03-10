package com.fr.adaming.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fr.adaming.DAO.IRepository;
import com.fr.adaming.entity.User;

@Service
public class UserService {
	
	@Autowired
	private IRepository repo;

	public User findByEmailAndPwd(String email, String pwd) {
		return repo.findByEmailAndPwd(email, pwd);
	}

	public User save(User user) {
		return repo.save(user);
	}

	public List<User> findAll() {
		return repo.findAll();
	}

	public User findById(Integer id) {
		return repo.findById(id).get();
	}

	public void deleteById(Integer id) {
		repo.deleteById(id);
	}

	public void delete(User entity) {
		repo.delete(entity);
	}

	public void deleteAll() {
		repo.deleteAll();
	}
	
	

}
