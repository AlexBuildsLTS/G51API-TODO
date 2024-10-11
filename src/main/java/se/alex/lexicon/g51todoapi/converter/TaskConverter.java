package se.alex.lexicon.g51todoapi.converter;

import lombok.*;
import org.jetbrains.annotations.Contract;
import org.springframework.stereotype.Component;
import se.alex.lexicon.g51todoapi.domain.dto.TaskDTO;
import se.alex.lexicon.g51todoapi.domain.dto.TaskDTOForm;
import se.alex.lexicon.g51todoapi.domain.dto.TaskDTOView;
import se.alex.lexicon.g51todoapi.entity.Person;
import se.alex.lexicon.g51todoapi.entity.Task;
@Getter
@ToString
@Component
@Setter
@EqualsAndHashCode
@Builder

public class TaskConverter {

    private final PersonConverter personConverter;

    @Contract(pure = true)
    private TaskConverter ( PersonConverter personConverter ) {
        this.personConverter = personConverter;
    }

    public TaskConverter( ) {
        this ( null );
    }


    public Task toTaskEntity(TaskDTOForm dtoForm, Person person) {
        return Task.builder()
                .title(dtoForm.getTitle())
                .description(dtoForm.getDescription())
                .deadline(dtoForm.getDeadline())
                .person(person)
                .done(false)
                .build();
    }

    public TaskDTOView toTaskDTOView(Task entity) {
        return TaskDTOView.builder()
                .id(entity.getId())
                .title(entity.getTitle())
                .description(entity.getDescription())
                .deadline(entity.getDeadline())
                .done(entity.isDone())
                .person(personConverter.toPersonDTOView(entity.getPerson()))
                .build();
    }

    public void updateTaskEntityFromDTO(TaskDTO taskDTO, Task task) {
        if (taskDTO == null || task == null) {
            return;
        }

        task.setTitle(taskDTO.getTitle());
        task.setDescription(taskDTO.getDescription());
        task.setDeadline(taskDTO.getDeadline());
        task.setDone(taskDTO.isDone());
        // You might need to handle updating the associated Person here if that's allowed
    }

    public TaskDTO toTaskDTO(Task entity) {
        if (entity == null) {
            return null;
        }

        return TaskDTO.builder()
                .id(entity.getId())
                .title(entity.getTitle())
                .description(entity.getDescription())
                .deadline(entity.getDeadline())
                .done(entity.isDone())
                .build();
    }
}
