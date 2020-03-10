package com.fr.adaming.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fr.adaming.entity.The;

@Repository
public interface ITheRepository extends JpaRepository<The, Integer>{

}
