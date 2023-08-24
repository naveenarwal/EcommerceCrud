package com.commerce.app.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.commerce.app.entities.User;

public interface IUserRepositoty  extends JpaRepository<User, Integer>{
  public User findByUsernameAndPassword(String username,String password);
  
  public User findByUsername(String username);
} 
