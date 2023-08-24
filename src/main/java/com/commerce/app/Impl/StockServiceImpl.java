package com.commerce.app.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.commerce.app.Repository.IStockRepository;
import com.commerce.app.Service.IStockService;
import com.commerce.app.entities.Stock;

@Service
public class StockServiceImpl implements IStockService {

	@Autowired
	private IStockRepository stockRepo;
	
	@Override
	public Stock addStock(Stock Stock) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Stock updateStock(Stock Stock) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteStock(Integer id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Stock getStock(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Stock> getStocks() {
		// TODO Auto-generated method stub
		return null;
	}

}
