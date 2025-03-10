package com.proj.nimap_Spring.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

import com.proj.nimap_Spring.dto.Category;
import com.proj.nimap_Spring.dto.Product;
import com.proj.nimap_Spring.repository.Category_Repository;
import com.proj.nimap_Spring.repository.Product_Repository;

@Repository
public class Category_Product_Dao 
{
	@Autowired 
	private Category_Repository category_Repository;
	
	@Autowired
	private Product_Repository product_Repository;
	
	//save or create
	public Category saveCategory(Category category) {
		return category_Repository.save(category);
	}
	//find by id
	public Optional<Category> getCategoryById(int id)
	{
		return category_Repository.findById(id);
	}
	//find all
//	public List<Category> getAllCategories(Pageable pageable) {
//		Pageable p = PageRequest.of(pagenumber, pagesize);
//		Page<Category> page =category_Repository.findAll(pageable);
//		return page.getContent();
//	}
	
	//update
	public Category updateCategory(Category category, int id) {
		Optional<Category> catOptional=category_Repository.findById(id);
		category.setId(id);
		return category_Repository.save(category);
	}
	//delete
	public void deleteCategory(int id) {
		category_Repository.deleteById(id);
	}
	public boolean existsById(int id) {
	    return category_Repository.existsById(id);
	}

	
	//PRODUCT CRUD OPERATIONS
	
	//save or create
	public Product saveProduct(Product product) {
		if (product.getCategory() == null || product.getCategory().getId() == 0) {
	        throw new RuntimeException("Category ID must be provided!");
	    }
	    
	    // Fetch the category from the database
	    Category category = category_Repository.findById(product.getCategory().getId())
	                          .orElseThrow(() -> new RuntimeException("Category not found"));

	    product.setCategory(category); // Associate product with fetched category
	    return product_Repository.save(product);

	}
	//get all product
	public List<Product> getAllProduct(int pagenumber,int pagesize) {
		Pageable p = PageRequest.of(pagenumber, pagesize);
		Page<Product> page1 =product_Repository.findAll(p);
		return page1.getContent();
	}
	//find by id
	public Optional<Product> findById(int id) {
		return product_Repository.findById(id);
	}
	//update
	public Product updateproduct(Product product, int id) {
		Optional<Product> proOptional=product_Repository.findById(id);
		product.setId(id);
		return product_Repository.save(product);
	}
	//delete
	public void deleteProductById(int id) {
		product_Repository.deleteById(id);
	}
//	public Page<Category> getAllCategories(Pageable pageable) {
//		// TODO Auto-generated method stub
//		return null;
//	}
}
