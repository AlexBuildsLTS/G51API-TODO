package se.alex.lexicon.g51todoapi.converter;

import org.springframework.stereotype.Component;
import se.alex.lexicon.g51todoapi.domain.dto.RoleDTOView;
import se.alex.lexicon.g51todoapi.entity.Role;

@Component
public class RoleConverter {

    public RoleDTOView toRoleDTOView(Role entity) {
        return RoleDTOView.builder()
                .id( Long.valueOf ( Long.valueOf ( entity.getId() ) ) )
                .name(entity.getName())
                .build();
    }
}
