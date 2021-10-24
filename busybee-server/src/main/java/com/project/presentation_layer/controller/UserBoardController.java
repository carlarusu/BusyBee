package com.project.presentation_layer.controller;

import com.project.business_layer.mediator.Mediator;
import com.project.business_layer.mediator.handler.command.AddEditMemberHandler;
import com.project.business_layer.mediator.handler.command.AddViewMemberHandler;
import com.project.business_layer.mediator.handler.query.GetAccessHandler;
import com.project.business_layer.mediator.request.command.AddEditMemberCommand;
import com.project.business_layer.mediator.request.command.AddViewMemberCommand;
import com.project.business_layer.mediator.request.query.GetAccessQuery;
import com.project.business_layer.mediator.response.command.AddEditMemberResponse;
import com.project.business_layer.mediator.response.command.AddViewMemberResponse;
import com.project.business_layer.mediator.response.query.GetAccessResponse;
import com.project.presentation_layer.dto.StringObj;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "/userBoards")
public class UserBoardController {

    @Autowired
    Mediator mediator;

    @GetMapping(value = "/getAccess")
    public ResponseEntity<StringObj> getAccess(@RequestHeader("boardId") String boardId, @RequestHeader("userId") String userId) {

        GetAccessQuery getAccessQuery = new GetAccessQuery(Integer.parseInt(boardId), Integer.parseInt(userId));
        GetAccessHandler getAccessHandler = (GetAccessHandler) mediator.<GetAccessQuery, GetAccessResponse>getHandler(getAccessQuery);
        GetAccessResponse getAccessResponse = getAccessHandler.handle(getAccessQuery);

        return new ResponseEntity<>(getAccessResponse.getStringObj(), HttpStatus.OK);
    }

    @PostMapping(value = "/addViewMember")
    public ResponseEntity<StringObj> addViewMember(@RequestBody String username, @RequestHeader("boardId") String id) {
        System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa " + username);

        AddViewMemberCommand addViewMemberCommand = new AddViewMemberCommand(username, Integer.parseInt(id));
        AddViewMemberHandler addViewMemberHandler = (AddViewMemberHandler)mediator.<AddViewMemberCommand, AddViewMemberResponse>getHandler(addViewMemberCommand);
        AddViewMemberResponse addViewMemberResponse = addViewMemberHandler.handle(addViewMemberCommand);

        return new ResponseEntity<>(new StringObj("SUCCESS: ADDED MEMBER"), HttpStatus.OK);
    }

    @PostMapping(value = "/addEditMember")
    public ResponseEntity<StringObj> addEditMember(@RequestBody String username, @RequestHeader("boardId") String id) {
        System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa " + username);

        AddEditMemberCommand addEditMemberCommand = new AddEditMemberCommand(username, Integer.parseInt(id));
        AddEditMemberHandler addEditMemberHandler = (AddEditMemberHandler)mediator.<AddEditMemberCommand, AddEditMemberResponse>getHandler(addEditMemberCommand);
        AddEditMemberResponse addEditMemberResponse = addEditMemberHandler.handle(addEditMemberCommand);

        return new ResponseEntity<>(new StringObj("SUCCESS: ADDED MEMBER"), HttpStatus.OK);
    }
}
