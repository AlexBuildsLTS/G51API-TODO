package se.alex.lexicon.g51todoapi.converter;

import lombok.*;
import org.springframework.stereotype.Component;
import se.alex.lexicon.g51todoapi.domain.dto.PersonDTOView;
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

    @org.jetbrains.annotations.Contract(pure = true)
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

    private static class PersonConverter {

        public PersonDTOView toPersonDTOView( Person ignoredPerson ) {
            return null;
        }
    }
}