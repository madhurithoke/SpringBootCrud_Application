package com.project.serviceimpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.project.model.Category;
import com.project.repository.CategoryRepository;
import com.project.servicei.CategoryServiceI;

@Service
public class CategoryServiceImpl implements CategoryServiceI{
  
	@Autowired
    CategoryRepository cr;
	

	@Override
	public Category createCategory(Category c) {
		
		return cr.save(c);
	}

	
	
	@Override
	public Category updateCategory(int cid, Category c) {
	    Optional<Category> presentCategory = cr.findById(cid);
	    if (presentCategory.isPresent()) {
	        Category updatedCategory = presentCategory.get();
	        updatedCategory.setCname(c.getCname());
	        updatedCategory.setProducts(c.getProducts());
	        return cr.save(updatedCategory);
	    } 
	    else {
	        throw new RuntimeException("Category Id is Not Found: " + cid);
	    }
	}

	@Override
	public Category getCategoryById(int cid){
		
		return cr.findById(cid)
	 			.orElseThrow(()-> new RuntimeException("Category Id is Not Found: " + cid));
	}

	@Override
	public void deleteCategory(int cid) {
		cr.deleteById(cid);	
	}

	@Override
	public Page<Category> getAllCategories(Pageable page) {
		
		return cr.findAll(page);
	} 
   
}
