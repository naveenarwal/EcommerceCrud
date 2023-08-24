package com.commerce.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.commerce.app.Service.IProductService;
import com.commerce.app.entities.Product;

@RestController
@RequestMapping("/product")
public class ProductController {
   @Autowired
   private IProductService productService;
   
   @PostMapping("/")
   public ResponseEntity<Product> addProduct(@RequestBody Product product){
	   ResponseEntity<Product> response = new ResponseEntity<Product>(this.productService.addProduct(product),HttpStatus.CREATED);
	   return response;
   }
   
   @PutMapping("/")
   public ResponseEntity<Product> updateProduct(@RequestBody Product product){
	   ResponseEntity<Product> response = new ResponseEntity<Product>(this.productService.updateProduct(product),HttpStatus.OK);
	   return response;
   }
   
   @DeleteMapping("/{id}")
   public ResponseEntity<String> deleteProduct(@PathVariable Integer id){
	   ResponseEntity<String> response = new ResponseEntity<String>(this.productService.deleteProduct(id)+"Product deleted",HttpStatus.OK);
	   return response;
   }
   
   @GetMapping("/")
   public ResponseEntity<List<Product>> getAllProducts(){
	   ResponseEntity<List<Product>> response = new ResponseEntity<List<Product>>(this.productService.getProducts(),HttpStatus.CREATED);
	   return response;
   }
   
   @GetMapping("/{id}")
   public ResponseEntity<Product> getProduct(@PathVariable Integer id){
	   ResponseEntity<Product> response = new ResponseEntity<Product>(this.productService.getProduct(id),HttpStatus.OK);
	   return response;
   }
   
}
