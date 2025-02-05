package com.proj.nimap_Spring.controller;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.proj.nimap_Spring.dto.Category;
import com.proj.nimap_Spring.dto.Product;
import com.proj.nimap_Spring.services.Category_Services;

@RestController

public class Category_Controller 
{
	@Autowired
	private Category_Services category_Services;
	
	//CREATE CATEGORY
	@PostMapping("api/categories")
	public Category saveCatogery(@RequestBody Category category) {
		 return category_Services.createCategory(category);
	}
	//GET ALL CATEGORY
	
//	@GetMapping("api/categories/page")
//	 public Page<Category> getAllCategories(
//		        @RequestParam(value = "pagenumber", required = false) Integer pagenumber,
//		        @RequestParam(value = "pagesize", required = false) Integer pagesize
//		    ) {
//		        Pageable pageable = PageRequest.of(pagenumber, pagesize);
//		        return category_Services.getAllCategories(pageable);
//		    }
	


	//GET CATEGORY BY ID
	@GetMapping("api/categories/{id}")
	public Optional<Category> getById(@PathVariable("id")int id) {
		return category_Services.getCategoryById(id);
	}
	
	//UPDATE CATEGORY BY ID
	@PutMapping("api/categories/{id}")
	public Category updateCategory(@RequestBody Category category,@PathVariable("id") int id) {
		return category_Services.updateCategory(id,category);
	}
	//DELETE CATEGORY BY ID
	@DeleteMapping("api/categories/{id}")
	public void deleteById(@PathVariable("id") int id) {
		category_Services.deleteCategory(id);
	}
	
}
