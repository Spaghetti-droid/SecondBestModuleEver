package com.fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fr.adaming.DAO.IRepository;
import com.fr.adaming.dto.ModifierDto;
import com.fr.adaming.entity.User;

@Service
public class UserService implements IUserService{

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

	public void modifierUser(ModifierDto dto) {
		User u;
		int id = dto.getId();
		u = repo.findById(id).get();
		u.setEmail(dto.getMail());
		u.setNom(dto.getName());
		u.setPwd(dto.getMotDePasse());
		
		repo.save(u);

	}

}
