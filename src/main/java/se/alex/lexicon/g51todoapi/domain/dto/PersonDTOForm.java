package se.alex.lexicon.g51todoapi.domain.dto;

import lombok.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PersonDTOForm {
    private String name;
    private String email;
}
