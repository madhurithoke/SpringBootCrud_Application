package com.project.servicei;



import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.project.model.Category;

public interface CategoryServiceI {
	
	Category createCategory(Category c);
	Category updateCategory(int cid,Category c);
	Category getCategoryById(int cid);
	void deleteCategory(int cid);
	Page<Category> getAllCategories(Pageable page);
	

}