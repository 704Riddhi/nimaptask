package com.proj.nimap_Spring.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.proj.nimap_Spring.dto.Category;

public interface Category_Repository extends JpaRepository<Category, Integer>
{
//	Page<Category> findAll(Pageable pageable);

}
