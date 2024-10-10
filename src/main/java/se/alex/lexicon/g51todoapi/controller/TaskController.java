package se.alex.lexicon.g51todoapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.alex.lexicon.g51todoapi.domain.dto.TaskDTO;
import se.alex.lexicon.g51todoapi.domain.dto.TaskDTOForm;
import se.alex.lexicon.g51todoapi.domain.dto.TaskDTOView;
import se.alex.lexicon.g51todoapi.service.TaskService;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    private final TaskService taskService;

    public TaskController ( TaskService taskService ) {
        this.taskService = taskService;
    }

    @GetMapping
    public HttpEntity< List< TaskDTOView>> getAllTasks() {
        List < TaskDTOView > tasks = taskService.getAllTasks();
        return ResponseEntity.ok(tasks);
    }

    @GetMapping("/{id}")
    public ResponseEntity < TaskDTOView > getTaskById( @PathVariable Long id) {
        TaskDTOView task = taskService.getTaskById(id);
        return ResponseEntity.ok(task);
    }

    @PostMapping
    public HttpEntity< TaskDTOView> createTask( @RequestBody TaskDTOForm taskDTO) {
        TaskDTOView createdTask = taskService.createTask(taskDTO);
        return new ResponseEntity<>(createdTask, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TaskDTO> updateTask(@PathVariable Long id, @RequestBody TaskDTO taskDTO) {
        TaskDTO updatedTask = taskService.updateTask(id, taskDTO);
        return ResponseEntity.ok(updatedTask);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
        return ResponseEntity.noContent().build();
    }
}
