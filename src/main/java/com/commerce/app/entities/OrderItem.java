package com.commerce.app.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderItem {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
  private Integer otId;
  
  private Integer price;
  
  @ManyToOne
  @JoinColumn(name="order_id")
  private Order order;
  
  @ManyToOne
  private Product product;
  
  @ManyToOne
  private GroupVarient groupVarient;
  
  
}
