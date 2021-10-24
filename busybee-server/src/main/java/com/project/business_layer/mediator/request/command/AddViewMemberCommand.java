package com.project.business_layer.mediator.request.command;

import com.project.business_layer.mediator.request.TRequest;

public class AddViewMemberCommand implements TRequest {

    String username;
    int boardId;

    public AddViewMemberCommand(String username, int boardId) {
        this.username = username;
        this.boardId = boardId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getBoardId() {
        return boardId;
    }

    public void setBoardId(int boardId) {
        this.boardId = boardId;
    }
}
