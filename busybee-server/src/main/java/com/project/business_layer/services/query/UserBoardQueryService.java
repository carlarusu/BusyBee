package com.project.business_layer.services.query;

import com.project.business_layer.entity.Board;
import com.project.business_layer.entity.User;
import com.project.business_layer.entity.UserBoard;
import com.project.persistence_layer.repository.BoardRepository;
import com.project.persistence_layer.repository.UserBoardRepository;
import com.project.persistence_layer.repository.UserRepository;
import com.project.presentation_layer.dto.StringObj;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserBoardQueryService {

    @Autowired
    BoardRepository boardRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserBoardRepository userBoardRepository;

    @Transactional
    public StringObj getAccess(int boardId, int userId){
        // find user and board
        User user = userRepository.findById(userId);
        Board board = boardRepository.findById(boardId);

        if (user == null || board == null)
            return null;

        UserBoard userBoard = userBoardRepository.findByUserFKAndBoardFK(user, board);

        return new StringObj(userBoard.getAccess());
    }
}
