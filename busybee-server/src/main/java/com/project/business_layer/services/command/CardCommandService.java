package com.project.business_layer.services.command;

import com.project.business_layer.entity.Board;
import com.project.business_layer.entity.Card;
import com.project.persistence_layer.repository.BoardRepository;
import com.project.persistence_layer.repository.CardRepository;
import com.project.presentation_layer.dto.CardDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CardCommandService {

    @Autowired
    CardRepository cardRepository;

    @Autowired
    BoardRepository boardRepository;

    @Transactional
    public int addCard(CardDto cardDto, int id) {
        // find board
        Board board = boardRepository.findById(id);

        // check card is not duplicate
        if (cardRepository.findByName(cardDto.getName()) != null)
            return -1;

        // create new card from user input
        Card card = new Card();
        card.setName(cardDto.getName());
        card.setTasks(cardDto.getTasks());

        // create link between board and new card
        card.setBoardFK(board);
        board.getCards().add(card);

        cardRepository.save(card);
        return 0;
    }

}
