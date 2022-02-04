package com.marketplace.controler;

import com.marketplace.model.Product;
import com.marketplace.service.ProductCrudServiceImp;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
@CrossOrigin
public class ProductController {

    @Autowired
    private ProductCrudServiceImp productCrudServiceImp;

    @PostMapping("/add")
    public String add(@RequestBody Product product){
        productCrudServiceImp.save(product);
        return "New Product added";
    }

    @GetMapping("/all")
    public List<Product> getAll(){
        return productCrudServiceImp.getAll();
    }


}
