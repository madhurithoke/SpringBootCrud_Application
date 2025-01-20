package com.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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
import com.project.servicei.CategoryServiceI;
@RestController
@RequestMapping("/api/categories")
public class CategoryController {

	@Autowired
	private CategoryServiceI ci;
	@PostMapping
	public Category createCategory(@RequestBody Category c) {
		return ci.createCategory(c);
	}
	
	@PutMapping("/{cid}")
	public Category updateCategory(@PathVariable int cid, @RequestBody Category c) {
	    return ci.updateCategory(cid, c);
	}

	@DeleteMapping("/{cid}")
	public void deleteCategory(@PathVariable int cid) {
		ci.deleteCategory(cid);
	}
	
	@GetMapping("/{cid}")
	public Category getcategoryById(@PathVariable int cid) {
		return ci.getCategoryById(cid);
	 }
	
	@GetMapping
	public Page<Category> getAllcategory(@RequestParam(defaultValue="0")int page,@RequestParam(defaultValue="10")int size){
		return ci.getAllCategories(PageRequest.of(page,size));
	}
	
}
