package se.alex.lexicon.g51todoapi.service;

import se.alex.lexicon.g51todoapi.domain.dto.TaskDTOForm;
import se.alex.lexicon.g51todoapi.domain.dto.TaskDTOView;

import java.util.List;

public interface TaskService {
    TaskDTOView createTask(TaskDTOForm taskDTOForm);

    TaskDTOView getTaskById(Long id);

    List<TaskDTOView> getAllTasks();

    void markAsDone(Long id);
}
