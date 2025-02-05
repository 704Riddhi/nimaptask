package com.proj.nimap_Spring.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.proj.nimap_Spring.dao.Category_Product_Dao;
import com.proj.nimap_Spring.dto.Product;
import com.proj.nimap_Spring.repository.Product_Repository;

@Service
public class Product_Services 
{
	@Autowired 
	private Category_Product_Dao dao;

    public List<Product> getAllProducts(int pageNumber,int pageSize) {
        return dao.getAllProduct(pageNumber,pageSize);
    }

    public Optional<Product> getProductById(int id) {
        return dao.findById(id);
    }

    public Product createProduct(Product product) {
        return dao.saveProduct(product);
    }

    public Product updateProduct(int id, Product product) {
        if (dao.existsById(id)) {
            product.setId(id);
            return dao.saveProduct(product);
        }
        return null;
    }

    public void deleteProduct(int id) {
    	dao.deleteProductById(id);
    }

	public Page<Product> getAllProduct(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}
}


