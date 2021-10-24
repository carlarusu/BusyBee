package com.project.business_layer.services.query;

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

import java.util.ArrayList;

@Service
public class BoardQueryService {

    @Autowired
    BoardRepository boardRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserBoardRepository userBoardRepository;

    @Transactional
    public ArrayList<BoardDto> getBoards(int id) {
        ArrayList<BoardDto> boardDtos = new ArrayList<BoardDto>();
        //User user = userRepository.findById(id);
        ArrayList<UserBoard> userBoards = userBoardRepository.findAllByUserFK_Id(id);

        for (UserBoard i : userBoards) {
            Board board = boardRepository.findById(i.getBoardFK().getId());
            boardDtos.add(new BoardDto(board.getId(), board.getName(), board.getCards()));
        }

        return boardDtos;
    }

    @Transactional
    public BoardDto getBoard(int id) {
        Board board = boardRepository.findById(id);
        BoardDto boardDto = new BoardDto(board.getId(),board.getName(),board.getCards());
        return boardDto;
    }
}
