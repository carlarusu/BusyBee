package com.project.business_layer.mediator.request.query;

import com.project.business_layer.mediator.request.TRequest;

public class GetAccessQuery implements TRequest {
    int boardId;
    int userId;

    public GetAccessQuery(int boardId, int userId) {
        this.boardId = boardId;
        this.userId = userId;
    }

    public int getBoardId() {
        return boardId;
    }

    public void setBoardId(int boardId) {
        this.boardId = boardId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
