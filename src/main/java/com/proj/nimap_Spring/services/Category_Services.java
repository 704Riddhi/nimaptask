package com.proj.nimap_Spring.services;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.proj.nimap_Spring.dao.Category_Product_Dao;
import com.proj.nimap_Spring.dto.Category;
import com.proj.nimap_Spring.repository.Category_Repository;

import jakarta.transaction.Transactional;

@Service
public class Category_Services 
{
	@Autowired
	private Category_Product_Dao dao;
	
	//save category
	 public Category createCategory(Category category) {
	        return dao.saveCategory(category);
	    }

//	 get all category
//	 public Page<Category> getAllCategories(Pageable pageable) {
//		    return (Page<Category>) dao.getAllCategories(pageable);
//		}
//	 public List<Category> getAllCategories(int pagenumber,int pagesize) {
//			Pageable p = PageRequest.of(pagenumber, pagesize);
//			Page<Category> page =dao.findAll(p);
//			return page.getContent();
//		}
    
    //get by id
       public Optional<Category> getCategoryById(int id) {
        return dao.getCategoryById(id);
    }

       //update by id
    public Category updateCategory(int id, Category category) {
        if (dao.existsById(id)) {
            category.setId(id);
            return dao.saveCategory(category);
        }
        return null;
    }

    //delete by id
    public void deleteCategory(int id) {
    	dao.deleteCategory(id);
    }

//	public Page<Category> getAllCategories(Pageable pageable) {
//		// TODO Auto-generated method stub
//		return null;
//	}
    
}
