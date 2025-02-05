package com.proj.nimap_Spring.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "product") 
public class Product 
{
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY  )
	private int id;
	private String product;
	private double price;
	@ManyToOne
	@JoinColumn(name="category_id",nullable = false)
	@JsonBackReference
	private Category category;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getProduct() {
		return product;
	}
	public void setProduct(String product) {
		this.product = product;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	

	public Category getCategory() {
		return category;
	}
	
 
	public void setCategory(Category category) {
		this.category = category;
	}
	
	
}
