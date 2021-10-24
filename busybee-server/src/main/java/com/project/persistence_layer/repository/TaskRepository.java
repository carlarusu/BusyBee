package com.project.persistence_layer.repository;

import com.project.business_layer.entity.Card;
import com.project.business_layer.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;


public interface TaskRepository extends JpaRepository<Task,Integer> {
    Task findById(int id);
    Task findByDescription(String description);
    Task findByDescriptionAndCardFK(String description, Card cardFK);
    Task findByIdAndCardFK(int id, Card cardFK);
    ArrayList<Task> findAllByCardFK(Card cardFK);
    void deleteAllByCardFK_Id(int cardFK_id);
}
