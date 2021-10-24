package com.project.business_layer.mediator.handler.query;

import com.project.business_layer.mediator.handler.IHandler;
import com.project.business_layer.mediator.request.query.GetCardsQuery;
import com.project.business_layer.mediator.response.query.GetCardsResponse;
import com.project.business_layer.services.query.CardQueryService;
import org.springframework.stereotype.Component;

@Component
public class GetCardsHandler implements IHandler<GetCardsQuery, GetCardsResponse> {

    private final CardQueryService cardQueryService;

    public GetCardsHandler(CardQueryService cardQueryService) {
        this.cardQueryService = cardQueryService;
    }

    @Override
    public GetCardsResponse handle(GetCardsQuery q) {
        return new GetCardsResponse(cardQueryService.getCards(q.getId()));
    }
}
