package se.alex.lexicon.g51todoapi.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import se.alex.lexicon.g51todoapi.converter.TaskConverter;
import se.alex.lexicon.g51todoapi.domain.dto.TaskDTO;
import se.alex.lexicon.g51todoapi.domain.dto.TaskDTOForm;
import se.alex.lexicon.g51todoapi.domain.dto.TaskDTOView;
import se.alex.lexicon.g51todoapi.entity.Person;
import se.alex.lexicon.g51todoapi.entity.Task;
import se.alex.lexicon.g51todoapi.exception.DataNotFoundException;
import se.alex.lexicon.g51todoapi.repository.PersonRepository;
import se.alex.lexicon.g51todoapi.repository.TaskRepository;
import se.alex.lexicon.g51todoapi.service.TaskService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;
    private final PersonRepository personRepository;
    private final TaskConverter taskConverter;

    @Autowired
    public TaskServiceImpl(TaskRepository taskRepository, PersonRepository personRepository, TaskConverter taskConverter) {
        this.taskRepository = taskRepository;
        this.personRepository = personRepository;
        this.taskConverter = taskConverter;
    }

    @Override
    @Transactional
    public TaskDTOView createTask(TaskDTOForm taskDTOForm) {
        Person person = personRepository.findById(taskDTOForm.getPersonId())
                .orElseThrow(() -> new DataNotFoundException("Person not found with ID: " + taskDTOForm.getPersonId()));
        Task task = taskConverter.toTaskEntity(taskDTOForm, person);
        Task savedTask = taskRepository.save(task);
        return taskConverter.toTaskDTOView(savedTask);
    }

    @Override
    public TaskDTOView getTaskById(Long id) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new DataNotFoundException("Task not found with ID: " + id));
        return taskConverter.toTaskDTOView(task);
    }

    @Override
    public List<TaskDTOView> getAllTasks() {
        return taskRepository.findAll().stream()
                .map(taskConverter::toTaskDTOView)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public void deleteTask(Long id) {
        if (!taskRepository.existsById(id)) {
            throw new DataNotFoundException("Task not found with ID: " + id);
        }
        taskRepository.deleteById(id);
    }

    @Override
    @Transactional
    public TaskDTO updateTask(Long id, TaskDTO taskDTO) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new DataNotFoundException("Task not found with ID: " + id));
        taskConverter.updateTaskEntityFromDTO(taskDTO, task);
        Task updatedTask = taskRepository.save(task);
        return taskConverter.toTaskDTO(updatedTask);
    }

    @Override
    @Transactional
    public void markAsDone(Long id) {
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new DataNotFoundException("Task not found with ID: " + id));
        task.setDone(true);
        taskRepository.save(task);
    }
}