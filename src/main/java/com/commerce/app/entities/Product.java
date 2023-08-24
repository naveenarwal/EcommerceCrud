package com.commerce.app.entities;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
   private Integer pId;
	
	private String pName;
	
	private String pImage;
	
	@ManyToOne
	private GroupVarient groupVarient;
	
	private Integer price;

	
	
	private Date createdDate;
	
	private String description;
   
   @ManyToOne
   private User user;
}
