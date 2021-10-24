package com.project.business_layer.mediator.request.command;

import com.project.business_layer.mediator.request.TRequest;
import com.project.presentation_layer.dto.BoardDto;

public class AddBoardCommand implements TRequest {

    BoardDto boardDto;
    int id;

    public AddBoardCommand(BoardDto boardDto, int id) {
        this.boardDto = boardDto;
        this.id = id;
    }

    public BoardDto getBoardDto() {
        return boardDto;
    }

    public void setBoardDto(BoardDto boardDto) {
        this.boardDto = boardDto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
