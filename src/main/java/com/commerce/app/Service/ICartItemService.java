package com.commerce.app.Service;

import java.util.List;

import com.commerce.app.entities.CartItem;

public interface ICartItemService {
public CartItem addCartItem(CartItem cartItem);
    
    public CartItem updateCartItem(CartItem cartItem);
    
    public boolean deleteCartItem(Integer id);
    
    public CartItem getCartItem(Integer id);
    
    public List<CartItem> getCartItem();
    
    public boolean removeProductFromCart(Integer pid,Integer cid);
}
