package com.project.business_layer.mediator.handler.command;

import com.project.business_layer.mediator.handler.IHandler;
import com.project.business_layer.mediator.request.command.AddBoardCommand;
import com.project.business_layer.mediator.response.command.AddBoardResponse;
import com.project.business_layer.services.command.BoardCommandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AddBoardHandler implements IHandler<AddBoardCommand, AddBoardResponse> {

    private final BoardCommandService boardCommandService;

    @Autowired
    public AddBoardHandler(BoardCommandService boardCommandService) {
        this.boardCommandService = boardCommandService;
    }

    @Override
    public AddBoardResponse handle(AddBoardCommand c) {
        return new AddBoardResponse(boardCommandService.addBoard(c.getBoardDto(),c.getId()));
    }
}
