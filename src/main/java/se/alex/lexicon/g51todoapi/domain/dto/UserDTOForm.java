package se.alex.lexicon.g51todoapi.domain.dto;

import lombok.*;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDTOForm {
    private String email;
    private String password;
    private Set<RoleDTOForm> roles;
}
