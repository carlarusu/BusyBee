package com.project.presentation_layer.dto;

import java.sql.Timestamp;

public class TaskDto {

    private int id;
    private String description;
    private Timestamp dueDate;

    public TaskDto(int id, String description, Timestamp dueDate) {
        this.id = id;
        this.description = description;
        this.dueDate = dueDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
        return "TaskDto{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", dueDate=" + dueDate +
                '}';
    }
}
