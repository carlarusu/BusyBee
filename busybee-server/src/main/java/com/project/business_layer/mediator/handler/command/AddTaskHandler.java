package com.project.business_layer.mediator.handler.command;

import com.project.business_layer.mediator.handler.IHandler;
import com.project.business_layer.mediator.request.command.AddCardCommand;
import com.project.business_layer.mediator.request.command.AddTaskCommand;
import com.project.business_layer.mediator.response.command.AddCardResponse;
import com.project.business_layer.mediator.response.command.AddTaskResponse;
import com.project.business_layer.services.command.CardCommandService;
import com.project.business_layer.services.command.TaskCommandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AddTaskHandler implements IHandler<AddTaskCommand, AddTaskResponse> {

    private final TaskCommandService taskCommandService;

    @Autowired
    public AddTaskHandler(TaskCommandService taskCommandService) {
        this.taskCommandService = taskCommandService;
    }

    @Override
    public AddTaskResponse handle(AddTaskCommand c) {
        return new AddTaskResponse(taskCommandService.addTask(c.getTaskDto(),c.getId()));
    }
}
