package com.commerce.app.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.transaction.Transactional;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Cart {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer cId;
   
   @OneToOne
   @JoinColumn(name = "user_id")
   private User user;
   
   
   @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
   @JsonIgnoreProperties(value = {"cart"})
   @JoinColumn(name="cart_id")
   private List<CartItem> cartItems;
	
   
}

