package com.project.business_layer.decorator.UserBoardDecorator;

import com.project.business_layer.entity.UserBoard;

public class EditDecorator {
    public UserBoard userBoard;

    public EditDecorator(UserBoard userBoard) {
        this.userBoard = userBoard;
    }

    public void editAccess() {
        userBoard.setAccess("Edit");
    }
}
