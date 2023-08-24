package com.commerce.app.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.commerce.app.Repository.IOrderRepository;
import com.commerce.app.Repository.IUserRepositoty;
import com.commerce.app.Service.IOrderService;
import com.commerce.app.entities.Order;
import com.commerce.app.exception.OrderNotFoundException;

@Service
public class OrderServiceImpl implements IOrderService{


	@Autowired
	private IOrderRepository orderRepo;
	
	@Override
	public Order addOrder(Order order) {
		// TODO Auto-generated method stub
		return this.orderRepo.save(order);
	}

	@Override
	public Order updateOrder(Order order) {
		// TODO Auto-generated method stub
		if(this.orderRepo.existsById(order.getOId())) {
			return this.orderRepo.save(order);
		}else
		throw new OrderNotFoundException("Order not found with Id : "+order.getOId());
		
	}

	@Override
	public boolean deleteOrder(Integer id) {
		// TODO Auto-generated method stub
		if(this.orderRepo.existsById(id)) {
			this.orderRepo.deleteById(id);
			return true;
		}
		throw new OrderNotFoundException("Order not found with Id : "+id);
		
	}

	@Override
	public Order getOrder(Integer id) {
		// TODO Auto-generated method stub
		Optional<Order> findById = this.orderRepo.findById(id);
		 if(findById.isPresent()) 
			  return findById.get();
			 
		 throw new OrderNotFoundException("Order not found with Id : "+id);
	}

	@Override
	public List<Order> getOrders() {
		// TODO Auto-generated method stub
		return this.orderRepo.findAll();
	}

}
