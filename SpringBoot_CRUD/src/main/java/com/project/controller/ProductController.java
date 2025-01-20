package com.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.model.Category;
import com.project.model.Product;
import com.project.servicei.ProductServiceI;

@RestController
@RequestMapping("/api/products")
public class ProductController {
	
	@Autowired
	private ProductServiceI pi;
	
	@PostMapping
		public ResponseEntity<Product> createProduct(@RequestBody Product p) {
	        try {
	            // Calling the service method to create the product
	            Product createdProduct = pi.createProduct(p);

	            // Returning a successful response with the created product
	            return new ResponseEntity<>(createdProduct, HttpStatus.CREATED);
	        } catch (RuntimeException ex) {
	            // Handle runtime exceptions
	            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
	        } catch (Exception ex) {
	            // Handle any other unexpected exceptions
	            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	        }
	    }
	
	
	@PutMapping("/{pid}")
	public Product updateProduct(@PathVariable int pid, @RequestBody Product p) {
	    return pi.updateProduct(pid, p);
	}

	@DeleteMapping("/{pid}")
	public void deleteProduct(@PathVariable int pid) {
		pi.deleteProduct(pid);
	}
	
	@GetMapping("/{pid}")
	public Product getproductById(@PathVariable int pid) {
		return pi.getProductById(pid);
	}
	
	@GetMapping
	public Page<Product> getAllProduct(@RequestParam(defaultValue="0")int page,@RequestParam(defaultValue="10")int size){
		return pi.getAllProducts(PageRequest.of(page,size));
	}

}
