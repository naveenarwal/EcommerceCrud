package com.commerce.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.commerce.app.Service.IUserService;
import com.commerce.app.entities.User;
import com.commerce.app.exception.UserFoundException;
import com.commerce.app.exception.UserNotFoundException;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private IUserService userService;
	
	@GetMapping ("/{username}/{password}")
   public ResponseEntity<User> loginUser(@PathVariable String username,@PathVariable String password){
		ResponseEntity<User> response = null;
		try {
		 response=	new ResponseEntity<User>(this.userService.login(username, password),HttpStatus.OK);
		}catch(UserNotFoundException us) {
			throw us;
		}
		return response;
	}
	
	@PostMapping("/")
	   public ResponseEntity<User> addUser(@RequestBody User user){
			ResponseEntity<User> response = null;
			try {
            response=	new ResponseEntity<User>(this.userService.addUser(user),HttpStatus.OK);
			}catch(UserFoundException us) {
				throw new UserFoundException("User Name ALready exis");
			}
			return response;
		}

}
