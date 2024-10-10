package se.alex.lexicon.g51todoapi.converter;

import org.springframework.stereotype.Component;
import se.alex.lexicon.g51todoapi.domain.dto.RoleDTOView;
import se.alex.lexicon.g51todoapi.entity.Role;

@Component
public class RoleConverter {

    public RoleDTOView toRoleDTOView(Role entity) {
        RoleDTOView.RoleDTOViewBuilder builder;
        builder = RoleDTOView.builder( );
        builder.id( Long.valueOf( Long.parseLong( String.valueOf( entity.getId( ) ) ) ) );
        builder.name( entity.getName( ) );
        return builder
                .build();
    }
}
