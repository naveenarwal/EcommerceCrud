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
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "`order`")
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer oId;
	
	private String name;
	
	private String address;
	
	private String city;
	
	private String status;
	
	private String comment;
	
	private Integer totalPrice;
	
	private String type;
	
	private Date createdDate=new Date();
	
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JoinColumn(name="order_id")
	@JsonIgnoreProperties("order")
	private List<OrderItem> orderItems;
	
	
	@ManyToOne
	private User user;
	
}
