package com.marketplace.service;

import com.marketplace.model.Product;
import com.marketplace.repository.ProductRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductCrudServiceImp implements GenericCrudService<Product,Integer> {

    @Autowired
    private ProductRepo productRepo;
    @Override
    public Product save(Product product){
        return productRepo.save(product);
    }

    @Override
    public List<Product> getAll() {
        return productRepo.findAll();
    }

    @Override
    public void deleteId(Integer id) {
        productRepo.deleteById(id);
    }

    @Override
    public Product get(Integer id){
        return productRepo.findById(id).get();
    }

    @Override
    public Product update(Product product, Integer id) {
        if(!productRepo.existsById(id)) return null;
        product.setId(id);
        return productRepo.save(product);
    }


}
