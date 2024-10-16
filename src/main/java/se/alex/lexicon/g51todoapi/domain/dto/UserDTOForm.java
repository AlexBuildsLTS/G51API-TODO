package se.alex.lexicon.g51todoapi.domain.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDTOForm {
    private String email;
    private String name;
    private String password;
}
