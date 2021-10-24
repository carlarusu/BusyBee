package com.project.persistence_layer.repository;

import com.project.business_layer.entity.Board;
import com.project.business_layer.entity.Card;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;


public interface CardRepository extends JpaRepository<Card,Integer> {
    Card findByName(String name);
    Card findById(int id);
    Card findByIdAndBoardFK(int id, Board boardFK);
    ArrayList<Card> findAllByBoardFK(Board boardFK);
}
