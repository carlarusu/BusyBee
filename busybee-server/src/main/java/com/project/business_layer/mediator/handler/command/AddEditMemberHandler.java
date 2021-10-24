package com.project.business_layer.mediator.handler.command;

import com.project.business_layer.mediator.handler.IHandler;
import com.project.business_layer.mediator.request.command.AddEditMemberCommand;
import com.project.business_layer.mediator.response.command.AddEditMemberResponse;
import com.project.business_layer.services.command.UserBoardCommandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AddEditMemberHandler implements IHandler<AddEditMemberCommand, AddEditMemberResponse> {

    private final UserBoardCommandService userBoardCommandService;

    @Autowired
    public AddEditMemberHandler(UserBoardCommandService userBoardCommandService) {
        this.userBoardCommandService = userBoardCommandService;
    }

    @Override
    public AddEditMemberResponse handle(AddEditMemberCommand c) {
        return new AddEditMemberResponse(userBoardCommandService.addEditMember(c.getUsername(),c.getBoardId()));
    }
}
