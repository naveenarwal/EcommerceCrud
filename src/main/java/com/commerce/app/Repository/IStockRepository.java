package com.commerce.app.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.commerce.app.entities.Stock;

public interface IStockRepository extends JpaRepository<Stock, Integer>{

}
