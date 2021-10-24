package com.project.business_layer.mediator.request.command;

import com.project.business_layer.mediator.request.TRequest;
import com.project.presentation_layer.dto.CardDto;

public class AddCardCommand implements TRequest {

    CardDto cardDto;
    int id;

    public AddCardCommand(CardDto cardDto, int id) {
        this.cardDto = cardDto;
        this.id = id;
    }

    public CardDto getCardDto() {
        return cardDto;
    }

    public void setCardDto(CardDto cardDto) {
        this.cardDto = cardDto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
