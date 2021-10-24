package com.project.business_layer.services.command;

import com.project.business_layer.decorator.UserBoardDecorator.EditDecorator;
import com.project.business_layer.decorator.UserBoardDecorator.ViewDecorator;
import com.project.business_layer.entity.Board;
import com.project.business_layer.entity.User;
import com.project.business_layer.entity.UserBoard;
import com.project.persistence_layer.repository.BoardRepository;
import com.project.persistence_layer.repository.UserBoardRepository;
import com.project.persistence_layer.repository.UserRepository;
import com.project.presentation_layer.dto.BoardDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserBoardCommandService {

    @Autowired
    BoardRepository boardRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserBoardRepository userBoardRepository;

    @Transactional
    public int addEditMember(String username, int boardId) {
        // find user and board
        User user = userRepository.findByUsername(username);
        Board board = boardRepository.findById(boardId);

        if (user == null || board == null)
            return -1;

        // create link between user and new board
        UserBoard userBoard = new UserBoard();
        userBoard.setUserFK(user);
        userBoard.setBoardFK(board);

        EditDecorator editDecorator = new EditDecorator(userBoard);
        editDecorator.editAccess();

        // save new user-board link
        userBoardRepository.save(editDecorator.userBoard);
        return 0;
    }

    @Transactional
    public int addViewMember(String username, int boardId) {
        // find user
        User user = userRepository.findByUsername(username);
        Board board = boardRepository.findById(boardId);

        if (user == null || board == null)
            return -1;

        // create link between user and new board
        UserBoard userBoard = new UserBoard();
        userBoard.setUserFK(user);
        userBoard.setBoardFK(board);

        ViewDecorator viewDecorator = new ViewDecorator(userBoard);
        viewDecorator.viewAccess();

        // save new user-board link
        userBoardRepository.save(viewDecorator.userBoard);
        return 0;
    }
}
