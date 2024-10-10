package se.alex.lexicon.g51todoapi.domain.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PersonDTOForm {
    private String id;
    private String name;
    private String email;
    private String phone;
}
