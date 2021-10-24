package com.project.business_layer.mediator.request.query;

import com.project.business_layer.mediator.request.TRequest;

public class GetTasksQuery implements TRequest {

    int id;

    public GetTasksQuery(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
