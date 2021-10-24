package com.project.business_layer.mediator.handler.command;

import com.project.business_layer.mediator.handler.IHandler;
import com.project.business_layer.mediator.request.command.AddTaskCommand;
import com.project.business_layer.mediator.request.command.AddTasksCommand;
import com.project.business_layer.mediator.response.command.AddTaskResponse;
import com.project.business_layer.mediator.response.command.AddTasksResponse;
import com.project.business_layer.services.command.TaskCommandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AddTasksHandler implements IHandler<AddTasksCommand, AddTasksResponse> {

    private final TaskCommandService taskCommandService;

    @Autowired
    public AddTasksHandler(TaskCommandService taskCommandService) {
        this.taskCommandService = taskCommandService;
    }

    @Override
    public AddTasksResponse handle(AddTasksCommand c) {
        return new AddTasksResponse(taskCommandService.addTasks(c.getTaskDtos(),c.getId()));
    }
}
