package com.commerce.app.Service;

import java.util.List;

import com.commerce.app.entities.OrderItem;

public interface IOrderItemService {
	public OrderItem addOrderItem(OrderItem OrderItem);
    
    public OrderItem updateOrderItem(OrderItem OrderItem);
    
    public boolean deleteOrderItem(Integer id);
    
    public OrderItem getOrderItem(Integer id);
    
    public List<OrderItem> getOrderItems();
    public List<OrderItem> getOrderItemByOrder(Integer id);
    
}
