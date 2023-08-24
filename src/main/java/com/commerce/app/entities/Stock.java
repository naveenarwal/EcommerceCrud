package com.commerce.app.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Stock {

	@Id
	private Integer id;
	
	private String productName;
	
	private String varientName;
	
	private Integer stock;
}
