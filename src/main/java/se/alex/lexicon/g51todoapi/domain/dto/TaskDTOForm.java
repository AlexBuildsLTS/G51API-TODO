package se.alex.lexicon.g51todoapi.domain.dto;

import lombok.*;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TaskDTOForm {
    private String title;
    private String description;
    private LocalDate deadline;
    private Long personId;
}
