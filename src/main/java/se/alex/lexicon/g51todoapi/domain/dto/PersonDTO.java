package se.alex.lexicon.g51todoapi.domain.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PersonDTO {
    private Long id;
    private String name;
    private String email;
}
