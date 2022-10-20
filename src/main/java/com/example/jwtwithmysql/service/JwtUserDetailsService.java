package com.example.jwtwithmysql.service;

import com.example.jwtwithmysql.dao.UserDAO;
import com.example.jwtwithmysql.model.DAOUser;
import com.example.jwtwithmysql.model.UserDTO;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class JwtUserDetailsService implements UserDetailsService {

  @Autowired
  private UserDAO userDAO;

  @Autowired
  private PasswordEncoder bcryptEncoder;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

    DAOUser user = userDAO.findByUsername(username);

    if (user == null) {
      throw new UsernameNotFoundException("User " + username + " not found");
    }
    return new org.springframework.security.core
        .userdetails.User(user.getUsername(), user.getPassword(), new ArrayList<>());
  }

  public DAOUser save(UserDTO user) {
    DAOUser daoUser = new DAOUser();
    daoUser.setUsername(user.getUsername());
    daoUser.setPassword(bcryptEncoder.encode(user.getPassword()));
    return userDAO.save(daoUser);
  }
}
