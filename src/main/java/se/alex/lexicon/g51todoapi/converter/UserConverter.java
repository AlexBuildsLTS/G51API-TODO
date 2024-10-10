package se.alex.lexicon.g51todoapi.converter;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;
import se.alex.lexicon.g51todoapi.domain.dto.UserDTOForm;
import se.alex.lexicon.g51todoapi.domain.dto.UserDTOView;
import se.alex.lexicon.g51todoapi.entity.User;

@Component
@RequiredArgsConstructor
@Getter
@Setter

public final class UserConverter {

    private User user;

    public User toUserEntity( UserDTOForm userDTOForm) {
        return User.builder()
                .email(userDTOForm.getEmail())
                .name(userDTOForm.getName())
                .password(userDTOForm.getPassword()) // Note: Password should be hashed before saving
                .enabled(true) // Defaulting to enabled on creation
                .build();
    }

    public UserDTOView UserDTOView ( User user ) {
        this.user = user;
        return null;
    }

    public UserDTOView toUserDTOView ( User user ) {
        return null;
    }
}
