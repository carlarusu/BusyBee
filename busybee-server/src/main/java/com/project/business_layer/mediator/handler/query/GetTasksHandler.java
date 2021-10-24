package com.project.business_layer.mediator.handler.query;

import com.project.business_layer.mediator.handler.IHandler;
import com.project.business_layer.mediator.request.query.GetBoardsQuery;
import com.project.business_layer.mediator.request.query.GetTasksQuery;
import com.project.business_layer.mediator.response.query.GetBoardsResponse;
import com.project.business_layer.mediator.response.query.GetTasksResponse;
import com.project.business_layer.services.query.BoardQueryService;
import com.project.business_layer.services.query.TaskQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GetTasksHandler implements IHandler<GetTasksQuery, GetTasksResponse> {

    private final TaskQueryService taskQueryService;

    @Autowired
    public GetTasksHandler(TaskQueryService taskQueryService) {
        this.taskQueryService = taskQueryService;
    }

    @Override
    public GetTasksResponse handle(GetTasksQuery q) {
        return new GetTasksResponse(taskQueryService.getTasks(q.getId()));
    }
}
