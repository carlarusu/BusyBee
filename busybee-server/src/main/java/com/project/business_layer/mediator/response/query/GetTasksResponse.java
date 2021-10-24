package com.project.business_layer.mediator.response.query;

import com.project.business_layer.mediator.response.TResponse;
import com.project.presentation_layer.dto.TaskDto;

import java.util.List;

public class GetTasksResponse implements TResponse {

    List<TaskDto> taskDtos;

    public GetTasksResponse(List<TaskDto> taskDtos) {
        this.taskDtos = taskDtos;
    }

    public List<TaskDto> getTaskDtos() {
        return taskDtos;
    }

    public void setTaskDtos(List<TaskDto> taskDtos) {
        this.taskDtos = taskDtos;
    }
}
