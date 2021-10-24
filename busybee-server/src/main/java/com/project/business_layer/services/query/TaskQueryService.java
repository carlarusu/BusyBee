package com.project.business_layer.services.query;

import com.project.business_layer.entity.Board;
import com.project.business_layer.entity.Card;
import com.project.business_layer.entity.Task;
import com.project.persistence_layer.repository.BoardRepository;
import com.project.persistence_layer.repository.CardRepository;
import com.project.persistence_layer.repository.TaskRepository;
import com.project.presentation_layer.dto.CardDto;
import com.project.presentation_layer.dto.TaskDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

@Service
public class TaskQueryService {

    @Autowired
    TaskRepository taskRepository;

    @Autowired
    CardRepository cardRepository;

    @Transactional
    public ArrayList<TaskDto> getTasks(int id) {
        ArrayList<TaskDto> taskDtos = new ArrayList<TaskDto>();
        Card card = cardRepository.findById(id);

        for (Task i: card.getTasks()) {
            taskDtos.add(new TaskDto(i.getId(),i.getDescription(),i.getDueDate()));
        }

        return taskDtos;
    }
}
