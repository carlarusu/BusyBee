package com.project.business_layer.mediator.request.query;

import com.project.business_layer.mediator.request.TRequest;
import com.project.presentation_layer.dto.UserDto;

public class LoginQuery implements TRequest {

    UserDto userDto;

    public LoginQuery(UserDto userDto) {
        this.userDto = userDto;
    }

    public UserDto getUserDto() {
        return userDto;
    }

    public void setUserDto(UserDto userDto) {
        this.userDto = userDto;
    }
}
