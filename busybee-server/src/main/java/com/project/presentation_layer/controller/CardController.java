package com.project.presentation_layer.controller;

import com.project.business_layer.mediator.Mediator;
import com.project.business_layer.mediator.handler.command.AddBoardHandler;
import com.project.business_layer.mediator.handler.command.AddCardHandler;
import com.project.business_layer.mediator.handler.query.GetBoardsHandler;
import com.project.business_layer.mediator.handler.query.GetCardsHandler;
import com.project.business_layer.mediator.request.command.AddBoardCommand;
import com.project.business_layer.mediator.request.command.AddCardCommand;
import com.project.business_layer.mediator.request.query.GetBoardsQuery;
import com.project.business_layer.mediator.request.query.GetCardsQuery;
import com.project.business_layer.mediator.response.command.AddBoardResponse;
import com.project.business_layer.mediator.response.command.AddCardResponse;
import com.project.business_layer.mediator.response.query.GetBoardsResponse;
import com.project.business_layer.mediator.response.query.GetCardsResponse;
import com.project.presentation_layer.dto.BoardDto;
import com.project.presentation_layer.dto.CardDto;
import com.project.presentation_layer.dto.StringObj;
import com.project.utilities.validators.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/cards")
public class CardController {

    @Autowired
    Mediator mediator;

    @GetMapping(value = "/getCards")
    public ResponseEntity<List<CardDto>> getCards(@RequestHeader("boardId") String id) {

        GetCardsQuery getCardsQuery = new GetCardsQuery(Integer.parseInt(id));
        GetCardsHandler getCardsHandler = (GetCardsHandler) mediator.<GetCardsQuery, GetCardsResponse>getHandler(getCardsQuery);
        GetCardsResponse getCardsResponse = getCardsHandler.handle(getCardsQuery);

        return new ResponseEntity<>(getCardsResponse.getCardDtos(), HttpStatus.OK);
    }

    @PostMapping(value = "/addCard")
    public ResponseEntity<StringObj> addBoard(@RequestBody CardDto cardDto, @RequestHeader("boardId") String id) {
        if (!Validator.validateCardDto(cardDto))
            return new ResponseEntity<>(new StringObj("ERROR: INPUT ERROR"), HttpStatus.INTERNAL_SERVER_ERROR);

        System.out.println(cardDto.getName());

        AddCardCommand addCardCommand = new AddCardCommand(cardDto, Integer.parseInt(id));
        AddCardHandler addCardHandler = (AddCardHandler) mediator.<AddCardCommand, AddCardResponse>getHandler(addCardCommand);
        AddCardResponse addCardResponse = addCardHandler.handle(addCardCommand);

        return new ResponseEntity<>(new StringObj("SUCCESS: ADDED GROCERY"), HttpStatus.OK);
    }
}
