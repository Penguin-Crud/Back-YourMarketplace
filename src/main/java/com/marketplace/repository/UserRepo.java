package com.marketplace.repository;

import com.marketplace.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository <User,Integer> {
}
