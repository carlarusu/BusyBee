package com.project.business_layer.mediator.response.query;

import com.project.business_layer.mediator.response.TResponse;
import com.project.presentation_layer.dto.CardDto;

import java.util.List;

public class GetCardsResponse implements TResponse {
    List<CardDto> cardDtos;

    public GetCardsResponse(List<CardDto> cardDtos) {
        this.cardDtos = cardDtos;
    }

    public List<CardDto> getCardDtos() {
        return cardDtos;
    }

    public void setCardDtos(List<CardDto> cardDtos) {
        this.cardDtos = cardDtos;
    }
}
