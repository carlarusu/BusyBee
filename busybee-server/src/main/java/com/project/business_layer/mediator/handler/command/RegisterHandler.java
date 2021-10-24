package com.project.business_layer.mediator.handler.command;

import com.project.business_layer.mediator.handler.IHandler;
import com.project.business_layer.mediator.request.command.RegisterCommand;
import com.project.business_layer.mediator.response.command.RegisterResponse;
import com.project.business_layer.services.command.UserCommandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RegisterHandler implements IHandler<RegisterCommand, RegisterResponse> {

    private final UserCommandService userCommandService;

    @Autowired
    public RegisterHandler(UserCommandService userCommandService) {
        this.userCommandService = userCommandService;
    }

    @Override
    public RegisterResponse handle(RegisterCommand c) {
        return new RegisterResponse(userCommandService.register(c.getUserDto()));
    }
}
