package se.alex.lexicon.g51todoapi.service;

import org.springframework.transaction.annotation.Transactional;
import se.alex.lexicon.g51todoapi.domain.dto.UserDTOForm;
import se.alex.lexicon.g51todoapi.domain.dto.UserDTOView;

import java.util.List;

public interface UserService {

    UserDTOView register(UserDTOForm userDTOForm);

    UserDTOView getByEmail(String email);

    List<UserDTOView> getAllUsers();

    void disableUserByEmail(String email);

    void enableUserByEmail(String email);

    @Transactional
    void disableByEmail ( String email );

    @Transactional
    void enableByEmail ( String email );
}
