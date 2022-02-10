package com.marketplace.controler;

import com.marketplace.model.Product;
import com.marketplace.service.ProductCrudServiceImp;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@CrossOrigin
public class ProductController {

    @Autowired
    private ProductCrudServiceImp productCrudServiceImp;

    @PostMapping
    public Product add(@RequestBody Product product){
        return productCrudServiceImp.save(product);
    }

    @GetMapping
    public List<Product> getAll(){
        return productCrudServiceImp.getAll();
    }

    @GetMapping("/{id}")
    public Product getById(@PathVariable int id){
        return productCrudServiceImp.get(id);
    }

    @DeleteMapping("/{id}")
    public void deleteId(@PathVariable int id) {productCrudServiceImp.deleteId(id); }

}
