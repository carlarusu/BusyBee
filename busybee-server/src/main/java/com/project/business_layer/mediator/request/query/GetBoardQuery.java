package com.project.business_layer.mediator.request.query;

import com.project.business_layer.mediator.request.TRequest;

public class GetBoardQuery implements TRequest {

    int id;

    public GetBoardQuery(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
