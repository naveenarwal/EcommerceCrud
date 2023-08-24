package com.commerce.app.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.commerce.app.entities.Order;
import com.commerce.app.entities.OrderItem;
import com.commerce.app.entities.Stock;

public interface IOrderItemRepository extends JpaRepository<OrderItem, Integer>{
  
	public List<OrderItem> findByOrder(Order order);
}
