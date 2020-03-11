package com.fr.adaming.service;

import java.util.List;

import com.fr.adaming.dto.ModifierDto;
import com.fr.adaming.entity.User;

public interface  IUserService  {
	
	public User findByEmailAndPwd(String email, String pwd);

	public User save(User user);

	public List<User> findAll();
		

	public User findById(Integer id);

	public void deleteById(Integer id);

	public void delete(User entity);

	public void deleteAll();

	public void modifierUser(ModifierDto dto);

}
