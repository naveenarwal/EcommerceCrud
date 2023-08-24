package com.commerce.app.controller;

import java.util.ArrayList;
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

import com.commerce.app.Service.ICartService;
import com.commerce.app.Service.IOrderService;
import com.commerce.app.entities.Cart;
import com.commerce.app.entities.CartItem;
import com.commerce.app.entities.Order;
import com.commerce.app.entities.OrderItem;


@RestController
@RequestMapping("/order")
public class OrderController {
    
	@Autowired
	private IOrderService orderSerivce;
	
	@Autowired
	private ICartService cartService;
	
	@PostMapping("/")
	public ResponseEntity<Order> addOrder(@RequestBody Order order){
		ResponseEntity<Order> response = new ResponseEntity<Order>(this.orderSerivce.addOrder(order),HttpStatus.CREATED);
		return response;
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Order> getOrderById(@PathVariable Integer id){
		ResponseEntity<Order> response = new ResponseEntity<Order>(this.orderSerivce.getOrder(id),HttpStatus.OK);
		return response;
	}
	

	@GetMapping("/")
	public ResponseEntity<List<Order>> getOrders(){
		ResponseEntity<List<Order>> response = new ResponseEntity<List<Order>>(this.orderSerivce.getOrders(),HttpStatus.OK);
		return response;
	}
	
	@PutMapping("/")
	public ResponseEntity<Order> updateOrder(@RequestBody Order order){
		ResponseEntity<Order> response = new ResponseEntity<Order>(this.orderSerivce.updateOrder(order),HttpStatus.OK);
		return response;
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteOrder(@PathVariable Integer id){
		ResponseEntity<String> response = new ResponseEntity<String>(this.orderSerivce.deleteOrder(id)+"ORder deleted Order id +"+id,HttpStatus.OK);
		return response;
	}
	
	@PostMapping("/orderCart/{id}")
	public ResponseEntity<Order> orderFromCart(@PathVariable Integer id,@RequestBody Order order){
		Cart cart = this.cartService.getCart(id);
		List<CartItem> cartItems = cart.getCartItems();
		List<OrderItem> orderItems = new ArrayList();
        cartItems.forEach(c->{
             OrderItem ot = new OrderItem();
             ot.setPrice(c.getProduct().getPrice());
             ot.setProduct(c.getProduct());
             ot.setGroupVarient(c.getGroupVarient());
             orderItems.add(ot);
        });
        order.setOrderItems(orderItems);
        return new ResponseEntity<Order>(this.orderSerivce.addOrder(order),HttpStatus.OK);
	}
	
	
	
}
