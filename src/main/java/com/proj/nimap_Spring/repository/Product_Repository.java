package com.proj.nimap_Spring.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.proj.nimap_Spring.dto.Product;

public interface Product_Repository extends JpaRepository<Product, Integer> 
{
//	Page<Product> findAll(Pageable pageable);

}
