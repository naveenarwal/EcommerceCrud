package com.commerce.app.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.commerce.app.entities.Cart;
import com.commerce.app.entities.Stock;

public interface ICartRepository extends JpaRepository<Cart, Integer>{

}
