package com.marketplace.controler;


import com.marketplace.model.User;
import com.marketplace.service.UserCrudServicesImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {

    @Autowired
    private UserCrudServicesImp userCrudServiceImplem;

    @PostMapping("/add")
    public String add(@RequestBody User user){
        userCrudServiceImplem.save(user);
        return "New penguin added";
    }


}
