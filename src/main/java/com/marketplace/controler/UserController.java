package com.marketplace.controler;



import com.marketplace.model.Product;
import com.marketplace.model.User;
import com.marketplace.service.ProductCrudServiceImp;
import com.marketplace.service.UserCrudServicesImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/users")
@CrossOrigin
public class UserController {

    @Autowired
    private UserCrudServicesImp userCrudServiceImp;
    @Autowired
    private ProductCrudServiceImp productCrudServiceImp;

    @PostMapping
    public User add(@RequestBody User user){
        return userCrudServiceImp.save(user);
    }
    @GetMapping("/{id}")
    public User one(@PathVariable int id){
        return userCrudServiceImp.get(id);
    }

    @GetMapping
    public List<User> getAll(){
        return userCrudServiceImp.getAll();
    }

    @GetMapping("/{id}/products")
    public Set<Product> getProduct(@PathVariable int id){
        var user = userCrudServiceImp.get(id);
        return user.getProducts();
    }

    @PostMapping("/{id}/products")
    public Product addProduct(@PathVariable int id, @RequestBody Product product){
        var user = userCrudServiceImp.get(id);

        product.setOwner(user);
        var addedProduct = productCrudServiceImp.save(product);
        var ownerProducts = user.getProducts();

        ownerProducts.add(addedProduct);
        user.setProducts(ownerProducts);
        userCrudServiceImp.save(user);
        return addedProduct;
    }

}
