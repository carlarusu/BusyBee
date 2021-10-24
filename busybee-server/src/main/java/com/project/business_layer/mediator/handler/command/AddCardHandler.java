package com.project.business_layer.mediator.handler.command;

import com.project.business_layer.mediator.handler.IHandler;
import com.project.business_layer.mediator.request.command.AddCardCommand;
import com.project.business_layer.mediator.response.command.AddCardResponse;
import com.project.business_layer.services.command.CardCommandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AddCardHandler implements IHandler<AddCardCommand, AddCardResponse> {

    private final CardCommandService cardCommandService;

    @Autowired
    public AddCardHandler(CardCommandService cardCommandService) {
        this.cardCommandService = cardCommandService;
    }

    @Override
    public AddCardResponse handle(AddCardCommand c) {
        return new AddCardResponse(cardCommandService.addCard(c.getCardDto(),c.getId()));
    }
}
