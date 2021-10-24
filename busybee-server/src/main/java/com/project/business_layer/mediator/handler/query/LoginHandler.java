package com.project.business_layer.mediator.handler.query;

import com.project.business_layer.mediator.handler.IHandler;
import com.project.business_layer.mediator.request.query.LoginQuery;
import com.project.business_layer.mediator.response.query.LoginResponse;
import com.project.business_layer.services.query.UserQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LoginHandler implements IHandler<LoginQuery, LoginResponse> {

    private final UserQueryService userQueryService;

    @Autowired
    public LoginHandler(UserQueryService userQueryService) {
        this.userQueryService = userQueryService;
    }

    @Override
    public LoginResponse handle(LoginQuery q) {
        Integer integer = userQueryService.login(q.getUserDto());
        return new LoginResponse(integer);
    }
}
