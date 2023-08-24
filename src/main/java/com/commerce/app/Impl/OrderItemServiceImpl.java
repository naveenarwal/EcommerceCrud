package com.commerce.app.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.commerce.app.Repository.IOrderItemRepository;
import com.commerce.app.Repository.IUserRepositoty;
import com.commerce.app.Service.IOrderItemService;
import com.commerce.app.entities.Order;
import com.commerce.app.entities.OrderItem;
import com.commerce.app.exception.OrderItemNotFoundException;
import com.commerce.app.exception.OrderNotFoundException;

@Service
public class OrderItemServiceImpl  implements IOrderItemService{

	@Autowired
	private IOrderItemRepository orderItemRepo;

	@Override
	public OrderItem addOrderItem(OrderItem orderItem) {
		// TODO Auto-generated method stub
		return this.orderItemRepo.save(orderItem);
	}

	@Override
	public OrderItem updateOrderItem(OrderItem orderItem) {
		// TODO Auto-generated method stub
		if(this.orderItemRepo.existsById(orderItem.getOtId())) {
			return this.orderItemRepo.save(orderItem);
		}else
		throw new OrderItemNotFoundException("Order Item not found with Id : "+orderItem.getOtId());
		
	}

	@Override
	public boolean deleteOrderItem(Integer id) {
		// TODO Auto-generated method stub
		if(this.orderItemRepo.existsById(id)) {
			 this.orderItemRepo.deleteById(id);
			 return true;
		}else
		throw new OrderItemNotFoundException("Order Item not found with Id : "+id);
		
	}

	@Override
	public OrderItem getOrderItem(Integer id) {
		// TODO Auto-generated method stub
		Optional<OrderItem> findById = this.orderItemRepo.findById(id);
		 if(findById.isPresent()) 
			  return findById.get();
			 
		 throw new OrderItemNotFoundException("OrderItem not found with Id : "+id);
		
	}

	@Override
	public List<OrderItem> getOrderItems() {
		// TODO Auto-generated method stub
		return this.orderItemRepo.findAll();
	}
	@Override
	public List<OrderItem> getOrderItemByOrder(Integer id){
		Order order = new Order();
		order.setOId(id);
		return this.orderItemRepo.findByOrder(order);
	}
}
