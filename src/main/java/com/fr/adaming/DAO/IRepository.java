package com.fr.adaming.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fr.adaming.entity.User;

public interface IRepository extends JpaRepository<User, Integer>{



}
