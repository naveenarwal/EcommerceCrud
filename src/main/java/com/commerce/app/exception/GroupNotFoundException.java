package com.commerce.app.exception;

public class GroupNotFoundException extends RuntimeException {
	
	
	  public GroupNotFoundException(){
		  
	  }

	  public GroupNotFoundException(String msg){
		  super(msg);
	  }
}
