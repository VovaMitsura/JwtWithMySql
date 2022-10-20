package com.example.jwtwithmysql.dao;

import com.example.jwtwithmysql.model.DAOUser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDAO extends CrudRepository<DAOUser, Integer> {

  DAOUser findByUsername(String username);
}
