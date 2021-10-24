package com.project.business_layer.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

@Entity
@Table
public class Card implements Serializable {

    @Id
    @GeneratedValue
    @Column(nullable = false,updatable = false)
    private int id;

    @ManyToOne
    @NotNull
    private Board boardFK;

    @NotNull
    private String name;

    @OneToMany(mappedBy = "cardFK")
    @JsonIgnore
    private List<Task> tasks;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Board getBoardFK() {
        return boardFK;
    }

    public void setBoardFK(Board boardFK) {
        this.boardFK = boardFK;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    @Override
    public String toString() {
        return "Card{" +
                "id=" + id +
                ", boardFK=" + boardFK +
                ", name='" + name + '\'' +
                ", tasks=" + tasks +
                '}';
    }
}
