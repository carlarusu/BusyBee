package com.project.persistence_layer.repository;

import com.project.business_layer.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User,Integer> {

    User findByUsername(String username);
    User findById(int id);

}
