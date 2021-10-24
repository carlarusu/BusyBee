package com.project.business_layer.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.sql.Timestamp;

@Entity
@Table
public class Task implements Serializable {

    @Id
    @GeneratedValue
    @Column(nullable = false,updatable = false)
    private int id;

    @ManyToOne
    private Card cardFK;

    @NotNull
    private String description;

    private Timestamp dueDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Card getCardFK() {
        return cardFK;
    }

    public void setCardFK(Card cardFK) {
        this.cardFK = cardFK;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Timestamp getDueDate() {
        return dueDate;
    }

    public void setDueDate(Timestamp dueDate) {
        this.dueDate = dueDate;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", cardFK=" + cardFK +
                ", description='" + description + '\'' +
                ", dueDate=" + dueDate +
                '}';
    }
}
