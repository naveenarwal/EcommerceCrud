package com.commerce.app.exception;

public class UserNotFoundException extends RuntimeException{
	
	
	  public UserNotFoundException(){
		  
	  }

	  public UserNotFoundException(String msg){
		  super(msg);
	  }
}
