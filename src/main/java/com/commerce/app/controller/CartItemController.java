package com.commerce.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.commerce.app.Service.ICartItemService;
import com.commerce.app.entities.CartItem;
import com.commerce.app.exception.CartItemNotFoundException;

@RestController
@RequestMapping("/cartItem")
public class CartItemController {

	@Autowired
	private ICartItemService cartItemService;
	
	@PostMapping("/")
	public ResponseEntity<CartItem> addCartItem(@RequestBody CartItem cartItem){
		ResponseEntity<CartItem> response = new ResponseEntity<CartItem>(this.cartItemService.addCartItem(cartItem),HttpStatus.CREATED);
				return response;
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<CartItem> getCartItem(@PathVariable Integer id){
		ResponseEntity<CartItem> response = new ResponseEntity<CartItem>(this.cartItemService.getCartItem(id),HttpStatus.OK);
				return response;
	}
	
	@DeleteMapping("/{cid}/{pid}")
	public ResponseEntity<String> removeProductFromCart(@PathVariable Integer cid,@PathVariable  Integer pid){
		  
		try {
			
			if(this.cartItemService.removeProductFromCart(cid, pid)) {
				return new ResponseEntity<String>("Item Removed ",HttpStatus.ACCEPTED); 
			  }
		}catch(CartItemNotFoundException c) {
			
		}
		throw new CartItemNotFoundException("Product Not Found ");
	}
	
	@PutMapping("/update/")
	public ResponseEntity<CartItem> updateCartItem(@RequestBody CartItem cartItem){
		return new ResponseEntity<CartItem>(this.cartItemService.updateCartItem(cartItem),HttpStatus.ACCEPTED);
	}
	
}
