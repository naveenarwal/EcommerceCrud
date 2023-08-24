package com.commerce.app.Service;

import java.util.List;

import com.commerce.app.entities.Stock;

public interface IStockService {
	public Stock addStock(Stock Stock);
    
    public Stock updateStock(Stock Stock);
    
    public boolean deleteStock(Integer id);
    
    public Stock getStock(Integer id);
    
    public List<Stock> getStocks();
}
