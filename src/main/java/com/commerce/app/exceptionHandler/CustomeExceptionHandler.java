package com.commerce.app.exceptionHandler;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.commerce.app.exception.CartItemNotFoundException;
import com.commerce.app.exception.CartNotFoundException;
import com.commerce.app.exception.ErrorEntity;
import com.commerce.app.exception.OrderItemNotFoundException;
import com.commerce.app.exception.OrderNotFoundException;
import com.commerce.app.exception.ProductNotFoundException;
import com.commerce.app.exception.UserFoundException;
import com.commerce.app.exception.UserNotFoundException;

@RestControllerAdvice
public class CustomeExceptionHandler   {
   
	@ExceptionHandler(UserFoundException.class)
	public ResponseEntity<ErrorEntity> userNameMatched(UserFoundException us){	
		return new ResponseEntity<ErrorEntity>(new ErrorEntity(us.getMessage(),"500",new Date().toString(),"Exception occured in creating"),HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(CartNotFoundException.class)
	public ResponseEntity<ErrorEntity> CartNotFound(CartNotFoundException us){	
		return new ResponseEntity<ErrorEntity>(new ErrorEntity(us.getMessage(),"500",new Date().toString(),"Exception occured in creating"),HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(CartItemNotFoundException.class)
	public ResponseEntity<ErrorEntity> cartItemNotFound(CartItemNotFoundException us){	
		return new ResponseEntity<ErrorEntity>(new ErrorEntity(us.getMessage(),"500",new Date().toString(),"Exception occured in creating"),HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(ProductNotFoundException.class)
	public ResponseEntity<ErrorEntity> productNotFound(ProductNotFoundException us){	
		return new ResponseEntity<ErrorEntity>(new ErrorEntity(us.getMessage(),"500",new Date().toString(),"Exception occured in Removig"),HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(OrderNotFoundException.class)
	public ResponseEntity<ErrorEntity> orderNotFound(OrderNotFoundException us){	
		return new ResponseEntity<ErrorEntity>(new ErrorEntity(us.getMessage(),"500",new Date().toString(),"Exception occured in Process"),HttpStatus.INTERNAL_SERVER_ERROR);
	}
	@ExceptionHandler(OrderItemNotFoundException.class)
	public ResponseEntity<ErrorEntity> orderItemNotFound(OrderItemNotFoundException us){	
		return new ResponseEntity<ErrorEntity>(new ErrorEntity(us.getMessage(),"500",new Date().toString(),"Exception occured in Process"),HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
