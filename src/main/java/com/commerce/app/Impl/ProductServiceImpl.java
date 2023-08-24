package com.commerce.app.Impl;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.commerce.app.Repository.IProductRepository;
import com.commerce.app.Repository.IUserRepositoty;
import com.commerce.app.Service.IProductService;
import com.commerce.app.entities.Product;
import com.commerce.app.exception.ProductNotFoundException;
import com.commerce.app.exception.UserNotFoundException;

@Service
public class ProductServiceImpl implements IProductService {

	@Autowired
	private IProductRepository productRepo;
	
	@Override
	public Product addProduct(Product product) {
		// TODO Auto-generated method stub
		product.setCreatedDate(new Date());
		return this.productRepo.save(product);
	}

	@Override
	public Product updateProduct(Product product) {
		// TODO Auto-generated method stub
		if(this.productRepo.existsById(product.getPId()))
			return this.productRepo.save(product);
		throw new ProductNotFoundException("Product id is null");
		    
		
	}

	@Override
	public boolean deleteProduct(Integer id) {
		// TODO Auto-generated method stub
		this.productRepo.deleteById(id);
		return false;
	}

	@Override
	public Product getProduct(Integer id) {
		// TODO Auto-generated method stub
		Optional<Product> product = this.productRepo.findById(id);
		if(product.isPresent())
			return product.get();
		throw new ProductNotFoundException("Product not found " + id);
	}

	@Override
	public List<Product> getProducts() {
		// TODO Auto-generated method stub
		return this.productRepo.findAll();
	}

}
