package com.project.presentation_layer.controller;

import com.project.business_layer.mediator.Mediator;
import com.project.business_layer.mediator.handler.command.AddCardHandler;
import com.project.business_layer.mediator.handler.command.AddTaskHandler;
import com.project.business_layer.mediator.handler.command.AddTasksHandler;
import com.project.business_layer.mediator.handler.query.GetCardsHandler;
import com.project.business_layer.mediator.handler.query.GetTasksHandler;
import com.project.business_layer.mediator.request.command.AddCardCommand;
import com.project.business_layer.mediator.request.command.AddTaskCommand;
import com.project.business_layer.mediator.request.command.AddTasksCommand;
import com.project.business_layer.mediator.request.query.GetCardsQuery;
import com.project.business_layer.mediator.request.query.GetTasksQuery;
import com.project.business_layer.mediator.response.command.AddCardResponse;
import com.project.business_layer.mediator.response.command.AddTaskResponse;
import com.project.business_layer.mediator.response.command.AddTasksResponse;
import com.project.business_layer.mediator.response.query.GetCardsResponse;
import com.project.business_layer.mediator.response.query.GetTasksResponse;
import com.project.presentation_layer.dto.CardDto;
import com.project.presentation_layer.dto.StringObj;
import com.project.presentation_layer.dto.TaskDto;
import com.project.utilities.validators.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/tasks")
public class TaskController {

    @Autowired
    Mediator mediator;

    @PostMapping(value = "/addTask")
    public ResponseEntity<StringObj> addBoard(@RequestBody TaskDto taskDto, @RequestHeader("cardId") String id) {
        if (!Validator.validateTaskDto(taskDto))
            return new ResponseEntity<>(new StringObj("ERROR: INPUT ERROR"), HttpStatus.INTERNAL_SERVER_ERROR);

        AddTaskCommand addTaskCommand = new AddTaskCommand(taskDto, Integer.parseInt(id));
        AddTaskHandler addTaskHandler = (AddTaskHandler) mediator.<AddTaskCommand, AddTaskResponse>getHandler(addTaskCommand);
        AddTaskResponse addTaskResponse = addTaskHandler.handle(addTaskCommand);

        return new ResponseEntity<>(new StringObj("SUCCESS: ADDED GROCERY"), HttpStatus.OK);
    }

    @PostMapping(value = "/addTasks")
    public ResponseEntity<StringObj> addBoard(@RequestBody List<TaskDto> taskDtos, @RequestHeader("cardId") String id) {

        AddTasksCommand addTasksCommand = new AddTasksCommand(taskDtos, Integer.parseInt(id));
        AddTasksHandler addTasksHandler = (AddTasksHandler) mediator.<AddTasksCommand, AddTasksResponse>getHandler(addTasksCommand);
        AddTasksResponse addTasksResponse = addTasksHandler.handle(addTasksCommand);

        return new ResponseEntity<>(new StringObj("SUCCESS: ADDED GROCERY"), HttpStatus.OK);
    }

    @GetMapping(value = "/getTasks")
    public ResponseEntity<List<TaskDto>> getCards(@RequestHeader("cardId") String id) {

        GetTasksQuery getTasksQuery = new GetTasksQuery(Integer.parseInt(id));
        GetTasksHandler getTasksHandler = (GetTasksHandler) mediator.<GetTasksQuery, GetTasksResponse>getHandler(getTasksQuery);
        GetTasksResponse getTasksResponse = getTasksHandler.handle(getTasksQuery);

        return new ResponseEntity<>(getTasksResponse.getTaskDtos(), HttpStatus.OK);
    }
}
