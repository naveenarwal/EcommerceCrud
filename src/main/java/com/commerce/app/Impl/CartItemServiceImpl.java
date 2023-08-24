package com.commerce.app.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.commerce.app.Repository.ICartItemRepository;
import com.commerce.app.Repository.ICartRepository;
import com.commerce.app.Service.ICartItemService;
import com.commerce.app.entities.Cart;
import com.commerce.app.entities.CartItem;
import com.commerce.app.entities.Product;
import com.commerce.app.exception.CartItemNotFoundException;
import com.commerce.app.exception.ProductNotFoundException;

@Service
public class CartItemServiceImpl implements ICartItemService {

	@Autowired
	private ICartItemRepository cartItemRepository;
	
	@Override
	public CartItem addCartItem(CartItem cartItem) {
		// TODO Auto-generated method stub
		return this.cartItemRepository.save(cartItem);
	}

	@Override
	public CartItem updateCartItem(CartItem cartItem) {
		// TODO Auto-generated method stub
		if(this.cartItemRepository.existsById(cartItem.getCId())) {
		return	this.cartItemRepository.save(cartItem);
		}
		throw new CartItemNotFoundException("Cart Item Not Found  Cannot be updated");
		
		
	}

	@Override
	public boolean deleteCartItem(Integer id) {
		// TODO Auto-generated method stub
		try {
         this.cartItemRepository.deleteById(id); 
		}catch(Exception e){
			throw new CartItemNotFoundException("Cart Item Not Found  Cannot be deleted");
		}
		return false;
	}

	@Override
	public CartItem getCartItem(Integer id) {
		// TODO Auto-generated method stub
		Optional<CartItem> cartItem = this.cartItemRepository.findById(id);
		if(cartItem.isPresent())
			return cartItem.get();
		throw new CartItemNotFoundException("Cart Item Not Found "+id);
	}

	@Override
	public List<CartItem> getCartItem() {
		// TODO Auto-generated method stub
		return this.cartItemRepository.findAll();
	}

	@Override
	public boolean removeProductFromCart(Integer pid, Integer cid) {
		// TODO Auto-generated method stub
		Cart cart = new Cart();
		cart.setCId(cid);
		Product product = new Product();
		product.setPId(pid);
		CartItem cartItem = this.cartItemRepository.findByCartAndProduct(cart,product );
		
		System.out.println(pid+" "+cid);
		
		if(cartItem!=null)
		{
			this.cartItemRepository.delete(cartItem);
			return true;
		}
		throw new ProductNotFoundException("Product Not Found  ProductID:- "+pid+" cartItemId:- "+cid);
	}

}
