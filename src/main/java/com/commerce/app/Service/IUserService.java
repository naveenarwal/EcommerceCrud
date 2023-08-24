package com.commerce.app.Service;

import java.util.List;

import com.commerce.app.entities.User;

public interface IUserService {
     public User login(String username,String password);
     
     public User addUser(User user);
     
     public User updateUser(User user);
     
     public boolean deleteUser(Integer id);
     
     public User getUser(Integer id);
     
     public List<User> getUsers();
     
}
