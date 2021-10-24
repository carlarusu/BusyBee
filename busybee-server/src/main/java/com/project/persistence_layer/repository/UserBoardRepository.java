package com.project.persistence_layer.repository;

import com.project.business_layer.entity.Board;
import com.project.business_layer.entity.User;
import com.project.business_layer.entity.UserBoard;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;


public interface UserBoardRepository extends JpaRepository<UserBoard,Integer> {
    ArrayList<UserBoard> findAllByUserFK(User userFK);
    ArrayList<UserBoard> findAllByBoardFK(Board boardFK);
    UserBoard findByUserFKAndBoardFK(User userFK, Board boardFK);
    UserBoard findById(int id);
    ArrayList<UserBoard> findAllByUserFK_Id(int userFK_id);
}
