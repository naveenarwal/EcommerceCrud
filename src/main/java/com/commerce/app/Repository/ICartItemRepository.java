package com.commerce.app.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.commerce.app.entities.Cart;
import com.commerce.app.entities.CartItem;
import com.commerce.app.entities.Product;
import com.commerce.app.entities.Stock;

public interface ICartItemRepository extends JpaRepository<CartItem, Integer> {
   public CartItem findByCartAndProduct(Cart cart,Product product);
   
//   @Query("Delete c from CartItem c where c.product.pId = :pid And c.cart.cId = :cid")
//   @Modifying
//   public Cart removeProductFromCart(@Param("pid") Integer pid,@Param("cid") Integer cid);
}
