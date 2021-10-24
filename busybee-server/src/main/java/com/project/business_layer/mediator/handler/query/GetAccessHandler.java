package com.project.business_layer.mediator.handler.query;

import com.project.business_layer.mediator.handler.IHandler;
import com.project.business_layer.mediator.request.query.GetAccessQuery;
import com.project.business_layer.mediator.response.query.GetAccessResponse;
import com.project.business_layer.services.query.UserBoardQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GetAccessHandler implements IHandler<GetAccessQuery, GetAccessResponse> {

    private final UserBoardQueryService userBoardQueryService;

    @Autowired
    public GetAccessHandler(UserBoardQueryService userBoardQueryService) {
        this.userBoardQueryService = userBoardQueryService;
    }

    @Override
    public GetAccessResponse handle(GetAccessQuery q) {
        return new GetAccessResponse(userBoardQueryService.getAccess(q.getBoardId(),q.getUserId()));
    }
}
