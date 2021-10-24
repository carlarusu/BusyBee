package com.project.presentation_layer.controller;

import com.project.business_layer.mediator.Mediator;
import com.project.business_layer.mediator.handler.query.LoginHandler;
import com.project.business_layer.mediator.handler.command.RegisterHandler;
import com.project.business_layer.mediator.request.command.RegisterCommand;
import com.project.business_layer.mediator.request.query.LoginQuery;
import com.project.business_layer.mediator.response.command.RegisterResponse;
import com.project.business_layer.mediator.response.query.LoginResponse;
import com.project.presentation_layer.dto.*;
import com.project.utilities.validators.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    Mediator mediator;

    @PostMapping(value = "/register")
    public ResponseEntity<StringObj> register(@RequestBody UserDto UserDto) {
        if (Validator.validateUserDto(UserDto)) {

            RegisterCommand registerCommand = new RegisterCommand(UserDto);
            RegisterHandler registerHandler = (RegisterHandler)mediator.<RegisterCommand, RegisterResponse>getHandler(registerCommand);
            RegisterResponse registerResponse = registerHandler.handle(registerCommand);


            switch (registerResponse.getId()) {
                case 0:
                    return new ResponseEntity<>(new StringObj("SUCCESS : USER REGISTERED"), HttpStatus.OK);
                case -1:
                    return new ResponseEntity<>(new StringObj("ERROR: DUPLICATE USERNAME"), HttpStatus.CONFLICT);
                default:
                    return new ResponseEntity<>(new StringObj("ERROR: UNKNOWN"), HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
        return new ResponseEntity<>(new StringObj("ERROR: INPUT ERROR"), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @PostMapping(value = "/login")
    public ResponseEntity<Integer> login(@RequestBody UserDto UserDto) {
        if (!Validator.validateUserDto(UserDto))
            return new ResponseEntity<>(-1, HttpStatus.INTERNAL_SERVER_ERROR);

        LoginQuery loginQuery = new LoginQuery(UserDto);
        LoginHandler loginHandler = (LoginHandler) mediator.<LoginQuery, LoginResponse>getHandler(loginQuery);
        LoginResponse loginResponse = loginHandler.handle(loginQuery);
        Integer id = loginResponse.getInteger();

        if (id == null)
            return new ResponseEntity<>(id, HttpStatus.INTERNAL_SERVER_ERROR);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }
    
}
