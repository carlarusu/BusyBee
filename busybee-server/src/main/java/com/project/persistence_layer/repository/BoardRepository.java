package com.project.persistence_layer.repository;

import com.project.business_layer.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface BoardRepository extends JpaRepository<Board,Integer> {
    Board findByName(String name);
    Board findById(int id);
}
