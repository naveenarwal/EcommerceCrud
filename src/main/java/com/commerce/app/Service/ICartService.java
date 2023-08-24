package com.commerce.app.Service;

import java.util.List;

import com.commerce.app.entities.Cart;

public interface ICartService {
public Cart addCart(Cart cart);
    
    public Cart updateCart(Cart cart);
    
    public boolean deleteCart(Integer id);
    
    public Cart getCart(Integer id);
    
    public List<Cart> getCarts();

	public Cart addCartItemToCart(Integer id, Integer cid);
}
