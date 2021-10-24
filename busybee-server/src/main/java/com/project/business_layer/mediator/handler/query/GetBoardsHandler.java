package com.project.business_layer.mediator.handler.query;

import com.project.business_layer.mediator.handler.IHandler;
import com.project.business_layer.mediator.request.query.GetBoardsQuery;
import com.project.business_layer.mediator.response.query.GetBoardsResponse;
import com.project.business_layer.services.query.BoardQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GetBoardsHandler implements IHandler<GetBoardsQuery, GetBoardsResponse> {

    private final BoardQueryService boardQueryService;

    @Autowired
    public GetBoardsHandler(BoardQueryService boardQueryService) {
        this.boardQueryService = boardQueryService;
    }

    @Override
    public GetBoardsResponse handle(GetBoardsQuery q) {
        return new GetBoardsResponse(boardQueryService.getBoards(q.getId()));
    }
}
