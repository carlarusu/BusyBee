package com.project.business_layer.mediator.response.command;

import com.project.business_layer.mediator.response.TResponse;

public class RegisterResponse implements TResponse {

    int id;

    public RegisterResponse(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
