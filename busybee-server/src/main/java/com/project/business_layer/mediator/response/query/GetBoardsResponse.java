package com.project.business_layer.mediator.response.query;

import com.project.business_layer.mediator.response.TResponse;
import com.project.presentation_layer.dto.BoardDto;

import java.util.List;

public class GetBoardsResponse implements TResponse {
    List<BoardDto> boardDtos;

    public GetBoardsResponse(List<BoardDto> boardDtos) {
        this.boardDtos = boardDtos;
    }

    public List<BoardDto> getBoardDtos() {
        return boardDtos;
    }

    public void setBoardDtos(List<BoardDto> boardDtos) {
        this.boardDtos = boardDtos;
    }
}
