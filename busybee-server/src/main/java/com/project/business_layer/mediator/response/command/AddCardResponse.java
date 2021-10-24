package com.project.business_layer.mediator.response.command;

import com.project.business_layer.mediator.response.TResponse;

public class AddCardResponse implements TResponse {

    int result;

    public AddCardResponse(int result) {
        this.result = result;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }
}
