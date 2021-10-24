package com.project.business_layer.mediator.response.query;

import com.project.business_layer.mediator.response.TResponse;
import com.project.presentation_layer.dto.StringObj;

public class GetAccessResponse implements TResponse {

    StringObj stringObj;

    public GetAccessResponse(StringObj stringObj) {
        this.stringObj = stringObj;
    }

    public StringObj getStringObj() {
        return stringObj;
    }

    public void setStringObj(StringObj stringObj) {
        this.stringObj = stringObj;
    }
}
