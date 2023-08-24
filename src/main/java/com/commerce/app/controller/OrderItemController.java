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

import com.commerce.app.Service.IOrderItemService;
import com.commerce.app.Service.IOrderService;
import com.commerce.app.entities.Order;
import com.commerce.app.entities.OrderItem;

@RestController
@RequestMapping("/orderItem")
public class OrderItemController {
    
	@Autowired
	private IOrderItemService orderItemSerivce;
	
	@PostMapping("/")
	public ResponseEntity<OrderItem> addOrderItem(@RequestBody OrderItem order){
		ResponseEntity<OrderItem> response = new ResponseEntity<OrderItem>(this.orderItemSerivce.addOrderItem(order),HttpStatus.CREATED);
		return response;
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<OrderItem> getOrderItemById(@PathVariable Integer id){
		ResponseEntity<OrderItem> response = new ResponseEntity<OrderItem>(this.orderItemSerivce.getOrderItem(id),HttpStatus.OK);
		return response;
	}
	

	@GetMapping("/")
	public ResponseEntity<List<OrderItem>> getOrderItem(){
		ResponseEntity<List<OrderItem>> response = new ResponseEntity<List<OrderItem>>(this.orderItemSerivce.getOrderItems(),HttpStatus.OK);
		return response;
	}
	
	@PutMapping("/")
	public ResponseEntity<OrderItem> updateOrderItem(@RequestBody OrderItem order){
		ResponseEntity<OrderItem> response = new ResponseEntity<OrderItem>(this.orderItemSerivce.updateOrderItem(order),HttpStatus.OK);
		return response;
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteOrderItem(@PathVariable Integer id){
		ResponseEntity<String> response = new ResponseEntity<String>(this.orderItemSerivce.deleteOrderItem(id)+"ORder deleted Order id +"+id,HttpStatus.OK);
		return response;
	}
	
	@GetMapping("/order/{id}")
	public ResponseEntity<List<OrderItem>> getOrderItemByOrderId(@PathVariable Integer id){
		ResponseEntity<List<OrderItem>> response = new ResponseEntity<List<OrderItem>>(this.orderItemSerivce.getOrderItemByOrder(id),HttpStatus.OK);
		return response;
	}
	
	
	

	
}
