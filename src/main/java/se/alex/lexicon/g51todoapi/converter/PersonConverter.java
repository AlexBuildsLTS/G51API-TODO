package se.alex.lexicon.g51todoapi.converter;

import org.springframework.stereotype.Component;
import se.alex.lexicon.g51todoapi.domain.dto.PersonDTOView;
import se.alex.lexicon.g51todoapi.entity.Person;

@Component
public class PersonConverter {

    public PersonDTOView toPersonDTOView( Person entity) {
        return PersonDTOView.builder()
                .id(entity.getId())
                .name(entity.getName())
                .email(entity.getUser() != null ? entity.getUser().getEmail() : null)
                .tasks(null)
                .build();
    }
}
