package com.fr.adaming.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fr.adaming.entity.User;

@Repository
public interface IRepository extends JpaRepository<User, Integer>{

	
	public User findByEmailAndPwd(String email, String pwd);
	
	
 

}
