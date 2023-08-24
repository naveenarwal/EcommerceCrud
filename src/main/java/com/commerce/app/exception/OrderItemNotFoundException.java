package com.commerce.app.exception;

public class OrderItemNotFoundException extends RuntimeException{
    public OrderItemNotFoundException() {
    	
    }
public OrderItemNotFoundException(String msg) {
    	super(msg);
    }
}
