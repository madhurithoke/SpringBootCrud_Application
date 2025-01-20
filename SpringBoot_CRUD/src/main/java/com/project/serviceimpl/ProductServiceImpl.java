package com.project.serviceimpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.project.model.Category;
import com.project.model.Product;
import com.project.repository.CategoryRepository;
import com.project.repository.ProductRepository;
import com.project.servicei.ProductServiceI;

@Service
public class ProductServiceImpl implements ProductServiceI {
	@Autowired
	ProductRepository pr;
	@Autowired
	CategoryRepository cr;

	@Override

		public Product createProduct(Product p) {
	        
		       
            int cid = p.getC().getCid();           
            Category c = cr.findById(cid)
                    .orElseThrow(() -> new RuntimeException("Category not found with ID: " + cid));
            p.setC(c); 
           return pr.save(p);
    }
	

	@Override
	public Product updateProduct(int pid, Product p) {
		Optional<Product> presentProduct = pr.findById(pid);
		if(presentProduct.isPresent()) {
		Product updatedProduct = presentProduct.get();
		updatedProduct.setPname(p.getPname());
		updatedProduct.setC(p.getC());
		return pr.save(updatedProduct);
	  }else {
		  throw new RuntimeException("Product with this Id is Not Found: "+pid);  
	  }
	}

	@Override
	public Product getProductById(int pid) {
		return pr.findById(pid)
	 			.orElseThrow(()-> new RuntimeException("Product with this Id is Not Found: " + pid));
	}

	@Override
	public void deleteProduct(int pid) {
		pr.deleteById(pid);	
		
	}

	@Override
	public Page<Product> getAllProducts(Pageable page) {
		return pr.findAll(page);
		}
	
}
