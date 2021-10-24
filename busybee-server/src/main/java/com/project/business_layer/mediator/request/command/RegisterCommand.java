package com.project.business_layer.mediator.request.command;

import com.project.business_layer.mediator.request.TRequest;
import com.project.presentation_layer.dto.UserDto;

public class RegisterCommand implements TRequest {
    UserDto userDto;

    public RegisterCommand(UserDto userDto) {
        this.userDto = userDto;
    }

    public UserDto getUserDto() {
        return userDto;
    }

    public void setUserDto(UserDto userDto) {
        this.userDto = userDto;
    }
}
