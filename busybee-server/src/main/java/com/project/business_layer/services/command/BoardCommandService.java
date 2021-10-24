package com.project.business_layer.services.command;

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
public class BoardCommandService {

    @Autowired
    BoardRepository boardRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserBoardRepository userBoardRepository;

    @Transactional
    public int addBoard(BoardDto boardDto, int id) {
        // find user
        User user = userRepository.findById(id);

        // check board is not duplicate
        if (boardRepository.findByName(boardDto.getName()) != null)
            return -1;

        // create new board from user input
        Board board = new Board();
        board.setName(boardDto.getName());
        board.setCards(boardDto.getCards());

        // create link between user and new board
        UserBoard userBoard = new UserBoard();
        userBoard.setUserFK(user);
        userBoard.setBoardFK(board);
        userBoard.setAccess("Edit");

        // save new board
        boardRepository.save(board);
        userBoardRepository.save(userBoard);
        return 0;
    }
}
