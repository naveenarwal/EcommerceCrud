package com.commerce.app.controller;

import java.util.List;

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
import com.commerce.app.Service.ICartService;
import com.commerce.app.entities.Cart;
import com.commerce.app.entities.CartItem;

@RestController
@RequestMapping("/cart")
public class CartController {

	@Autowired
	private ICartService cartService;
	
	@Autowired
	private ICartItemService cartItemService;
	
	@PostMapping("/")
	public ResponseEntity<Cart>  addCart(@RequestBody Cart cart){
		ResponseEntity<Cart> response = new ResponseEntity<Cart>(this.cartService.addCart(cart),HttpStatus.CREATED);
		return  response;
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Cart> getCart(@PathVariable Integer id){
		ResponseEntity<Cart> response = new ResponseEntity<Cart>(this.cartService.getCart(id),HttpStatus.OK);
		return response;
	}
	
	@GetMapping("/")
	public ResponseEntity<List<Cart>> getAllCart(){
				ResponseEntity<List<Cart>> response = new ResponseEntity<List<Cart>>(this.cartService.getCarts(),HttpStatus.OK);
				return response;
	}
	
	@GetMapping("/cart-item/{id}")
	public ResponseEntity<List<CartItem>> getCartItemById(@PathVariable Integer id){
		Cart cart = this.cartService.getCart(id);
		ResponseEntity<List<CartItem>> response = new ResponseEntity<List<CartItem>>(cart.getCartItems(),HttpStatus.OK);
		return response;
	}
	
	@PostMapping("/addCartItem/{id}/{cid}")
	public ResponseEntity<Cart> addCartItemToCart(@PathVariable Integer id,@PathVariable Integer cid){

		
		ResponseEntity<Cart> response = new ResponseEntity<Cart>(this.cartService.addCartItemToCart(id, cid),HttpStatus.CREATED);
		return  response;
	}
	
	@PutMapping("/")
	public ResponseEntity<Cart>  updateCart(@RequestBody Cart cart){
		ResponseEntity<Cart> response = new ResponseEntity<Cart>(this.cartService.updateCart(cart),HttpStatus.CREATED);
		return  response;
	}
	
	@DeleteMapping("/product/{pid}/{cid}")
	public ResponseEntity<String> removeProductFromCart(@PathVariable("pid") Integer pid,@PathVariable("cid") Integer cid){
		 ResponseEntity<String> response = new ResponseEntity<String>(this.cartItemService.removeProductFromCart(pid, cid)+"Removed ",HttpStatus.OK);
		 return response;
	}
	
}
