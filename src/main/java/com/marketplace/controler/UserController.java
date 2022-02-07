package com.marketplace.controler;



import com.marketplace.model.User;
import com.marketplace.service.UserCrudServicesImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {

    @Autowired
    private UserCrudServicesImp userCrudServiceImp;

    @PostMapping("/add")
    public String add(@RequestBody User user){
        userCrudServiceImp.save(user);
        return "New User added";
    }

    @GetMapping("/all")
    public List<User> getAll(){
        return userCrudServiceImp.getAll();
    }

}
