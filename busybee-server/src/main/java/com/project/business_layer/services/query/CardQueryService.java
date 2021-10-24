package com.project.business_layer.services.query;

import com.project.business_layer.entity.Board;
import com.project.business_layer.entity.Card;
import com.project.business_layer.entity.User;
import com.project.business_layer.entity.UserBoard;
import com.project.persistence_layer.repository.BoardRepository;
import com.project.presentation_layer.dto.BoardDto;
import com.project.presentation_layer.dto.CardDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

@Service
public class CardQueryService {

    @Autowired
    BoardRepository boardRepository;

    @Transactional
    public ArrayList<CardDto> getCards(int id) {
        ArrayList<CardDto> cardDtos = new ArrayList<CardDto>();
        Board board = boardRepository.findById(id);

        for (Card i: board.getCards()) {
            cardDtos.add(new CardDto(i.getId(), i.getName(), i.getTasks()));
        }

        return cardDtos;
    }
}
