package com.project.business_layer.mediator.request.command;

import com.project.business_layer.mediator.request.TRequest;
import com.project.presentation_layer.dto.TaskDto;

public class AddTaskCommand implements TRequest {
    TaskDto taskDto;
    int id;

    public AddTaskCommand(TaskDto taskDto, int id) {
        this.taskDto = taskDto;
        this.id = id;
    }

    public TaskDto getTaskDto() {
        return taskDto;
    }

    public void setTaskDto(TaskDto taskDto) {
        this.taskDto = taskDto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
