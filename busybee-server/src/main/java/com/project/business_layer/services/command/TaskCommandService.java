package com.project.business_layer.services.command;

import com.project.business_layer.entity.Card;
import com.project.business_layer.entity.Task;
import com.project.persistence_layer.repository.CardRepository;
import com.project.persistence_layer.repository.TaskRepository;
import com.project.presentation_layer.dto.TaskDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class TaskCommandService {

    @Autowired
    TaskRepository taskRepository;

    @Autowired
    CardRepository cardRepository;

    @Transactional
    public int addTask(TaskDto taskDto, int id) {
        // find Card
        Card card = cardRepository.findById(id);

        // check task is not duplicate
        if (taskRepository.findByDescription(taskDto.getDescription()) != null)
            return -1;

        // create new task from user input
        Task task = new Task();
        task.setDescription(taskDto.getDescription());
        task.setDueDate(taskDto.getDueDate());

        // create link between card and new task
        task.setCardFK(card);
        card.getTasks().add(task);

        taskRepository.save(task);
        return 0;
    }

    @Transactional
    public int addTasks(List<TaskDto> taskDtos, int id) {
        // find Card
        Card card = cardRepository.findById(id);
        card.getTasks().clear();
        taskRepository.deleteAllByCardFK_Id(id);

        for (TaskDto i: taskDtos) {
            Task task = new Task();
            task.setDescription(i.getDescription());
            task.setDueDate(i.getDueDate());

            task.setCardFK(card);
            card.getTasks().add(task);
            taskRepository.save(task);
        }
        return 0;
    }
}
