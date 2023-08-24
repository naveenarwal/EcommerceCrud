package com.commerce.app.exception;

public class CartItemNotFoundException extends RuntimeException {
   public CartItemNotFoundException() {
	   
   }
public CartItemNotFoundException(String msg) {
	   super(msg);
   }
}
