package com.project.business_layer.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table
public class UserBoard implements Serializable {

    @Id
    @GeneratedValue
    @Column(nullable = false,updatable = false)
    private int id;

    @NotNull
    private String access;

    @ManyToOne
    @NotNull
    private User userFK;

    @ManyToOne
    @NotNull
    private Board boardFK;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAccess() {
        return access;
    }

    public void setAccess(String access) {
        this.access = access;
    }

    public User getUserFK() {
        return userFK;
    }

    public void setUserFK(User userFK) {
        this.userFK = userFK;
    }

    public Board getBoardFK() {
        return boardFK;
    }

    public void setBoardFK(Board boardFK) {
        this.boardFK = boardFK;
    }

    @Override
    public String toString() {
        return "UserBoard{" +
                "id=" + id +
                ", access='" + access + '\'' +
                ", userFK=" + userFK +
                ", boardFK=" + boardFK +
                '}';
    }
}
