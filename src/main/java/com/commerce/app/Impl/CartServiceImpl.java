package com.commerce.app.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.commerce.app.Repository.ICartItemRepository;
import com.commerce.app.Repository.ICartRepository;
import com.commerce.app.Service.ICartService;
import com.commerce.app.entities.Cart;
import com.commerce.app.entities.CartItem;
import com.commerce.app.entities.Product;
import com.commerce.app.exception.CartNotFoundException;

@Service
public class CartServiceImpl implements ICartService{

	@Autowired
	private ICartRepository cartRepo;
	
	@Autowired
	private ICartItemRepository cartItemRepo;
	
	@Override
	public Cart addCart(Cart cart) {
		// TODO Auto-generated method stub
		return this.cartRepo.save(cart);
	}

	@Override
	public Cart updateCart(Cart cart) {
		// TODO Auto-generated method stub
System.out.println(this.cartRepo.save(cart));
		if(this.cartRepo.existsById(cart.getCId()))
			return this.cartRepo.save(cart);
		throw new CartNotFoundException("Cart Not Fonund "+cart.getCId());
		
	}

	@Override
	public boolean deleteCart(Integer id) {
		// TODO Auto-generated method stub
		if(this.cartRepo.existsById(id)) {
			this.cartRepo.deleteById(id);
			return true;
		}
		throw new CartNotFoundException("Cart Not Fonund "+id);
	}

	@Override
	public Cart getCart(Integer id) {
		// TODO Auto-generated method stub
		Optional<Cart> cart = this.cartRepo.findById(id);
		if(cart.isPresent())
			return cart.get();
		throw new CartNotFoundException("Cart Not Fonund "+id);
	}

	@Override
	public List<Cart> getCarts() {
		// TODO Auto-generated method stub
		return this.cartRepo.findAll();
	}

	@Override
	public Cart addCartItemToCart(Integer id, Integer cid) {
		// TODO Auto-generated method stub
	   Optional<Cart> cart = this.cartRepo.findById(id);
	   Optional<CartItem> cartItem = this.cartItemRepo.findById(cid);
	   System.out.println(cartItem.get()+" jkkl ");
	   Product pro=cartItem.get().getProduct();
	   if(cart.isPresent()) {
		    
		   
		   CartItem cartI = this.cartItemRepo.findByCartAndProduct(cart.get(),pro );
		   if(cartI!=null) {
		   cartI.setQuantity(cartI.getQuantity()+1);
		   this.cartItemRepo.save(cartI);
		   }else
		   {
			   List<CartItem> cartItems = cart.get().getCartItems();
			   cartItems.add(cartItem.get());
			   this.cartRepo.save(cart.get());
		   }
	   }
	   return cart.get();
	}
 
	
	
}
