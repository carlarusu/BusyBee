package com.project.business_layer.mediator.handler.query;

import com.project.business_layer.mediator.handler.IHandler;
import com.project.business_layer.mediator.request.query.GetBoardQuery;
import com.project.business_layer.mediator.response.query.GetBoardResponse;
import com.project.business_layer.services.query.BoardQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GetBoardHandler implements IHandler<GetBoardQuery, GetBoardResponse> {

    private final BoardQueryService boardQueryService;

    @Autowired
    public GetBoardHandler(BoardQueryService boardQueryService) {
        this.boardQueryService = boardQueryService;
    }

    @Override
    public GetBoardResponse handle(GetBoardQuery q) {
        return new GetBoardResponse(boardQueryService.getBoard(q.getId()));
    }
}
