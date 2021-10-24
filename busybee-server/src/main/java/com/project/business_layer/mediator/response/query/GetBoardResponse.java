package com.project.business_layer.mediator.response.query;

import com.project.business_layer.mediator.response.TResponse;
import com.project.presentation_layer.dto.BoardDto;

public class GetBoardResponse implements TResponse {

    BoardDto boardDto;

    public GetBoardResponse(BoardDto boardDto) {
        this.boardDto = boardDto;
    }

    public BoardDto getBoardDto() {
        return boardDto;
    }

    public void setBoardDto(BoardDto boardDto) {
        this.boardDto = boardDto;
    }
}
