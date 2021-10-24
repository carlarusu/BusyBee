package com.project.presentation_layer.controller;


import com.project.business_layer.mediator.Mediator;
import com.project.business_layer.mediator.handler.command.AddBoardHandler;
import com.project.business_layer.mediator.handler.query.GetBoardHandler;
import com.project.business_layer.mediator.handler.query.GetBoardsHandler;
import com.project.business_layer.mediator.request.command.AddBoardCommand;
import com.project.business_layer.mediator.request.query.GetBoardQuery;
import com.project.business_layer.mediator.request.query.GetBoardsQuery;
import com.project.business_layer.mediator.response.command.AddBoardResponse;
import com.project.business_layer.mediator.response.query.GetBoardResponse;
import com.project.business_layer.mediator.response.query.GetBoardsResponse;
import com.project.presentation_layer.dto.BoardDto;
import com.project.presentation_layer.dto.StringObj;
import com.project.utilities.validators.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/boards")
public class BoardController {

    @Autowired
    Mediator mediator;

    @PostMapping(value = "/addBoard")
    public ResponseEntity<StringObj> addBoard(@RequestBody BoardDto boardDto, @RequestHeader("userId") String id) {
        if (!Validator.validateBoardDto(boardDto))
            return new ResponseEntity<>(new StringObj("ERROR: INPUT ERROR"), HttpStatus.INTERNAL_SERVER_ERROR);

        AddBoardCommand addBoardCommand = new AddBoardCommand(boardDto, Integer.parseInt(id));
        AddBoardHandler addBoardHandler = (AddBoardHandler)mediator.<AddBoardCommand, AddBoardResponse>getHandler(addBoardCommand);
        AddBoardResponse addBoardResponse = addBoardHandler.handle(addBoardCommand);

        return new ResponseEntity<>(new StringObj("SUCCESS: ADDED GROCERY"), HttpStatus.OK);
    }

    @GetMapping(value = "/getBoards")
    public ResponseEntity<List<BoardDto>> getBoards(@RequestHeader("userId") String id) {

        GetBoardsQuery getBoardsQuery = new GetBoardsQuery(Integer.parseInt(id));
        GetBoardsHandler getBoardsHandler = (GetBoardsHandler) mediator.<GetBoardsQuery, GetBoardsResponse>getHandler(getBoardsQuery);
        GetBoardsResponse getBoardsResponse = getBoardsHandler.handle(getBoardsQuery);

        return new ResponseEntity<>(getBoardsResponse.getBoardDtos(), HttpStatus.OK);
    }

    @GetMapping(value = "/getBoard")
    public ResponseEntity<BoardDto> getBoard(@RequestHeader("boardId") String id) {

        GetBoardQuery getBoardQuery = new GetBoardQuery(Integer.parseInt(id));
        GetBoardHandler getBoardHandler = (GetBoardHandler) mediator.<GetBoardQuery, GetBoardResponse>getHandler(getBoardQuery);
        GetBoardResponse getBoardResponse = getBoardHandler.handle(getBoardQuery);

        return new ResponseEntity<>(getBoardResponse.getBoardDto(), HttpStatus.OK);
    }
}
