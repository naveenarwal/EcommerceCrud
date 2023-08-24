package com.commerce.app.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.commerce.app.entities.Product;
import com.commerce.app.entities.Stock;

public interface IProductRepository extends JpaRepository<Product, Integer> {

}
