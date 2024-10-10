package se.alex.lexicon.g51todoapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.alex.lexicon.g51todoapi.domain.dto.TaskDTOForm;
import se.alex.lexicon.g51todoapi.domain.dto.TaskDTOView;
import se.alex.lexicon.g51todoapi.service.TaskService;
import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    private final TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping
    public ResponseEntity<TaskDTOView> createTask(@RequestBody TaskDTOForm taskDTOForm) {
        TaskDTOView taskDTOView = taskService.createTask(taskDTOForm);
        return new ResponseEntity<>(taskDTOView, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TaskDTOView> getTaskById(@PathVariable Long id) {
        TaskDTOView taskDTOView = taskService.getTaskById(id);
        return new ResponseEntity<>(taskDTOView, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<TaskDTOView>> getAllTasks() {
        List<TaskDTOView> tasks = taskService.getAllTasks();
        return new ResponseEntity<>(tasks, HttpStatus.OK);
    }

    @PutMapping("/{id}/done")
    public ResponseEntity<Void> markTaskAsDone(@PathVariable Long id) {
        taskService.markAsDone(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}