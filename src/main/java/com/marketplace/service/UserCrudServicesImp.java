package com.marketplace.service;

import com.marketplace.model.User;
import com.marketplace.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserCrudServicesImp implements GenericCrudService<User,Integer> {

    @Autowired
    private UserRepo userRepo;
    @Override
    public User save(User user){
        return userRepo.save(user);
    }

    @Override
    public List<User> getAll() {
        return userRepo.findAll();
    }

    @Override
    public void deleteId(Integer id) {

    }

    @Override
    public User get(Integer id){
        return userRepo.findById(id).get();
    }

    @Override
    public User update(User user, Integer id) {
        return null;
    }


}
