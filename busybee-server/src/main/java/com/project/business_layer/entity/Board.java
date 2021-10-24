package com.project.business_layer.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

@Entity
@Table
public class Board implements Serializable {

    @Id
    @GeneratedValue
    @Column(nullable = false,updatable = false)
    private int id;

    @OneToMany(mappedBy = "boardFK")
    @JsonIgnore
    private List<UserBoard> userBoards;

    @NotNull
    @Column(unique = true)
    private String name;

    @OneToMany(mappedBy = "boardFK")
    @JsonIgnore
    private List<Card> cards;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<UserBoard> getUserBoards() {
        return userBoards;
    }

    public void setUserBoards(List<UserBoard> userBoards) {
        this.userBoards = userBoards;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Card> getCards() {
        return cards;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }

    @Override
    public String toString() {
        return "Board{" +
                "id=" + id +
                ", userBoards=" + userBoards +
                ", name='" + name + '\'' +
                ", cards=" + cards +
                '}';
    }
}
