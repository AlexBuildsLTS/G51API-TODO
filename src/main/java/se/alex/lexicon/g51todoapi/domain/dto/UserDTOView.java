package se.alex.lexicon.g51todoapi.domain.dto;

import lombok.*;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDTOView {
    private String email;
    private Set<RoleDTOView> roles;
}
