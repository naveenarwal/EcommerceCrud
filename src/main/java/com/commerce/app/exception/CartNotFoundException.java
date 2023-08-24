package com.commerce.app.exception;

public class CartNotFoundException extends RuntimeException{
  public CartNotFoundException() {
	  
  }
public CartNotFoundException(String msg) {
	  super(msg);
  }
  
}
