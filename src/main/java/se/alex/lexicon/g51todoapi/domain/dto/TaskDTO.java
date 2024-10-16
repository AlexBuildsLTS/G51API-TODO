package se.alex.lexicon.g51todoapi.domain.dto;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TaskDTO {
    private Long id;
    private String title;
    private String description;
    private LocalDate deadline;
    private boolean done;
    private PersonDTO person;
}
