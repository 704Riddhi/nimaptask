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

import com.proj.nimap_Spring.dao.Category_Product_Dao;
import com.proj.nimap_Spring.dto.Category;
import com.proj.nimap_Spring.dto.Product;
import com.proj.nimap_Spring.services.Product_Services;

@RestController

public class Product_Controller
{
	
	@Autowired
	private Product_Services product_services;
	//CREATE PRODUCT
		@PostMapping("api/products")
		public Product saveProduct(@RequestBody Product product) {
			return product_services.createProduct(product);
		}
		
//		GET ALL PRODUCT
//		@GetMapping("api/products/page")
//		public Page<Product> getAllProduct(
//				@RequestParam(value = "pagenumber",defaultValue="0", required=false)Integer pagenumber,
//				@RequestParam(value = "pagesize", defaultValue = "2",required = false)Integer pagesize
//				) {
//			Pageable pageable = PageRequest.of(pagenumber, pagesize);
//		    Page<Product> page = product_services.getAllProduct(pageable);
//		    return (Page<Product>) page.getContent();
//		}
		
		//GET BY ID
		@GetMapping("api/products/{id}")
		public Optional<Product> getProductById(@PathVariable("id") int id) {
			return product_services.getProductById(id);
		}
		
		//UPDATE PRODUCT BY ID
			@PutMapping("api/products/{id}")
			public Product updateProduct(@RequestBody Product products,@PathVariable("id") int id) {
				return product_services.updateProduct(id,products);

		}
			//DELETE BY ID
			@DeleteMapping("api/products/{id}")
			public void deleteProductById(@PathVariable int id) {
				product_services.deleteProduct(id);
			}
}
