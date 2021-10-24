package com.project.business_layer.mediator.response.query;

import com.project.business_layer.mediator.response.TResponse;

public class LoginResponse implements TResponse {

    Integer integer;

    public LoginResponse(Integer integer) {
        this.integer = integer;
    }

    public Integer getInteger() {
        return integer;
    }

    public void setInteger(Integer integer) {
        this.integer = integer;
    }
}
