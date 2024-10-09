package se.alex.lexicon.g51todoapi.domain.dto;

import lombok.*;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PersonDTOView {
    private Long id;
    private String name;
    private String email;
    private Set<TaskDTOView> tasks;  // Linked tasks if needed
}
