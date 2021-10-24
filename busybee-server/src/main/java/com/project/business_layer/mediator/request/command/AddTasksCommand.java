package com.project.business_layer.mediator.request.command;

import com.project.business_layer.mediator.request.TRequest;
import com.project.presentation_layer.dto.TaskDto;

import java.util.List;

public class AddTasksCommand implements TRequest {
    List<TaskDto> taskDtos;
    int id;

    public AddTasksCommand(List<TaskDto> taskDtos, int id) {
        this.taskDtos = taskDtos;
        this.id = id;
    }

    public List<TaskDto> getTaskDtos() {
        return taskDtos;
    }

    public void setTaskDtos(List<TaskDto> taskDtos) {
        this.taskDtos = taskDtos;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
