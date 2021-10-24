package com.project.business_layer.mediator.handler.command;

import com.project.business_layer.mediator.handler.IHandler;
import com.project.business_layer.mediator.request.command.AddViewMemberCommand;
import com.project.business_layer.mediator.response.command.AddViewMemberResponse;
import com.project.business_layer.services.command.UserBoardCommandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AddViewMemberHandler implements IHandler<AddViewMemberCommand, AddViewMemberResponse> {

    private final UserBoardCommandService userBoardCommandService;

    @Autowired
    public AddViewMemberHandler(UserBoardCommandService userBoardCommandService) {
        this.userBoardCommandService = userBoardCommandService;
    }

    @Override
    public AddViewMemberResponse handle(AddViewMemberCommand c) {
        return new AddViewMemberResponse(userBoardCommandService.addViewMember(c.getUsername(),c.getBoardId()));
    }
}
