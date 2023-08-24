package com.commerce.app.Service;

import java.util.List;

import com.commerce.app.entities.Product;

public interface IProductService {
	public Product addProduct(Product Product);
    
    public Product updateProduct(Product Product);
    
    public boolean deleteProduct(Integer id);
    
    public Product getProduct(Integer id);
    
    public List<Product> getProducts();
}
