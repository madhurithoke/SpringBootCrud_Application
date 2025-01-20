package com.project.servicei;



import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.project.model.Product;

public interface ProductServiceI {
	

	Product createProduct(Product p);
	Product updateProduct(int pid,Product p);
	Product getProductById(int pid);
	void deleteProduct(int pid);
	Page<Product> getAllProducts(Pageable page);

}
